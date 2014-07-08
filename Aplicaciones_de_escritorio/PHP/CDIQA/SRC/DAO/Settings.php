<?php

	class DataBase{
			/*Variables de Conexion*/
			var $BaseDatos;
			var $Servidor;
			var $Usuario;
			var $Clave;
			
			/*Identificador de conexión y consulta*/
			var $Conexion_ID = 0;
			var $Consulta_ID = 0;
			
			/*Número de error y texto error*/
			var $Errno = 0;
			var $Error = "";
						
			//Conexión a la base de datos
			function conectar($bd, $host, $user, $pass){

				//echo("funcion conectar<br>");

				if($bd != "") $this -> BaseDatos = $bd;
				if($host != "") $this -> Servidor = $host;
				if($user != "") $this -> Usuario = $user;
				if($pass != "") $this -> Clave = $pass;
			
				// Conectamos al servidor
				//echo("<br>Servidor--> ".$this -> Servidor);
				//echo("<br>Usuario--> ".$this -> Usuario);
				//echo("<br>Clave--> ".$this -> Clave);


				$this -> Conexion_ID = mysql_connect($this -> Servidor, $this ->Usuario, $this -> Clave);
				

		
				if(!$this -> Conexion_ID){
					$this -> Error = "Ha fallado la conexión.";
					return 0;
				}
				
				//Seleccionamos la base de datos
				if(!mysql_select_db($this -> BaseDatos, $this -> Conexion_ID)){
					$this -> Error = "Imposible abrir ".$this->BaseDatos;
					return 0;
				}
				/* Si hemos tenido éxito conectando devuelve el identificador de la
				conexión, sino devuelve 0*/				

				return $this -> Conexion_ID;
			}
			
			//Función que ejecuta una consulta
			function consulta($sql = ""){

				//echo("<br>Conexion_ID: ".$this -> Conexion_ID);

				if($sql == ""){
					$this -> Error = "No ha especificado una consulta SQL";
					return 0;
				}
				
				//Ejecutamos la consulta
				$this -> Consulta_ID = mysql_query($sql, $this -> Conexion_ID);

				//echo("<br>Consulta_ID: ".$this -> Consulta_ID);

				if(!$this -> Consulta_ID){
					$this -> Errno = mysql_errno();
					$this -> Error = mysql_error();
				}
				
				/*Si hemos tenido éxito en la consulta devuelve el identificador
				de la conexión, sino devuelve 0*/
				return $this -> Consulta_ID;
			}
			
			/*Función que devuelve el número de campos de una consulta*/
			function numcampos(){
				return mysql_num_fields($this -> Consulta_ID);
			}
			/*Función que devuelve el número de registros de una consulta*/
			function numregistros(){
				return mysql_num_rows($this -> Consulta_ID);
			}
			
			public function num_rows($consulta){
				return mysql_num_rows($consulta);
			}
			
			/*Devuelve el nombre de un campo de una consulta*/
			function nombrecampo($numcampo){
				return mysql_field_name($this -> Consulta_ID, $numcampo);
			}
			public function fetch_array($consulta){
			   return mysql_fetch_array($consulta);
			}
			
			/*Muestra los datos de una consulta*/
			function verconsulta(){
				echo "<table border=1>\n";
				
				//Mostramos los nombres de los campos
				echo "<tr>";
				for($i = 0; $i < $this -> numcampos(); $i++){					
					echo "<th>".$this -> nombrecampo($i)."</th>";
				}
				echo "</tr>\n";
				
				//Mostramos los registros
				while($row = mysql_fetch_row($this -> Consulta_ID)){
					echo "<tr> \n";
					for($i = 0; $i < $this -> numcampos(); $i++){
						echo "<td>".$row[$i]."</td>\n";
					}
					echo "</tr>\n";					
				}
			}
			
			function verId($id){
				return  mysql_fetch_row($this -> Consulta_ID);
			}

		}
?>	