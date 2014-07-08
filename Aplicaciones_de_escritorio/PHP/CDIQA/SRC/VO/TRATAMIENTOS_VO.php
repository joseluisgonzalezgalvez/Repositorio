<?php
	class TRATAMIENTOS_VO{
		private $Nu_Tratamiento = -1;

		function setNu_Tratamiento($Nu_Tratamiento){
			$this->Nu_Tratamiento = $Nu_Tratamiento;
		}

		function getNu_Tratamiento(){
			return $this->Nu_Tratamiento;
		}

		private $St_Nombre= "";

		function setSt_Nombre($St_Nombre){
			$this->St_Nombre = $St_Nombre;
		}

		function getSt_Nombre(){
			return $this->St_Nombre;
		}

		private $St_Descripcion = "";

		function setSt_Descripcion($St_Descripcion){
			$this->St_Descripcion = $St_Descripcion;
		}

		function getSt_Descripcion(){
			return $this->St_Descripcion;
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