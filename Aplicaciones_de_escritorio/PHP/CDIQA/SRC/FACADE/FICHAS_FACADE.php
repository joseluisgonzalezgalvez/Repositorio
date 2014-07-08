<?php
	require("../DAO/FICHAS_DAO.php");
	require("../VO/FICHAS_VO.php");
	class FICHAS_FACADE extends FICHAS_DAO{	

		public function insert($fichas){
			$FICHAS_DAO = new FICHAS_DAO();
			return $FICHAS_DAO->insert($fichas);
		}

		public function update($fichas){
			$FICHAS_DAO = new FICHAS_DAO();
			return $FICHAS_DAO->update($fichas);
		}

		public function consult($fichas){
			$FICHAS_DAO = new FICHAS_DAO();
			return $FICHAS_DAO->consult($fichas);
		}
	}
?>