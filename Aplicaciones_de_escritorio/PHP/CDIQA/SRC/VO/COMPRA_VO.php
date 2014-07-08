<?php
	class COMPRA_VO{
		
		private $Nu_Compra = -1;

		function setNu_Compra($Nu_Compra){
			$this->Nu_Compra = $Nu_Compra;
		}

		function getNu_Compra(){
			return $this->Nu_Compra;
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
	}
?>