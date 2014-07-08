<?php
	class EMPLEADOS_VO{

		private $Nu_Empleado = -1;

		function setNu_Empleado($Nu_Empleado){
			$this->Nu_Empleado = $Nu_Empleado;
		}

		function getNu_Empleado(){
			return $this->Nu_Empleado;
		}

		private $St_Puesto = "";

		function setSt_Puesto($St_Puesto){
			$this->St_Puesto = $St_Puesto;
		}

		function getSt_Puesto(){
			return $this->St_Puesto;
		}

		private $St_Nombre = "";

		function setSt_Nombre($St_Nombre){
			$this->St_Nombre = $St_Nombre;
		}

		function getSt_Nombre(){
			return $this->St_Nombre;
		}

		private $St_Apellidos = "";

		function setSt_Apellidos($St_Apellidos){
			$this->St_Apellidos = $St_Apellidos;
		}

		function getSt_Apellidos(){
			return $this->St_Apellidos;
		}

		private $St_Usuario = "";

		function setSt_Usuario($St_Usuario){
			$this->St_Usuario = $St_Usuario;
		}

		function getSt_Usuario(){
			return $this->St_Usuario;
		}

		private $St_Password = "";

		function setSt_Password($St_Password){
			$this->St_Password = $St_Password;
		}

		function getSt_Password(){
			return $this->St_Password;
		}


	}
?>