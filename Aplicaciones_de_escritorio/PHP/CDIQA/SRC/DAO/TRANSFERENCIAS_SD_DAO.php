<?php
	require("DAO.php");

	class TRANSFERENCIAS_SD_DAO extends DAO{

		public function insert($transferencias_sd){
			$Templates = new DataBase();
			$sql = "insert into transferencias_sd (
						NU_TRANSFERENCIAS_SD, 
						NU_FOLIO)
						values (
						".$transferencias_sd->getNu_transferencias_sd().",
						".$transferencias_sd->getNu_Folio()."
						)";
			DAO::executeInsert($sql);
			return $transferencias_sd;
		}

		public function update($transferencias_sd){
			$Templates = new DataBase();
			$sql = "update transferencias_sd ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($transferencias_sd->getNu_Folio() != -1 && strlen($transferencias_sd->getNu_Folio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FOLIO = ".$transferencias_sd->getNu_Folio();
			}

			if($transferencias_sd->getNu_Transferencias_SD() != -1 && strlen($transferencias_sd->getNu_Transferencias_SD()) > 0){
				$constraint .= " NU_TRANSFERENCIAS_SD = ".$transferencias_sd->getNu_Transferencias_SD();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $transferencias_sd;

		}

		public function consult($transferencias_sd){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$transferencias_sd_vo;

			$sql = "select * from transferencias_sd ";
			$constraint = "where";
			$consulta = "";
		
			if($transferencias_sd->getNu_Transferencias_SD() != -1 && strlen($transferencias_sd->getNu_Transferencias_SD()) > 0){
				$constraint .= " NU_TRANSFERENCIAS_SD = ".$transferencias_sd->getNu_Transferencias_SD();
			}

			if($transferencias_sd->getNu_Folio() != -1 && strlen($transferencias_sd->getNu_Folio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FOLIO = ".$transferencias_sd->getNu_Folio();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$transferencias_sd_vo = new TRANSFERENCIAS_SD_VO();
				$transferencias_sd_vo->setNu_transferencias_sd($row[0]);
				$transferencias_sd_vo->setNu_Folio($row[1]);

				$arraylist->addItem($transferencias_sd_vo);
			}

			return $arraylist;
		}
	}	
?>