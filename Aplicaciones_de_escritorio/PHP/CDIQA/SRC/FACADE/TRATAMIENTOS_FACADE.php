<?php
	require("../DAO/TRATAMIENTOS_DAO.php");
	require("../VO/TRATAMIENTOS_VO.php");
	class TRATAMIENTOS_FACADE extends TRATAMIENTOS_DAO{	

		public function insert($tratamientos){
			$TRATAMIENTOS_DAO = new TRATAMIENTOS_DAO();
			return $TRATAMIENTOS_DAO->insert($tratamientos);
		}

		public function update($tratamientos){
			$TRATAMIENTOS_DAO = new TRATAMIENTOS_DAO();
			return $TRATAMIENTOS_DAO->update($tratamientos);
		}

		public function consult($tratamientos){
			$TRATAMIENTOS_DAO = new TRATAMIENTOS_DAO();
			return $TRATAMIENTOS_DAO->consult($tratamientos);
		}
	}	
?>
