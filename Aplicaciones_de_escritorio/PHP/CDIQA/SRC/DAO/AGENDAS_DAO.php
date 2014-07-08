<?php
	require("DAO.php");

	class AGENDAS_DAO extends DAO{

		public function insert($agendas){
			$Templates = new DataBase();
			$sql = "insert into agendas (NU_AGENDA,ST_NOMBRE, 
						ST_APELLIDO, ST_FECHA, ST_TELEFONO,
						ST_CORREO, ST_DETALLES, ST_TIPO) 
						values (
						".$agendas->getNu_Agenda()."
						'".$agendas->getSt_Nombre()."',
						'".$agendas->getSt_Apellido()."',
						'".$agendas->getSt_Fecha()."',
						'".$agendas->getSt_Telefono()."',
						'".$agendas->getSt_Correo()."',
						'".$agendas->getSt_Detalles()."',
						'".$agendas->getSt_Tipo()."'
						)";
			DAO::executeInsert($sql);
			return $agendas;
		}

		public function update($agendas){
			$Templates = new DataBase();
			$sql = "update agendas ";
			$change = "set";
			$constraint = " where";
			$consulta = "";				

			if($agendas->getSt_Nombre() != "" && strlen($agendas->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$agendas->getSt_Nombre()."'";
			}

			if($agendas->getSt_Apellido() != "" && strlen($agendas->getSt_Apellido()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_APELLIDO = '".$agendas->getSt_Apellido()."'";
			}

			if($agendas->getSt_Fecha() != "" && strlen($agendas->getSt_Fecha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_FECHA = '".$agendas->getSt_Fecha()."'";
			}

			if($agendas->getSt_Telefono() != "" && strlen($agendas->getSt_Telefono()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_TELEFONO = '".$agendas->getSt_Telefono()."'";
			}

			if($agendas->getSt_Correo() != "" && strlen($agendas->getSt_Correo()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_CORREO = '".$agendas->getSt_Correo()."'";
			}

			if($agendas->getSt_Detalles() != "" && strlen($agendas->getSt_Detalles()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_DETALLES = '".$agendas->getSt_Detalles()."'";
			}

			if($agendas->getSt_Tipo() != "" && strlen($agendas->getSt_Tipo()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_TIPO = '".$agendas->getSt_Tipo()."'";
			}

			if($agendas->getNu_Agenda() != -1 && strlen($agendas->getNu_Agenda()) > 0){
				$constraint .= " NU_AGENDA = ".$agendas->getNu_Agenda();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $agendas;

		}

		public function consult($agendas){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$agendas_vo;

			$sql = "select * from agendas ";
			$constraint = "where";
			$consulta = "";
		
			if($agendas->getNu_Agenda() != -1 && strlen($agendas->getNu_Agenda()) > 0){
				$constraint .= " NU_AGENDA = ".$agendas->getNu_Agenda();
			}

			if($agendas->getSt_Nombre() != "" && strlen($agendas->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$agendas->getSt_Nombre()."'";
			}

			if($agendas->getSt_Apellido() != "" && strlen($agendas->getSt_Apellido()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_APELLIDO = '".$agendas->getSt_Apellido()."'";
			}

			if($agendas->getSt_Fecha() != "" && strlen($agendas->getSt_Fecha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_FECHA = '".$agendas->getSt_Fecha()."'";
			}

			if($agendas->getSt_Telefono() != "" && strlen($agendas->getSt_Telefono()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " setSt_Telefono = '".$agendas->getSt_Telefono()."'";
			}

			if($agendas->getSt_Correo() != "" && strlen($agendas->getSt_Correo()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_CORREO = '".$agendas->getSt_Correo()."'";
			}

			if($agendas->getSt_Detalles() != "" && strlen($agendas->getSt_Detalles()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_DETALLES = '".$agendas->getSt_Detalles()."'";
			}

			if($agendas->getSt_Tipo() != "" && strlen($agendas->getSt_Tipo()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_TIPO = '".$agendas->getSt_Tipo()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$agendas_vo = new AGENDAS_VO();
				$agendas_vo->setNu_Agenda($row[0]);
				$agendas_vo->setSt_Nombre($row[1]);
				$agendas_vo->setSt_Apellido($row[2]);
				$agendas_vo->setSt_Fecha($row[3]);
				$agendas_vo->setSt_Telefono($row[4]);
				$agendas_vo->setSt_Correo($row[5]);
				$agendas_vo->setSt_Detalles($row[6]);				
				$agendas_vo->setSt_Tipo($row[7]);

				$arraylist->addItem($agendas_vo);
			}

			return $arraylist;
		}
	}	
?>