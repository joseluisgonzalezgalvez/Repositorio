<?php
	require("DAO.php");

	class DISTRIBUIDOR_DAO extends DAO{

		public function insert($distribuidor){
			$Templates = new DataBase();
			$sql = "insert into distribuidor (NU_DISTRIBUIDOR, 
						ST_NOMBRE, ST_DIRECCION, ST_TELEFONO, 
						ST_CORREO) 
						values (
						".$distribuidor->getNu_Distribuidor().",
						'".$distribuidor->getSt_Nombre()."',
						'".$distribuidor->getSt_Direccion()."',
						'".$distribuidor->getSt_Telefono()."',
						'".$distribuidor->getSt_Correo()."'
						)";
		
			DAO::executeInsert($sql);
			return $distribuidor;
		}	

		public function update($distribuidor){
			$Templates = new DataBase();
			$sql = "update distribuidor ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($distribuidor->getSt_Nombre() != "" && strlen($distribuidor->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$distribuidor->getSt_Nombre()."'";
			}

			if($distribuidor->getSt_Direccion() != "" && strlen($distribuidor->getSt_Direccion()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_DIRECCION = '".$distribuidor->getSt_Direccion()."'";
			}

			if($distribuidor->getSt_Telefono() != "" && strlen($distribuidor->getSt_Telefono()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_TELEFONO = '".$distribuidor->getSt_Telefono()."'";
			}

			if($distribuidor->getSt_Correo() != "" && strlen($distribuidor->getSt_Correo()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_CORREO = '".$distribuidor->getSt_Correo()."'";
			}

			if($distribuidor->getNu_Distribuidor() != -1 && strlen($distribuidor->getNu_Distribuidor()) > 0){
				$constraint .= " NU_DISTRIBUIDOR = ".$distribuidor->getNu_Distribuidor();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $distribuidor;

		}

		public function consult($distribuidor){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$distribuidor_vo;

			$sql = "select * from distribuidor ";
			$constraint = "where";
			$consulta = "";
		
			if($distribuidor->getNu_Distribuidor() != -1 && strlen($distribuidor->getNu_Distribuidor()) > 0){
				$constraint .= " NU_DISTRIBUIDOR = ".$distribuidor->getNu_Distribuidor();
			}
			
			if($distribuidor->getSt_Nombre() != "" && strlen($distribuidor->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$distribuidor->getSt_Nombre()."'";
			}

			if($distribuidor->getSt_Direccion() != "" && strlen($distribuidor->getSt_Direccion()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_DIRECCION = '".$distribuidor->getSt_Direccion()."'";
			}

			if($distribuidor->getSt_Telefono() != "" && strlen($distribuidor->getSt_Telefono()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_TELEFONO = '".$distribuidor->getSt_Telefono()."'";
			}

			if($distribuidor->getSt_Correo() != "" && strlen($distribuidor->getSt_Correo()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_CORREO = '".$distribuidor->getSt_Correo()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$distribuidor_vo = new DISTRIBUIDOR_VO();
				$distribuidor_vo->setNu_Distribuidor($row[0]);
				$distribuidor_vo->setSt_Nombre($row[1]);
				$distribuidor_vo->setSt_Direccion($row[2]);
				$distribuidor_vo->setSt_Telefono($row[3]);
				$distribuidor_vo->setSt_Correo($row[4]);

				$arraylist->addItem($distribuidor_vo);
			}

			return $arraylist;
		}
	}	
?>