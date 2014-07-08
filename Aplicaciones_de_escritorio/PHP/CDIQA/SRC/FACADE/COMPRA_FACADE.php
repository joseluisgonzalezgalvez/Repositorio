<?php
	require("../DAO/COMPRA_DAO.php");
	require("../VO/COMPRA_VO.php");
	class COMPRA_FACADE extends COMPRA_DAO{	

		public function insert($compra){
			$COMPRA_DAO = new COMPRA_DAO();
			return $COMPRA_DAO->insert($compra);
		}

		public function update($compra){
			$COMPRA_DAO = new COMPRA_DAO();
			return $COMPRA_DAO->update($compra);
		}

		public function consult($compra){
			$COMPRA_DAO = new COMPRA_DAO();
			return $COMPRA_DAO->consult($compra);
		}
	}	
?>