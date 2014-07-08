<?php
	require("DAO.php");

	class CITAS_CONSULTA_DAO extends DAO{

		public function insert($citas_consulta){
			$Templates = new DataBase();
			$sql = "insert into citas_consulta (NU_CITAS_CONSULTA, NU_FICHA, 
						NU_CITA, ST_CONSULTA) 
						values (
						".$citas_consulta->getNu_Citas_Consulta().",
						".$citas_consulta->getNu_Ficha().",
						".$citas_consulta->getNu_Cita().",
						'".$citas_consulta->getSt_Consulta()."'
						)";
		
			DAO::executeInsert($sql);
			return $citas_consulta;
		}	

		public function update($citas_consulta){
			$Templates = new DataBase();
			$sql = "update citas_consulta ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($citas_consulta->getNu_Ficha() != "" && strlen($citas_consulta->getNu_Ficha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FICHA = ".$citas_consulta->getNu_Ficha();
			}

			if($citas_consulta->getNu_Cita() != "" && strlen($citas_consulta->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$citas_consulta->getNu_Cita();
			}			

			if($citas_consulta->getSt_Consulta() != "" && strlen($citas_consulta->getSt_Consulta()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_CONSULTA = '".$citas_consulta->getSt_Consulta()."'";
			}

			if($citas_consulta->getNu_Citas_Consulta() != -1 && strlen($citas_consulta->getNu_Citas_Consulta()) > 0){
				$constraint .= " NU_CITAS_CONSULTA = ".$citas_consulta->getNu_Citas_Consulta();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $citas_consulta;

		}

		public function consult($citas_consulta){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$citas_consulta_vo;

			$sql = "select * from citas_consulta ";
			$constraint = "where";
			$consulta = "";
		
			if($citas_consulta->getNu_Citas_Consulta() != -1 && strlen($citas_consulta->getNu_Citas_Consulta()) > 0){
				$constraint .= " NU_CITAS_CONSULTA = ".$citas_consulta->getNu_Citas_Consulta();
			}
			
			if($citas_consulta->getNu_Ficha() != -1 && strlen($citas_consulta->getNu_Ficha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FICHA = ".$citas_consulta->getNu_Ficha();
			}

			if($citas_consulta->getNu_Cita() != -1 && strlen($citas_consulta->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$citas_consulta->getNu_Cita();
			}

			if($citas_consulta->getSt_Consulta() != -1 && strlen($citas_consulta->getSt_Consulta()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_CONSULTA = '".$citas_consulta->getSt_Consulta()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$citas_consulta_vo = new CITAS_CONSULTA_VO();
				$citas_consulta_vo->setNu_Citas_Consulta($row[0]);
				$citas_consulta_vo->setNu_Ficha($row[1]);
				$citas_consulta_vo->setNu_Cita($row[2]);
				$citas_consulta_vo->setSt_Consulta($row[3]);

				$arraylist->addItem($citas_consulta_vo);
			}

			return $arraylist;
		}
	}	
?>