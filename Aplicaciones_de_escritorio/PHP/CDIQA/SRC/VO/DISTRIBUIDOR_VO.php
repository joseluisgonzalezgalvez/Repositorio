<?php
	class DISTRIBUIDOR_VO{

		private $Nu_Distribuidor = -1;

		function setNu_Distribuidor($Nu_Distribuidor){
			$this->Nu_Distribuidor = $Nu_Distribuidor;
		}

		function getNu_Distribuidor(){
			return $this->Nu_Distribuidor;
		}

		private $St_Nombre = "";

		function setSt_Nombre($St_Nombre){
			$this->St_Nombre = $St_Nombre;
		}

		function getSt_Nombre(){
			return $this->St_Nombre;
		}

		private $St_Direccion = "";

		function setSt_Direccion($St_Direccion){
			$this->St_Direccion = $St_Direccion;
		}

		function getSt_Direccion(){
			return $this->St_Direccion;
		}

		private $St_Telefono = "";

		function setSt_Telefono($St_Telefono){
			$this->St_Telefono = $St_Telefono;
		}

		function getSt_Telefono(){
			return $this->St_Telefono;
		}

		private $St_Correo = "";

		function setSt_Correo($St_Correo){
			$this->St_Correo = $St_Correo;
		}

		function getSt_Correo(){
			return $this->St_Correo;
		}

	}
?>