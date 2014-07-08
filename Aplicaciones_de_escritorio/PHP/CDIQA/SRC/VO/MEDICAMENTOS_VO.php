<?php
	class MEDICAMENTOS_VO{

		private $Nu_Medicamento = -1;

		function setNu_Medicamento($Nu_Medicamento){
			$this->Nu_Medicamento = $Nu_Medicamento;
		}

		function getNu_Medicamento(){
			return $this->Nu_Medicamento;
		}

		private $St_Nombre = "";

		function setSt_Nombre($St_Nombre){
			$this->St_Nombre = $St_Nombre;
		}

		function getSt_Nombre(){
			return $this->St_Nombre;
		}

		private $St_Componentes = "";

		function setSt_Componentes($St_Componentes){
			$this->St_Componentes = $St_Componentes;
		}

		function getSt_Componentes(){
			return $this->St_Componentes;
		}

		private $Nu_Distribuidor = -1;

		function setNu_Distribuidor($Nu_Distribuidor){
			$this->Nu_Distribuidor = $Nu_Distribuidor;
		}

		function getNu_Distribuidor(){
			return $this->Nu_Distribuidor;
		}

		private $Mn_Precio = -1;

		function setMn_Precio($Mn_Precio){
			$this->Mn_Precio = $Mn_Precio;
		}

		function getMn_Precio(){
			return $this->Mn_Precio;
		}

	}
?>