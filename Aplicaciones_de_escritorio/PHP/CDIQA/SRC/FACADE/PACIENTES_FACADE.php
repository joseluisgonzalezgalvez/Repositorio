<?php
	require("../DAO/PACIENTES_DAO.php");
	require("../VO/PACIENTES_VO.php");
	class PACIENTES_FACADE extends PACIENTES_DAO{	

		public function insert($pacientes){
			$PACIENTES_DAO = new PACIENTES_DAO();
			return $PACIENTES_DAO->insert($pacientes);
		}

		public function update($pacientes){
			$PACIENTES_DAO = new PACIENTES_DAO();
			return $PACIENTES_DAO->update($pacientes);
		}

		public function consult($pacientes){

			echo("Peso en la consulta: ".$pacientes->getFl_Peso()."<br>");
			$PACIENTES_DAO = new PACIENTES_DAO();
			return $PACIENTES_DAO->consult($pacientes);
		}
	}	
?>