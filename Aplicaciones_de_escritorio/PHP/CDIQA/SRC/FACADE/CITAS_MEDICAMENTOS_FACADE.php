<?php
	require("../DAO/CITAS_MEDICAMENTOS_DAO.php");
	require("../VO/CITAS_MEDICAMENTOS_VO.php");
	class CITAS_MEDICAMENTOS_FACADE extends CITAS_MEDICAMENTOS_DAO{	

		public function insert($cita_medicamentos){
			$CITAS_MEDICAMENTOS_DAO = new CITAS_MEDICAMENTOS_DAO();
			return $CITAS_MEDICAMENTOS_DAO->insert($cita_medicamentos);
		}

		public function update($cita_medicamentos){
			$CITAS_MEDICAMENTOS_DAO = new CITAS_MEDICAMENTOS_DAO();
			return $CITAS_MEDICAMENTOS_DAO->update($cita_medicamentos);
		}

		public function consult($cita_medicamentos){
			$CITAS_MEDICAMENTOS_DAO = new CITAS_MEDICAMENTOS_DAO();
			return $CITAS_MEDICAMENTOS_DAO->consult($cita_medicamentos);
		}
	}
?>