<?php
	require("DAO.php");

	class CITA_DAO extends DAO{

		public function insert($cita){
			$Templates = new DataBase();
			$sql = "insert into cita (NU_CITA, NU_FICHA, 
						NU_VISITAS, ST_FECHA) 
						values (
						".$cita->getNu_Cita().",
						".$cita->getNu_Ficha().",
						".$cita->getNu_Visitas().",
						'".$cita->getSt_Fecha()."'
						)";
		
			DAO::executeInsert($sql);
			return $cita;
		}	

		public function update($cita){
			$Templates = new DataBase();
			$sql = "update cita ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($cita->getNu_Ficha() != "" && strlen($cita->getNu_Ficha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FICHA = ".$cita->getNu_Ficha();
			}

			if($cita->getNu_Visitas() != "" && strlen($cita->getNu_Visitas()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_VISITAS = ".$cita->getNu_Visitas();
			}			

			if($cita->getSt_Fecha() != "" && strlen($cita->getSt_Fecha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_FECHA = '".$cita->getSt_Fecha()."'";
			}

			if($cita->getNu_Cita() != -1 && strlen($cita->getNu_Cita()) > 0){
				$constraint .= " NU_CITA = ".$cita->getNu_Cita();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $cita;

		}

		public function consult($cita){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$cita_vo;

			$sql = "select * from cita ";
			$constraint = "where";
			$consulta = "";
		
			if($cita->getNu_Cita() != -1 && strlen($cita->getNu_Cita()) > 0){
				$constraint .= " NU_CITA = ".$cita->getNu_Cita();
			}
			
			if($cita->getNu_Ficha() != -1 && strlen($cita->getNu_Ficha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FICHA = ".$cita->getNu_Ficha();
			}

			if($cita->getNu_Visitas() != -1 && strlen($cita->getNu_Visitas()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_VISITAS = ".$cita->getNu_Visitas();
			}

			if($cita->getSt_Fecha() != -1 && strlen($cita->getSt_Fecha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_FECHA = '".$cita->getSt_Fecha()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$cita_vo = new CITA_VO();
				$cita_vo->setNu_Cita($row[0]);
				$cita_vo->setNu_Ficha($row[1]);
				$cita_vo->setNu_Visitas($row[2]);
				$cita_vo->setSt_Fecha($row[3]);

				$arraylist->addItem($cita_vo);
			}

			return $arraylist;
		}
	}	
?>