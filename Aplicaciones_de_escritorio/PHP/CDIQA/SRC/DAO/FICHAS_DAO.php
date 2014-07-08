<?php
	require("DAO.php");

	class FICHAS_DAO extends DAO{

		public function insert($fichas){			
			$Templates = new DataBase();
			$sql = "insert into fichas (NU_FICHA, 
						NU_PACIENTE, NU_CITAS, 
						ST_FECHA)
						values (
						".$fichas->getNu_Ficha().",
						".$fichas->getNu_Paciente().",
						".$fichas->getNu_Citas().",
						'".$fichas->getSt_Fecha()."'
						)";

			DAO::executeInsert($sql);
			return $fichas;
		}

		public function update($fichas){
			$Templates = new DataBase();
			$sql = "update fichas ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($fichas->getNu_Paciente() != -1 && strlen($fichas->getNu_Paciente()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_PACIENTE = ".$fichas->getNu_Paciente();
			}

			if($fichas->getNu_Citas() != -1 && strlen($fichas->getNu_Citas()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITAS = ".$fichas->getNu_Citas();
			}

			if($fichas->getSt_Fecha() != "" && strlen($fichas->getSt_Fecha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_FECHA = '".$fichas->getSt_Fecha()."'";
			}

			if($fichas->getNu_Ficha() != -1 && strlen($fichas->getNu_Ficha()) > 0){
				$constraint .= " NU_FICHA= ".$fichas->getNu_Ficha();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $fichas;

		}

		public function consult($fichas){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$fichas_vo;

			$sql = "select * from fichas ";
			$constraint = "where";
			$consulta = "";
		
			if($fichas->getNu_Ficha() != -1 && strlen($fichas->getNu_Ficha()) > 0){
				$constraint .= " NU_FICHA = ".$fichas->getNu_Ficha();
			}
			
			if($fichas->getNu_Paciente() != "" && strlen($fichas->getNu_Paciente()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_PACIENTE = ".$fichas->getNu_Paciente();
			}

			if($fichas->getNu_Citas() != "" && strlen($fichas->getNu_Citas()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITAS = ".$fichas->getNu_Citas();
			}

			if($fichas->getSt_Fecha() != "" && strlen($fichas->getSt_Fecha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_FECHA = '".$fichas->getSt_Fecha()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$fichas_vo = new FICHAS_VO();
				$fichas_vo->setNu_Ficha($row[0]);
				$fichas_vo->setNu_Paciente($row[1]);
				$fichas_vo->setNu_Citas($row[2]);
				$fichas_vo->setSt_Fecha($row[3]);

				$arraylist->addItem($fichas_vo);
			}

			return $arraylist;
		}
	}	
?>