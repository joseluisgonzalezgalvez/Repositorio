<?php
	class FICHAS_VO{

		private $Nu_Ficha = -1;
		
		function setNu_Ficha( $Nu_Ficha ){
			$this->Nu_Ficha = $Nu_Ficha;
		}

		function getNu_Ficha(){
			return $this->Nu_Ficha;
		}

		private $Nu_Paciente = -1;
		
		function setNu_Paciente( $Nu_Paciente ){
			$this->Nu_Paciente = $Nu_Paciente;
		}

		function getNu_Paciente(){
			return $this->Nu_Paciente;
		}

		private $Nu_Citas = -1;
		
		function setNu_Citas( $Nu_Citas ){
			$this->Nu_Citas = $Nu_Citas;
		}

		function getNu_Citas(){
			return $this->Nu_Citas;
		}

		private $St_Fecha = "";
		
		function setSt_Fecha( $St_Fecha ){
			$this->St_Fecha = $St_Fecha;
		}

		function getSt_Fecha(){
			return $this->St_Fecha;
		}

	}
?>