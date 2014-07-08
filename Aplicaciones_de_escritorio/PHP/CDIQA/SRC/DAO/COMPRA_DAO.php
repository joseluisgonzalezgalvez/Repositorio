<?php
	require("DAO.php");

	class COMPRA_DAO extends DAO{

		public function insert($compra){
			$Templates = new DataBase();
			$sql = "insert into compra (NU_COMPRA, 
						ST_PRODUCTO, MN_PRECIO) 
						values (
						".$compra->getNu_Compra().",
						'".$compra->getSt_Producto()."',
						".$compra->getMn_Precio()."
						)";
			echo("Consulta:<br><br>".$sql);
			DAO::executeInsert($sql);
			return $compra;
		}	

		public function update($compra){
			$Templates = new DataBase();
			$sql = "update compra ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($compra->getSt_Producto() != "" && strlen($compra->getSt_Producto()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_PRODUCTO = '".$compra->getSt_Producto()."'";
			}

			if($compra->getMn_Precio() != -1 && strlen($compra->getMn_Precio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " MN_PRECIO = ".$compra->getMn_Precio();
			}			

			if($compra->getNu_Compra() != -1 && strlen($compra->getNu_Compra()) > 0){
				$constraint .= " NU_COMPRA = ".$compra->getNu_Compra();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $compra;

		}

		public function consult($compra){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$compra_vo;

			$sql = "select * from compra ";
			$constraint = "where";
			$consulta = "";
		
			if($compra->getNu_Compra() != -1 && strlen($compra->getNu_Compra()) > 0){
				$constraint .= " NU_COMPRA = ".$compra->getNu_Compra();
			}
			
			if($compra->getSt_Producto() != "" && strlen($compra->getSt_Producto()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_PRODUCTO = '".$compra->getSt_Producto()."'";
			}

			if($compra->getMn_Precio() != -1 && strlen($compra->getMn_Precio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " MN_PRECIO = ".$compra->getMn_Precio();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$compra_vo = new COMPRA_VO();
				$compra_vo->setNu_Compra($row[0]);
				$compra_vo->setSt_Producto($row[1]);
				$compra_vo->setMn_Precio($row[2]);

				$arraylist->addItem($compra_vo);
			}

			return $arraylist;
		}
	}	
?>