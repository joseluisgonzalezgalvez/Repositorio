<?php
	require("DAO.php");

	class CITAS_PRESCRIPCION_DAO extends DAO{

		public function insert($citas_prescripcion){
			$Templates = new DataBase();
			$sql = "insert into citas_prescripcion (NU_CITAS_PRESCRIPCION, 
						NU_FICHA, NU_CITA, ST_PRESCRIPCION) 
						values (
						".$citas_prescripcion->getNu_Citas_Prescripcion().",
						".$citas_prescripcion->getNu_Ficha().",
						".$citas_prescripcion->getNu_Cita().",
						'".$citas_prescripcion->getSt_Prescripcion()."'
						)";
		
			DAO::executeInsert($sql);
			return $citas_prescripcion;
		}	

		public function update($citas_prescripcion){
			$Templates = new DataBase();
			$sql = "update citas_prescripcion ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($citas_prescripcion->getNu_Ficha() != "" && strlen($citas_prescripcion->getNu_Ficha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FICHA = ".$citas_prescripcion->getNu_Ficha();
			}

			if($citas_prescripcion->getNu_Cita() != "" && strlen($citas_prescripcion->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$citas_prescripcion->getNu_Cita();
			}			

			if($citas_prescripcion->getSt_Prescripcion() != "" && strlen($citas_prescripcion->getSt_Prescripcion()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_PRESCRIPCION = '".$citas_prescripcion->getSt_Prescripcion()."'";
			}

			if($citas_prescripcion->getNu_Citas_Prescripcion() != -1 && strlen($citas_prescripcion->getNu_Citas_Prescripcion()) > 0){
				$constraint .= " NU_CITAS_PRESCRIPCION = ".$citas_prescripcion->getNu_Citas_Prescripcion();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $citas_prescripcion;

		}

		public function consult($citas_prescripcion){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$citas_prescripcion_vo;

			$sql = "select * from citas_prescripcion ";
			$constraint = "where";
			$consulta = "";
		
			if($citas_prescripcion->getNu_Citas_Prescripcion() != -1 && strlen($citas_prescripcion->getNu_Citas_Prescripcion()) > 0){
				$constraint .= " NU_CITAS_PRESCRIPCION = ".$citas_prescripcion->getNu_Citas_Prescripcion();
			}
			
			if($citas_prescripcion->getNu_Ficha() != -1 && strlen($citas_prescripcion->getNu_Ficha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FICHA = ".$citas_prescripcion->getNu_Ficha();
			}

			if($citas_prescripcion->getNu_Cita() != -1 && strlen($citas_prescripcion->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$citas_prescripcion->getNu_Cita();
			}

			if($citas_prescripcion->getSt_Prescripcion() != "" && strlen($citas_prescripcion->getSt_Prescripcion()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_PRESCRIPCION = '".$citas_prescripcion->getSt_Prescripcion()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$citas_prescripcion_vo = new CITAS_PRESCRIPCION_VO();
				$citas_prescripcion_vo->setNu_Citas_Prescripcion($row[0]);
				$citas_prescripcion_vo->setNu_Ficha($row[1]);
				$citas_prescripcion_vo->setNu_Cita($row[2]);
				$citas_prescripcion_vo->setSt_Prescripcion($row[3]);

				$arraylist->addItem($citas_prescripcion_vo);
			}

			return $arraylist;
		}
	}	
?>