<?php
	require("../DAO/MEDICAMENTOS_DAO.php");
	require("../VO/MEDICAMENTOS_VO.php");
	class MEDICAMENTOS_FACADE extends MEDICAMENTOS_DAO{	

		public function insert($medicamentos){
			$MEDICAMENTOS_DAO = new MEDICAMENTOS_DAO();
			return $MEDICAMENTOS_DAO->insert($medicamentos);
		}

		public function update($medicamentos){
			$MEDICAMENTOS_DAO = new MEDICAMENTOS_DAO();
			return $MEDICAMENTOS_DAO->update($medicamentos);
		}

		public function consult($medicamentos){
			$MEDICAMENTOS_DAO = new MEDICAMENTOS_DAO();
			return $MEDICAMENTOS_DAO->consult($medicamentos);
		}
	}
?>