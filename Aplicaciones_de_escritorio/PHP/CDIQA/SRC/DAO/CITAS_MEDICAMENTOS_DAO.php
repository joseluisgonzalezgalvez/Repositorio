<?php
	require("DAO.php");

	class CITAS_MEDICAMENTOS_DAO extends DAO{

		public function insert($citas_medicamentos){
			$Templates = new DataBase();
			$sql = "insert into citas_medicamentos (NU_CITAS_MEDICAMENTOS, 
						NU_FICHA, NU_CITA, NU_MEDICAMENTO) 
						values (
						".$citas_medicamentos->getNu_Citas_Medicamentos().",
						".$citas_medicamentos->getNu_Ficha().",
						".$citas_medicamentos->getNu_Cita().",
						".$citas_medicamentos->getNu_Medicamento()."
						)";
		
			DAO::executeInsert($sql);
			return $citas_medicamentos;
		}	

		public function update($citas_medicamentos){
			$Templates = new DataBase();
			$sql = "update citas_medicamentos ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($citas_medicamentos->getNu_Ficha() != "" && strlen($citas_medicamentos->getNu_Ficha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FICHA = ".$citas_medicamentos->getNu_Ficha();
			}

			if($citas_medicamentos->getNu_Cita() != "" && strlen($citas_medicamentos->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$citas_medicamentos->getNu_Cita();
			}			

			if($citas_medicamentos->getNu_Medicamento() != -1 && strlen($citas_medicamentos->getNu_Medicamento()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_MEDICAMENTO = ".$citas_medicamentos->getNu_Medicamento();
			}

			if($citas_medicamentos->getNu_Citas_Medicamentos() != -1 && strlen($citas_medicamentos->getNu_Citas_Medicamentos()) > 0){
				$constraint .= " NU_CITAS_MEDICAMENTOS = ".$citas_medicamentos->getNu_Citas_Medicamentos();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $citas_medicamentos;

		}

		public function consult($citas_medicamentos){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$citas_medicamentos_vo;

			$sql = "select * from citas_medicamentos ";
			$constraint = "where";
			$consulta = "";
		
			if($citas_medicamentos->getNu_Citas_Medicamentos() != -1 && strlen($citas_medicamentos->getNu_Citas_Medicamentos()) > 0){
				$constraint .= " NU_CITAS_MEDICAMENTOS = ".$citas_medicamentos->getNu_Citas_Medicamentos();
			}
			
			if($citas_medicamentos->getNu_Ficha() != -1 && strlen($citas_medicamentos->getNu_Ficha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FICHA = ".$citas_medicamentos->getNu_Ficha();
			}

			if($citas_medicamentos->getNu_Cita() != -1 && strlen($citas_medicamentos->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$citas_medicamentos->getNu_Cita();
			}

			if($citas_medicamentos->getNu_Medicamento() != -1 && strlen($citas_medicamentos->getNu_Medicamento()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_MEDICAMENTO = ".$citas_medicamentos->getNu_Medicamento();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$citas_medicamentos_vo = new CITAS_MEDICAMENTOS_VO();
				$citas_medicamentos_vo->setNu_Citas_Medicamentos($row[0]);
				$citas_medicamentos_vo->setNu_Ficha($row[1]);
				$citas_medicamentos_vo->setNu_Cita($row[2]);
				$citas_medicamentos_vo->setNu_Medicamento($row[3]);

				$arraylist->addItem($citas_medicamentos_vo);
			}

			return $arraylist;
		}
	}	
?>