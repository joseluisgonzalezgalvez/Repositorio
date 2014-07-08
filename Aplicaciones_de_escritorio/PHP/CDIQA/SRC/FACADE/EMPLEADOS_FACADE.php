<?php
	require("../DAO/EMPLEADOS_DAO.php");
	require("../VO/EMPLEADOS_VO.php");
	class EMPLEADOS_FACADE extends EMPLEADOS_DAO{	

		public function insert($empleados){
			$EMPLEADOS_DAO = new EMPLEADOS_DAO();
			return $EMPLEADOS_DAO->insert($empleados);
		}

		public function update($empleados){
			$EMPLEADOS_DAO = new EMPLEADOS_DAO();
			return $EMPLEADOS_DAO->update($empleados);
		}

		public function consult($empleados){
			$EMPLEADOS_DAO = new EMPLEADOS_DAO();
			return $EMPLEADOS_DAO->consult($empleados);
		}
	}
?>