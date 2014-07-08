<?php
	require("../DAO/TRANSFERENCIAS_SD_DAO.php");
	require("../VO/TRANSFERENCIAS_SD_VO.php");
	class TRANSFERENCIAS_SD_FACADE extends TRANSFERENCIAS_SD_DAO{	

		public function insert($transferencias_sd){
			$TRANSFERENCIAS_SD_DAO = new TRANSFERENCIAS_SD_DAO();
			return $TRANSFERENCIAS_SD_DAO->insert($transferencias_sd);
		}

		public function update($transferencias_sd){
			$TRANSFERENCIAS_SD_DAO = new TRANSFERENCIAS_SD_DAO();
			return $TRANSFERENCIAS_SD_DAO->update($transferencias_sd);
		}

		public function consult($transferencias_sd){
			$TRANSFERENCIAS_SD_DAO = new TRANSFERENCIAS_SD_DAO();
			return $TRANSFERENCIAS_SD_DAO->consult($transferencias_sd);
		}
	}
?>