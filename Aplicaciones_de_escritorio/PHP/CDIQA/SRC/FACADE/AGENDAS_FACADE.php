<?php
	require("../DAO/AGENDAS_DAO.php");
	class AGENDAS_FACADE extends AGENDAS_DAO{	

		public function insert($agendas){
			$AGENDAS_DAO = new AGENDAS_DAO();
			return $AGENDAS_DAO->insert($agendas);
		}

		public function update($agendas){
			$AGENDAS_DAO = new AGENDAS_DAO();
			return $AGENDAS_DAO->update($agendas);
		}

		public function consult($agendas){
			$AGENDAS_DAO = new AGENDAS_DAO();
			return $AGENDAS_DAO->consult($agendas);
		}
	}
?>