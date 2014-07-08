<?php
	class CITAS_TRATAMIENTOS_VO{
		
		private $Nu_Citas_Tratamientos = -1;

		function setNu_Citas_Tratamientos( $Nu_Citas_Tratamientos ){
			$this->Nu_Citas_Tratamientos = $Nu_Citas_Tratamientos;
		}

		function getNu_Citas_Tratamientos(){
			return $this->Nu_Citas_Tratamientos;
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

		private $NuTratamiento = -1;
		
		function setNu_Tratamiento( $NuTratamiento ){
			$this->NuTratamiento = $NuTratamiento;
		}

		function getNu_Tratamiento(){
			return $this->NuTratamiento;
		}

	}
?>