<?php
	class VENTA_VO{
		private $Nu_Venta = -1;

		function setNu_Venta($Nu_Venta){
			$this->Nu_Venta = $Nu_Venta;
		}

		function getNu_Venta(){
			return $this->Nu_Venta;
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

		private $St_Producto = "";

		function setSt_Producto($St_Producto){
			$this->St_Producto = $St_Producto;
		}

		function getSt_Producto(){
			return $this->St_Producto;
		}

		private $Mn_Precio = -1;

		function setMn_Precio($Mn_Precio){
			$this->Mn_Precio = $Mn_Precio;
		}

		function getMn_Precio(){
			return $this->Mn_Precio;
		}

		private $St_Fecha = "";

		function setSt_Fecha($St_Fecha){
			$this->St_Fecha = $St_Fecha;
		}

		function getSt_Fecha(){
			return $this->St_Fecha;
		}

	}
?>