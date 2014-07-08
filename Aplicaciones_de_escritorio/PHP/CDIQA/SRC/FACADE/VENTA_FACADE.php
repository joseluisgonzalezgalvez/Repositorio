<?php
	require("../DAO/VENTA_DAO.php");
	require("../VO/VENTA_VO.php");
	class VENTA_FACADE extends VENTA_DAO{	

		public function insert($venta){
			$VENTA_DAO = new VENTA_DAO();
			return $VENTA_DAO->insert($venta);
		}

		public function update($venta){
			$VENTA_DAO = new VENTA_DAO();
			return $VENTA_DAO->update($venta);
		}

		public function consult($venta){
			$VENTA_DAO = new VENTA_DAO();
			return $VENTA_DAO->consult($venta);
		}
	}
?>