<?php
	class PACIENTES_VO{

		private $Nu_Paciente = -1;

		function setNu_Paciente($Nu_Paciente){
			$this->Nu_Paciente = $Nu_Paciente;
		}

		function getNu_Paciente(){
			return $this->Nu_Paciente;
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

		private $Nu_Edad = -1;

		function setNu_Edad($Nu_Edad){
			$this->Nu_Edad = $Nu_Edad;
		}

		function getNu_Edad(){
			return $this->Nu_Edad;
		}

		private $St_Sexo = "";

		function setSt_Sexo($St_Sexo){
			$this->St_Sexo = $St_Sexo;
		}

		function getSt_Sexo(){
			return $this->St_Sexo;
		}

		private $Fl_Peso = -1;

		function setFl_Peso($Fl_Peso){
			$this->Fl_Peso = $Fl_Peso;
		}

		function getFl_Peso(){
			return $this->Fl_Peso;
		}

		private $Fl_Talla = -1;

		function setFl_Talla($Fl_Talla){
			$this->Fl_Talla = $Fl_Talla;
		}

		function getFl_Talla(){
			return $this->Fl_Talla;
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

		private $St_Domicilio = "";

		function setSt_Domicilio($St_Domicilio){
			$this->St_Domicilio = $St_Domicilio;
		}

		function getSt_Domicilio(){
			return $this->St_Domicilio;
		}
	}
?>