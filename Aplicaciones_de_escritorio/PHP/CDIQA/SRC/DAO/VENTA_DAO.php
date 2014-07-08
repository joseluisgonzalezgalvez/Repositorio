<?php
	require("DAO.php");

	class VENTA_DAO extends DAO{

		public function insert($venta){
			$Templates = new DataBase();
			$sql = "insert into venta (
						NU_VENTA, 
						NU_FOLIO, NU_CITA,
						ST_PRODUCTO, MN_PRECIO,
						ST_FECHA)
						values (
						".$venta->getNu_Venta().",
						".$venta->getNu_Folio().",
						".$venta->getNu_Cita().",
						'".$venta->getSt_Producto()."',
						".$venta->getMn_Precio().",
						'".$venta->getSt_Fecha()."'
						)";
		
			DAO::executeInsert($sql);
			return $venta;
		}

		public function update($venta){
			$Templates = new DataBase();
			$sql = "update venta ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($venta->getNu_Folio() != -1 && strlen($venta->getNu_Folio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FOLIO = ".$venta->getNu_Folio();
			}

			if($venta->getNu_Cita() != -1 && strlen($venta->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$venta->getNu_Cita();
			}

			if($venta->getSt_Producto() != "" && strlen($venta->getSt_Producto()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_PRODUCTO = '".$venta->getSt_Producto()."'";
			}

			if($venta->getMn_Precio() != -1 && strlen($venta->getMn_Precio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " MN_PRECIO = ".$venta->getMn_Precio();
			}

			if($venta->getSt_Fecha() != "" && strlen($venta->getSt_Fecha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_FECHA = '".$venta->getSt_Fecha()."'";
			}

			if($venta->getNu_Venta() != -1 && strlen($venta->getNu_Venta()) > 0){
				$constraint .= " NU_VENTA = ".$venta->getNu_Venta();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $venta;

		}

		public function consult($venta){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$venta_vo;

			$sql = "select * from venta ";
			$constraint = "where";
			$consulta = "";
		
			if($venta->getNu_Venta() != -1 && strlen($venta->getNu_Venta()) > 0){
				$constraint .= " NU_VENTA = ".$venta->getNu_Venta();
			}

			if($venta->getNu_Folio() != -1 && strlen($venta->getNu_Folio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FOLIO = ".$venta->getNu_Folio();
			}

			if($venta->getNu_Cita() != -1 && strlen($venta->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$venta->getNu_Cita();
			}

			if($venta->getSt_Producto() != "" && strlen($venta->getSt_Producto()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_PRODUCTO = '".$venta->getSt_Producto()."'";
			}

			if($venta->getMn_Precio() != -1 && strlen($venta->getMn_Precio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " MN_PRECIO = ".$venta->getMn_Precio();
			}

			if($venta->getSt_Fecha() != "" && strlen($venta->getSt_Fecha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_FECHA = '".$venta->getSt_Fecha()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;
			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$venta_vo = new VENTA_VO();
				$venta_vo->setNu_Venta($row[0]);
				$venta_vo->setNu_Folio($row[1]);
				$venta_vo->setNu_Cita($row[2]);
				$venta_vo->setSt_Producto($row[3]);
				$venta_vo->setMn_Precio($row[4]);
				$venta_vo->setSt_Fecha($row[5]);

				$arraylist->addItem($venta_vo);
			}

			return $arraylist;
		}
	}	
?>