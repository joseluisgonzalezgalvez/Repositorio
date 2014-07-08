<?php
	class CITAS_CONSULTA_VO{
		
		private $Nu_Citas_Consulta = -1;

		function setNu_Citas_Consulta( $Nu_Citas_Consulta ){
			$this->Nu_Citas_Consulta = $Nu_Citas_Consulta;
		}

		function getNu_Citas_Consulta(){
			return $this->Nu_Citas_Consulta;
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

		private $St_Consulta = "";
		
		function setSt_Consulta( $St_Consulta ){
			$this->St_Consulta = $St_Consulta;
		}

		function getSt_Consulta(){
			return $this->St_Consulta;
		}

	}
?>