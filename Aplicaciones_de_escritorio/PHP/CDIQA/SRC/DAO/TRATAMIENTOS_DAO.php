<?php
	require("DAO.php");

	class TRATAMIENTOS_DAO extends DAO{

		public function insert($tratamientos){
			$Templates = new DataBase();
			$sql = "insert into tratamientos (
						NU_TRATAMIENTO, 
						ST_NOMBRE, ST_DESCRIPCION,
						MN_PRECIO)
						values (
						".$tratamientos->getNu_Tratamiento().",
						'".$tratamientos->getSt_Nombre()."',
						'".$tratamientos->getSt_Descripcion()."',
						".$tratamientos->getMn_Precio()."
						)";
		
			DAO::executeInsert($sql);
			return $tratamientos;
		}

		public function update($tratamientos){
			$Templates = new DataBase();
			$sql = "update tratamientos ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($tratamientos->getSt_Nombre() != "" && strlen($tratamientos->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$tratamientos->getSt_Nombre()."'";
			}

			if($tratamientos->getSt_Descripcion() != "" && strlen($tratamientos->getSt_Descripcion()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_DESCRIPCION = '".$tratamientos->getSt_Descripcion()."'";
			}

			if($tratamientos->getMn_Precio() != -1 && strlen($tratamientos->getMn_Precio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " MN_PRECIO = ".$tratamientos->getMn_Precio();
			}

			if($tratamientos->getNu_Tratamiento() != -1 && strlen($tratamientos->getNu_Tratamiento()) > 0){
				$constraint .= " NU_TRATAMIENTO = ".$tratamientos->getNu_Tratamiento();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $tratamientos;

		}

		public function consult($tratamientos){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$tratamientos_vo;

			$sql = "select * from tratamientos ";
			$constraint = "where";
			$consulta = "";
		
			if($tratamientos->getNu_Tratamiento() != -1 && strlen($tratamientos->getNu_Tratamiento()) > 0){
				$constraint .= " NU_TRATAMIENTO = ".$tratamientos->getNu_Tratamiento();
			}

			if($tratamientos->getSt_Nombre() != "" && strlen($tratamientos->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$tratamientos->getSt_Nombre()."'";
			}

			if($tratamientos->getSt_Descripcion() != "" && strlen($tratamientos->getSt_Descripcion()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_DESCRIPCION = '".$tratamientos->getSt_Descripcion()."'";
			}

			if($tratamientos->getMn_Precio() != -1 && strlen($tratamientos->getMn_Precio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " MN_PRECIO = ".$tratamientos->getMn_Precio();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;
			echo($consulta);
			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$tratamientos_vo = new TRATAMIENTOS_VO();
				$tratamientos_vo->setNu_tratamiento($row[0]);
				$tratamientos_vo->setSt_Nombre($row[1]);
				$tratamientos_vo->setSt_Descripcion($row[2]);
				$tratamientos_vo->setMn_Precio($row[3]);

				$arraylist->addItem($tratamientos_vo);
			}

			return $arraylist;
		}
	}	
?>