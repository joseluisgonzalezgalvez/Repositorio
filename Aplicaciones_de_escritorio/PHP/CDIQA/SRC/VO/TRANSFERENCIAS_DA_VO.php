<?php
	class TRANSFERENCIAS_DA_VO{
		private $Nu_Transferencias_DA = -1;

		function setNu_Transferencias_DA($Nu_Transferencias_DA){
			$this->Nu_Transferencias_DA = $Nu_Transferencias_DA;
		}

		function getNu_Transferencias_DA(){
			return $this->Nu_Transferencias_DA;
		}

		private $Nu_Folio = -1;

		function setNu_Folio($Nu_Folio){
			$this->Nu_Folio = $Nu_Folio;
		}

		function getNu_Folio(){
			return $this->Nu_Folio;
		}

		private $Nu_Cita = -1;

		function setNu_Cita($Nu_Cita){
			$this->Nu_Cita = $Nu_Cita;
		}

		function getNu_Cita(){
			return $this->Nu_Cita;
		}
	}
?>