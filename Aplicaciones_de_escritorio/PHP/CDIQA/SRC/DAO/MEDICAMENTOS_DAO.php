<?php
	require("DAO.php");

	class MEDICAMENTOS_DAO extends DAO{

		public function insert($medicamentos){
			$Templates = new DataBase();
			$sql = "insert into medicamentos (NU_MEDICAMENTO, 
						ST_NOMBRE, ST_COMPONENTES, 
						NU_DISTRIBUIDOR, MN_PRECIO)
						values (
						".$medicamentos->getNu_Medicamento().",
						'".$medicamentos->getSt_Nombre()."',
						'".$medicamentos->getSt_Componentes()."',
						".$medicamentos->getNu_Distribuidor().",
						".$medicamentos->getMn_Precio()."
						)";
		
			DAO::executeInsert($sql);
			return $medicamentos;
		}

		public function update($medicamentos){
			$Templates = new DataBase();
			$sql = "update medicamentos ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($medicamentos->getSt_Nombre() != "" && strlen($medicamentos->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$medicamentos->getSt_Nombre()."'";
			}

			if($medicamentos->getSt_Componentes() != "" && strlen($medicamentos->getSt_Componentes()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_COMPONENTES = '".$medicamentos->getSt_Componentes()."'";
			}

			if($medicamentos->getNu_Distribuidor() != -1 && strlen($medicamentos->getNu_Distribuidor()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_DISTRIBUIDOR = ".$medicamentos->getNu_Distribuidor();
			}

			if($medicamentos->getMn_Precio() != "" && strlen($medicamentos->getMn_Precio()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " MN_PRECIO = ".$medicamentos->getMn_Precio();
			}

			if($medicamentos->getNu_Medicamento() != -1 && strlen($medicamentos->getNu_Medicamento()) > 0){
				$constraint .= " NU_Medicamento = ".$medicamentos->getNu_Medicamento();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $medicamentos;

		}

		public function consult($medicamentos){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$medicamentos_vo;

			$sql = "select * from medicamentos ";
			$constraint = "where";
			$consulta = "";
		
			if($medicamentos->getNu_Medicamento() != -1 && strlen($medicamentos->getNu_Medicamento()) > 0){
				$constraint .= " NU_MEDICAMENTO = ".$medicamentos->getNu_Medicamento();
			}

			if($medicamentos->getSt_Nombre() != "" && strlen($medicamentos->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$medicamentos->getSt_Nombre()."'";
			}

			if($medicamentos->getSt_Componentes() != "" && strlen($medicamentos->getSt_Componentes()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_COMPONENTES = '".$medicamentos->getSt_Componentes()."'";
			}

			if($medicamentos->getNu_Distribuidor() != -1 && strlen($medicamentos->getNu_Distribuidor()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_DISTRIBUIDOR = ".$medicamentos->getNu_Distribuidor();
			}

			if($medicamentos->getMn_Precio() != -1 && strlen($medicamentos->getMn_Precio()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " MN_PRECIO = ".$medicamentos->getMn_Precio();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$medicamentos_vo = new MEDICAMENTOS_VO();
				$medicamentos_vo->setNu_Medicamento($row[0]);
				$medicamentos_vo->setSt_Nombre($row[1]);
				$medicamentos_vo->setSt_Componentes($row[2]);
				$medicamentos_vo->setNu_Distribuidor($row[3]);
				$medicamentos_vo->setMn_Precio($row[4]);

				$arraylist->addItem($medicamentos_vo);
			}

			return $arraylist;
		}
	}	
?>