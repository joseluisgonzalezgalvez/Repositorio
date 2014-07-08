<?php
	class CITAS_MEDICAMENTOS_VO{
		
		private $Nu_Citas_Medicamentos = -1;

		function setNu_Citas_Medicamentos( $Nu_Citas_Medicamentos ){
			$this->Nu_Citas_Medicamentos = $Nu_Citas_Medicamentos;
		}

		function getNu_Citas_Medicamentos(){
			return $this->Nu_Citas_Medicamentos;
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

		private $Nu_Medicamento = -1;
		
		function setNu_Medicamento( $Nu_Medicamento ){
			$this->Nu_Medicamento = $Nu_Medicamento;
		}

		function getNu_Medicamento(){
			return $this->Nu_Medicamento;
		}

	}
?>