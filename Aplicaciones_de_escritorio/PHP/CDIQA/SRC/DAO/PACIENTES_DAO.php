<?php
	require("DAO.php");

	class PACIENTES_DAO extends DAO{

		public function insert($pacientes){
			$Templates = new DataBase();
			$sql = "insert into pacientes (NU_PACIENTE, 
						ST_NOMBRE, ST_APELLIDOS, 
						NU_EDAD, ST_SEXO, FL_PESO, 
						FL_TALLA, ST_TELEFONO, 
						ST_CORREO, ST_DOMICILIO)
						values (
						".$pacientes->getNu_Paciente().",
						'".$pacientes->getSt_Nombre()."',
						'".$pacientes->getSt_Apellidos()."',
						".$pacientes->getNu_Edad().",
						'".$pacientes->getSt_Sexo()."',
						".$pacientes->getFl_Peso().",
						".$pacientes->getFl_Talla().",
						'".$pacientes->getSt_Telefono()."',
						'".$pacientes->getSt_Correo()."',
						'".$pacientes->getSt_Domicilio()."'
						)";
		
			DAO::executeInsert($sql);
			return $pacientes;
		}

		public function update($pacientes){
			$Templates = new DataBase();
			$sql = "update pacientes ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($pacientes->getSt_Nombre() != "" && strlen($pacientes->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$pacientes->getSt_Nombre()."'";
			}

			if($pacientes->getSt_Apellidos() != "" && strlen($pacientes->getSt_Apellidos()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_APELLIDOS = '".$pacientes->getSt_Apellidos()."'";
			}			

			if($pacientes->getNu_Edad() != -1 && strlen($pacientes->getNu_Edad()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_EDAD = ".$pacientes->getNu_Edad();
			}

			if($pacientes->getSt_Sexo() != "" && strlen($pacientes->getSt_Sexo()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_SEXO = '".$pacientes->getSt_Sexo()."'";
			}

			if($pacientes->getFl_Peso() != -1 && strlen($pacientes->getFl_Peso()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " FL_PESO = ".$pacientes->getFl_Peso();
			}

			if($pacientes->getFl_Talla() != -1 && strlen($pacientes->getFl_Talla()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " FL_TALLA = ".$pacientes->getFl_Talla();
			}

			if($pacientes->getSt_Telefono() != "" && strlen($pacientes->getSt_Telefono()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_TELEFONO = '".$pacientes->getSt_Telefono()."'";
			}

			if($pacientes->getSt_Correo() != "" && strlen($pacientes->getSt_Correo()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_CORREO = '".$pacientes->getSt_Correo()."'";
			}

			if($pacientes->getSt_Domicilio() != "" && strlen($pacientes->getSt_Domicilio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_DOMICILIO = '".$pacientes->getSt_Domicilio()."'";
			}

			if($pacientes->getNu_Paciente() != -1 && strlen($pacientes->getNu_Paciente()) > 0){
				$constraint .= " NU_PACIENTE = ".$pacientes->getNu_Paciente();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $pacientes;

		}

		public function consult($pacientes){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$pacientes_vo;

			$sql = "select * from pacientes ";
			$constraint = "where";
			$consulta = "";
		
			echo("Peso en el DAO: ".$pacientes->getFl_Peso()."<br>");

			if($pacientes->getNu_Paciente() != -1 && strlen($pacientes->getNu_Paciente()) > 0){
				$constraint .= " NU_PACIENTE = ".$pacientes->getNu_Paciente();
			}

			if($pacientes->getSt_Nombre() != "" && strlen($pacientes->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$pacientes->getSt_Nombre()."'";
			}

			if($pacientes->getSt_Apellidos() != "" && strlen($pacientes->getSt_Apellidos()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_APELLIDOS = '".$pacientes->getSt_Apellidos()."'";
			}

			if($pacientes->getNu_Edad() != -1 && strlen($pacientes->getNu_Edad()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_EDAD = ".$pacientes->getNu_Edad();
			}

			if($pacientes->getSt_Sexo() != -1 && strlen($pacientes->getSt_Sexo()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_SEXO = '".$pacientes->getSt_Sexo()."'";
			}

			if($pacientes->getFl_Peso() != -1 && strlen($pacientes->getFl_Peso()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " FL_PESO = ".$pacientes->getFl_Peso();
			}

			if($pacientes->getFl_Talla() != -1 && strlen($pacientes->getFl_Talla()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " FL_TALLA = ".$pacientes->getFl_Talla();
			}

			if($pacientes->getSt_Telefono() != -1 && strlen($pacientes->getSt_Telefono()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_TELEFONO = '".$pacientes->getSt_Telefono()."'";
			}

			if($pacientes->getSt_Correo() != -1 && strlen($pacientes->getSt_Correo()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_CORREO = '".$pacientes->getSt_Correo()."'";
			}

			if($pacientes->getSt_DOMICILIO() != -1 && strlen($pacientes->getSt_DOMICILIO()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_DOMICILIO = '".$pacientes->getSt_DOMICILIO()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			echo($consulta);
			
			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$pacientes_vo = new PACIENTES_VO();
				$pacientes_vo->setNu_Paciente($row[0]);
				$pacientes_vo->setSt_Nombre($row[1]);
				$pacientes_vo->setSt_Apellidos($row[2]);
				$pacientes_vo->setNu_Edad($row[3]);
				$pacientes_vo->setSt_Sexo($row[4]);
				$pacientes_vo->setFl_Peso($row[5]);
				$pacientes_vo->setFl_Talla($row[6]);
				$pacientes_vo->setSt_Telefono($row[7]);
				$pacientes_vo->setSt_Correo($row[8]);
				$pacientes_vo->setSt_Domicilio($row[9]);

				$arraylist->addItem($pacientes_vo);
			}

			return $arraylist;
		}
	}	
?>