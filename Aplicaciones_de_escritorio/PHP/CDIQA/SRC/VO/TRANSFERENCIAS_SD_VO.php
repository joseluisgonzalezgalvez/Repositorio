<?php
	class TRANSFERENCIAS_SD_VO{
		private $Nu_Transferencias_SD = -1;

		function setNu_Transferencias_SD($Nu_Transferencias_SD){
			$this->Nu_Transferencias_SD = $Nu_Transferencias_SD;
		}

		function getNu_Transferencias_SD(){
			return $this->Nu_Transferencias_SD;
		}

		private $Nu_Folio = -1;

		function setNu_Folio($Nu_Folio){
			$this->Nu_Folio = $Nu_Folio;
		}

		function getNu_Folio(){
			return $this->Nu_Folio;
		}
	}
?>