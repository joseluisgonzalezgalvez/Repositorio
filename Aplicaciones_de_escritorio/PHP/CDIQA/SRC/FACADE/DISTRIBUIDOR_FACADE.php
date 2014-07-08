<?php
	require("../DAO/DISTRIBUIDOR_DAO.php");
	require("../VO/DISTRIBUIDOR_VO.php");
	class DISTRIBUIDOR_FACADE extends DISTRIBUIDOR_DAO{	

		public function insert($distribuidor){
			$DISTRIBUIDOR_DAO = new DISTRIBUIDOR_DAO();
			return $DISTRIBUIDOR_DAO->insert($distribuidor);
		}

		public function update($distribuidor){
			$DISTRIBUIDOR_DAO = new DISTRIBUIDOR_DAO();
			return $DISTRIBUIDOR_DAO->update($distribuidor);
		}

		public function consult($distribuidor){
			$DISTRIBUIDOR_DAO = new DISTRIBUIDOR_DAO();
			return $DISTRIBUIDOR_DAO->consult($distribuidor);
		}
	}
?>