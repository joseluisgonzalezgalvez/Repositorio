<?php	
	require("../DAO/CITAS_TRATAMIENTOS_DAO.php");
	require("../VO/CITAS_TRATAMIENTOS_VO.php");
	class CITAS_TRATAMIENTOS_FACADE extends CITAS_TRATAMIENTOS_DAO{	

		public function insert($cita_tratamientos){
			$CITAS_TRATAMIENTOS_DAO = new CITAS_TRATAMIENTOS_DAO();
			return $CITAS_TRATAMIENTOS_DAO->insert($cita_tratamientos);
		}

		public function update($cita_tratamientos){
			$CITAS_TRATAMIENTOS_DAO = new CITAS_TRATAMIENTOS_DAO();
			return $CITAS_TRATAMIENTOS_DAO->update($cita_tratamientos);
		}

		public function consult($cita_tratamientos){
			$CITAS_TRATAMIENTOS_DAO = new CITAS_TRATAMIENTOS_DAO();
			return $CITAS_TRATAMIENTOS_DAO->consult($cita_tratamientos);
		}
	}

	$citas_tratamientos = new CITAS_TRATAMIENTOS_VO();
	$citas_tratamientos->setNu_Citas_Tratamientos(1);
	$citas_tratamientos->setNu_Ficha(1);
	$citas_tratamientos->setNu_Cita(1);
	$citas_tratamientos->setNu_Tratamiento(1);
	
	$class = new CITAS_TRATAMIENTOS_FACADE();
	//$class->update($citas_tratamientos);
	$arraylist = $class->consult($citas_tratamientos);
	echo("Cantidad: ".$arraylist->size());
	for($i=0; $i<$arraylist->size(); $i++){
		$citas_tratamientos = $arraylist->item($i);
		echo("<br><br>".$citas_tratamientos->GetNu_Citas_Tratamientos());		
		echo("<br><br>").$citas_tratamientos->getNu_Ficha();
		echo("<br><br>".$citas_tratamientos->getNu_Cita());
		echo("<br><br>".$citas_tratamientos->GetNu_Tratamiento());
	}
?>