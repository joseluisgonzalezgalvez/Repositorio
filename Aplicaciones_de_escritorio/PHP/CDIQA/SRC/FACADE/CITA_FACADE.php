<?php
	require("../DAO/CITA_DAO.php");
	require("../VO/CITA_VO.php");
	class CITA_FACADE extends CITA_DAO{	

		public function insert($cita){
			$CITA_DAO = new CITA_DAO();
			return $CITA_DAO->insert($cita);
		}

		public function update($cita){
			$CITA_DAO = new CITA_DAO();
			return $CITA_DAO->update($cita);
		}

		public function consult($cita){
			$CITA_DAO = new CITA_DAO();
			return $CITA_DAO->consult($cita);
		}
	}

	$cita = new CITA_VO();
	$cita->setNu_Cita(9);
	$cita->setNu_Ficha(1);
	$cita->setNu_Visitas(100);
	$cita->setSt_Fecha("22-09-2013");
	
	$class = new CITA_FACADE();
	//$class->update($cita);
	$arraylist = $class->consult($cita);
	echo("Cantidad: ".$arraylist->size());
	for($i=0; $i<$arraylist->size(); $i++){
		$cita = $arraylist->item($i);
		echo("<br><br>".$cita->getNu_Cita());		
		echo("<br><br>").$cita->getNu_Ficha();
		echo("<br><br>".$cita->getNu_Visitas());
		echo("<br><br>".$cita->getSt_Fecha());
	}
?>