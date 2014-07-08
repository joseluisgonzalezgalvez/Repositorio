<?php
	class AGENDAS_VO{
		private $Nu_Agenda = -1;

		function setNu_Agenda($Nu_Agenda){
			$this->Nu_Agenda = $Nu_Agenda;
		}

		function getNu_Agenda(){
			return $this->Nu_Agenda;
		}


		private $St_Nombre = "";

		function setSt_Nombre($St_Nombre){
			$this->St_Nombre = $St_Nombre;
		}

		function getSt_Nombre(){
			return $this->St_Nombre;
		}

		private $St_Apellido = "";

		function setSt_Apellido($St_Apellido){
			$this->St_Apellido = $St_Apellido;
		}

		function getSt_Apellido(){
			return $this->St_Apellido;
		}

		private $St_Fecha = "";

		function setSt_Fecha($St_Fecha){
			$this->St_Fecha = $St_Fecha;
		}

		function getSt_Fecha(){
			return $this->St_Fecha;
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

		private $St_Detalles = "";

		function setSt_Detalles($St_Detalles){
			$this->St_Detalles = $St_Detalles;
		}

		function getSt_Detalles(){
			return $this->St_Detalles;
		}

		private $St_Tipo = "";

		function setSt_Tipo($St_Tipo){
			$this->St_Tipo = $St_Tipo;
		}

		function getSt_Tipo(){
			return $this->St_Tipo;
		}
	}
?>