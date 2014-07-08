<?php
	require("DAO.php");

	class TRANSFERENCIAS_DA_DAO extends DAO{

		public function insert($transferencias_da){
			$Templates = new DataBase();
			$sql = "insert into transferencias_da (
						NU_TRANSFERENCIAS_DA, 
						NU_FOLIO, NU_CITA)
						values (
						".$transferencias_da->getNu_Transferencias_DA().",
						".$transferencias_da->getNu_Folio().",
						".$transferencias_da->getNu_Cita()."
						)";
			DAO::executeInsert($sql);
			return $transferencias_da;
		}

		public function update($transferencias_da){
			$Templates = new DataBase();
			$sql = "update transferencias_da ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($transferencias_da->getNu_Folio() != -1 && strlen($transferencias_da->getNu_Folio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FOLIO = ".$transferencias_da->getNu_Folio();
			}

			if($transferencias_da->getNu_Cita() != -1 && strlen($transferencias_da->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$transferencias_da->getNu_Cita();
			}

			if($transferencias_da->getNu_Transferencias_DA() != -1 && strlen($transferencias_da->getNu_Transferencias_DA()) > 0){
				$constraint .= " NU_TRANSFERENCIAS_DA = ".$transferencias_da->getNu_Transferencias_DA();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $transferencias_da;

		}

		public function consult($transferencias_da){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$transferencias_da_vo;

			$sql = "select * from transferencias_da ";
			$constraint = "where";
			$consulta = "";
		
			if($transferencias_da->getNu_Transferencias_DA() != -1 && strlen($transferencias_da->getNu_Transferencias_DA()) > 0){
				$constraint .= " NU_TRANSFERENCIAS_DA = ".$transferencias_da->getNu_Transferencias_DA();
			}

			if($transferencias_da->getNu_Folio() != -1 && strlen($transferencias_da->getNu_Folio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FOLIO = ".$transferencias_da->getNu_Folio();
			}

			if($transferencias_da->getNu_Cita() != -1 && strlen($transferencias_da->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$transferencias_da->getNu_Cita();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$transferencias_da_vo = new TRANSFERENCIAS_DA_VO();
				$transferencias_da_vo->setNu_Transferencias_DA($row[0]);
				$transferencias_da_vo->setNu_Folio($row[1]);
				$transferencias_da_vo->setNu_Cita($row[2]);

				$arraylist->addItem($transferencias_da_vo);
			}

			return $arraylist;
		}
	}	
?>