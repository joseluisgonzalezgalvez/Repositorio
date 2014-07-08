<?php
	class CITAS_PRESCRIPCION_VO{
		
		private $Nu_Citas_Prescripcion = -1;

		function setNu_Citas_Prescripcion( $Nu_Citas_Prescripcion ){
			$this->Nu_Citas_Prescripcion = $Nu_Citas_Prescripcion;
		}

		function getNu_Citas_Prescripcion(){
			return $this->Nu_Citas_Prescripcion;
		}

		private $Nu_Ficha = -1;
		
		function setNu_Ficha( $Nu_Ficha ){
			$this->Nu_Ficha = $Nu_Ficha;
		}

		function getNu_Ficha(){
			return $this->Nu_Ficha;
		}
		
		private $Nu_Cita = -1;
		
		function setNu_Cita( $Nu_Cita ){
			$this->Nu_Cita = $Nu_Cita;
		}

		function getNu_Cita(){
			return $this->Nu_Cita;
		}

		private $St_Prescripcion = "";
		
		function setSt_Prescripcion( $St_Prescripcion ){
			$this->St_Prescripcion = $St_Prescripcion;
		}

		function getSt_Prescripcion(){
			return $this->St_Prescripcion;
		}

	}
?>