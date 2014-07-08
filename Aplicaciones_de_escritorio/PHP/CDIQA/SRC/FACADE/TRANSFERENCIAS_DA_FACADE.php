<?php
	require("../DAO/TRANSFERENCIAS_DA_DAO.php");
	require("../VO/TRANSFERENCIAS_DA_VO.php");
	class TRANSFERENCIAS_DA_FACADE extends TRANSFERENCIAS_DA_DAO{	

		public function insert($transferencias_da){			
			$TRANSFERENCIAS_DA_DAO = new TRANSFERENCIAS_DA_DAO();
			return $TRANSFERENCIAS_DA_DAO->insert($transferencias_da);
		}

		public function update($transferencias_da){
			$TRANSFERENCIAS_DA_DAO = new TRANSFERENCIAS_DA_DAO();
			return $TRANSFERENCIAS_DA_DAO->update($transferencias_da);
		}

		public function consult($transferencias_da){
			$TRANSFERENCIAS_DA_DAO = new TRANSFERENCIAS_DA_DAO();
			return $TRANSFERENCIAS_DA_DAO->consult($transferencias_da);
		}
	}	
?>