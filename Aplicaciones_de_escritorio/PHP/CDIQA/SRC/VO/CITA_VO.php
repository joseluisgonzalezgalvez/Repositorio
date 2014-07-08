<?php
	class CITA_VO{
		private $Nu_Cita = -1;
		
		function setNu_Cita( $Nu_Cita ){
			$this->Nu_Cita = $Nu_Cita;
		}

		function getNu_Cita(){
			return $this->Nu_Cita;
		}

		private $Nu_Ficha = -1;
		
		function setNu_Ficha( $Nu_Ficha ){
			$this->Nu_Ficha = $Nu_Ficha;
		}

		function getNu_Ficha(){
			return $this->Nu_Ficha;
		}

		private $Nu_Visitas = -1;
		
		function setNu_Visitas( $Nu_Visitas ){
			$this->Nu_Visitas = $Nu_Visitas;
		}

		function getNu_Visitas(){
			return $this->Nu_Visitas;
		}

		private $St_Fecha = "";

		function setSt_Fecha( $St_Fecha){
			$this->St_Fecha = $St_Fecha;
		}

		function getSt_Fecha(){
			return $this->St_Fecha;
		}

	}
?>