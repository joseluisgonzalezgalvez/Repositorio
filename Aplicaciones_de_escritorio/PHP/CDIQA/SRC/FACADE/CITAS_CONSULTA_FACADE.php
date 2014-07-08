<?php
	require("../DAO/CITAS_CONSULTA_DAO.php");
	require("../VO/CITAS_CONSULTA_VO.php");
	class CITAS_CONSULTA_FACADE extends CITAS_CONSULTA_DAO{	

		public function insert($cita_consulta){
			$CITAS_CONSULTA_DAO = new CITAS_CONSULTA_DAO();
			return $CITAS_CONSULTA_DAO->insert($cita_consulta);
		}

		public function update($cita_consulta){
			$CITAS_CONSULTA_DAO = new CITAS_CONSULTA_DAO();
			return $CITAS_CONSULTA_DAO->update($cita_consulta);
		}

		public function consult($cita_consulta){
			$CITAS_CONSULTA_DAO = new CITAS_CONSULTA_DAO();
			return $CITAS_CONSULTA_DAO->consult($cita_consulta);
		}
	}
?>