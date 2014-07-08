<?php
	require("../DAO/CITAS_PRESCRIPCION_DAO.php");
	require("../VO/CITAS_PRESCRIPCION_VO.php");
	class CITAS_PRESCRIPCION_FACADE extends CITAS_PRESCRIPCION_DAO{	

		public function insert($cita_prescripcion){
			$CITAS_PRESCRIPCION_DAO = new CITAS_PRESCRIPCION_DAO();
			return $CITAS_PRESCRIPCION_DAO->insert($cita_prescripcion);
		}

		public function update($cita_prescripcion){
			$CITAS_PRESCRIPCION_DAO = new CITAS_PRESCRIPCION_DAO();
			return $CITAS_PRESCRIPCION_DAO->update($cita_prescripcion);
		}

		public function consult($cita_prescripcion){
			$CITAS_PRESCRIPCION_DAO = new CITAS_PRESCRIPCION_DAO();
			return $CITAS_PRESCRIPCION_DAO->consult($cita_prescripcion);
		}
	}		
?>