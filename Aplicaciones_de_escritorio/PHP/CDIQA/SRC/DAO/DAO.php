<?php
	require("Templates.php");
	require("../UTIL/ArrayList.php");

	abstract class DAO  extends Templates{
		//echo($this->getDataBase());

		public static function executeInsert($sql){

			$Templates = new DataBase();
			$Templates->conectar(Templates::DATABASE,
				Templates::HOST,Templates::USER,Templates::PASSWORD);
			$Consulta = $Templates->consulta($sql);
		}

		public static function executeUpdate($sql){

			$Templates = new DataBase();
			$Templates->conectar(Templates::DATABASE,
				Templates::HOST,Templates::USER,Templates::PASSWORD);
			$Consulta = $Templates->consulta($sql);
		}

		public static function executeQuery($sql){
			$object;
			$arraylist= new ArrayList();
			$Templates = new DataBase();
			$Templates->conectar(Templates::DATABASE,
				Templates::HOST,Templates::USER,Templates::PASSWORD);
			$Consulta = $Templates->consulta($sql);
			return $Consulta;
		}
	}
?>