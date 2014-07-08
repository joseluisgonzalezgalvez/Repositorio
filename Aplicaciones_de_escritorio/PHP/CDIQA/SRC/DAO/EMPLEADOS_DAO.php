<?php
	require("DAO.php");

	class EMPLEADOS_DAO extends DAO{

		public function insert($empleados){
			$Templates = new DataBase();
			$sql = "insert into empleados (NU_EMPLEADO, 
						ST_PUESTO, ST_NOMBRE, ST_APELLIDOS, 
						ST_USUARIO, ST_PASSWORD) 
						values (
						".$empleados->getNu_Empleado().",
						'".$empleados->getSt_Puesto()."',
						'".$empleados->getSt_Nombre()."',
						'".$empleados->getSt_Apellidos()."',
						'".$empleados->getSt_Usuario()."',
						'".$empleados->getSt_Password()."'
						)";
		
			DAO::executeInsert($sql);
			return $empleados;
		}	

		public function update($empleados){
			$Templates = new DataBase();
			$sql = "update empleados ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($empleados->getSt_Puesto() != "" && strlen($empleados->getSt_Puesto()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_PUESTO = '".$empleados->getSt_Puesto()."'";
			}
			
			if($empleados->getSt_Nombre() != "" && strlen($empleados->getSt_Nombre()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_NOMBRE = '".$empleados->getSt_Nombre()."'";
			}

			if($empleados->getSt_Apellidos() != "" && strlen($empleados->getSt_Apellidos()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_APELLIDOS = '".$empleados->getSt_Apellidos()."'";
			}

			if($empleados->getSt_Usuario() != "" && strlen($empleados->getSt_Usuario()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_USUARIO = '".$empleados->getSt_Usuario()."'";
			}

			if($empleados->getSt_Password() != "" && strlen($empleados->getSt_Password()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " ST_PASSWORD = '".$empleados->getSt_Password()."'";
			}

			if($empleados->getNu_Empleado() != -1 && strlen($empleados->getNu_Empleado()) > 0){
				$constraint .= " NU_EMPLEADO = ".$empleados->getNu_Empleado();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $empleados;

		}

		public function consult($empleados){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$empleados_vo;

			$sql = "select * from empleados ";
			$constraint = "where";
			$consulta = "";
		
			if($empleados->getNu_Empleado() != -1 && strlen($empleados->getNu_Empleado()) > 0){
				$constraint .= " NU_EMPLEADO = ".$empleados->getNu_Empleado();
			}
			
			if($empleados->getSt_Puesto() != "" && strlen($empleados->getSt_Puesto()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_PUESTO = '".$empleados->getSt_Puesto()."'";
			}

			if($empleados->getSt_Nombre() != "" && strlen($empleados->getSt_Nombre()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_NOMBRE = '".$empleados->getSt_Nombre()."'";
			}

			if($empleados->getSt_Apellidos() != "" && strlen($empleados->getSt_Apellidos()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_APELLIDOS = '".$empleados->getSt_Apellidos()."'";
			}

			if($empleados->getSt_Usuario() != "" && strlen($empleados->getSt_Usuario()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_USUARIO = '".$empleados->getSt_Usuario()."'";
			}

			if($empleados->getSt_Password() != "" && strlen($empleados->getSt_Password()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " ST_PASSWORD = '".$empleados->getSt_Password()."'";
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$empleados_vo = new EMPLEADOS_VO();
				$empleados_vo->setNu_Empleado($row[0]);
				$empleados_vo->setSt_Puesto($row[1]);
				$empleados_vo->setSt_Nombre($row[2]);
				$empleados_vo->setSt_Apellidos($row[3]);
				$empleados_vo->setSt_Usuario($row[4]);
				$empleados_vo->setSt_Password($row[5]);

				$arraylist->addItem($empleados_vo);
			}

			return $arraylist;
		}
	}	
?>