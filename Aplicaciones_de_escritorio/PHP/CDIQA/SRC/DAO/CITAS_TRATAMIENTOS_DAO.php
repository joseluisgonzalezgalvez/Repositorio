<?php
	require("DAO.php");

	class CITAS_TRATAMIENTOS_DAO extends DAO{

		public function insert($citas_tratamientos){
			$Templates = new DataBase();
			$sql = "insert into citas_tratamientos (NU_CITAS_TRATAMIENTOS, 
						NU_FICHA, NU_CITA, NU_TRATAMIENTO) 
						values (
						".$citas_tratamientos->getNu_Citas_Tratamientos().",
						".$citas_tratamientos->getNu_Ficha().",
						".$citas_tratamientos->getNu_Cita().",
						".$citas_tratamientos->getNu_Tratamiento()."
						)";
		
			DAO::executeInsert($sql);
			return $citas_tratamientos;
		}	

		public function update($citas_tratamientos){
			$Templates = new DataBase();
			$sql = "update citas_tratamientos ";
			$change = "set";
			$constraint = " where";
			$consulta = "";						

			if($citas_tratamientos->getNu_Ficha() != "" && strlen($citas_tratamientos->getNu_Ficha()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_FICHA = ".$citas_tratamientos->getNu_Ficha();
			}

			if($citas_tratamientos->getNu_Cita() != "" && strlen($citas_tratamientos->getNu_Cita()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_CITA = ".$citas_tratamientos->getNu_Cita();
			}			

			if($citas_tratamientos->getNu_Tratamiento() != "" && strlen($citas_tratamientos->getNu_Tratamiento()) > 0){
				if($change != "set")
					$change.= ", ";
				$change .= " NU_TRATAMIENTO = ".$citas_tratamientos->getNu_Tratamiento();
			}

			if($citas_tratamientos->getNu_Citas_Tratamientos() != -1 && strlen($citas_tratamientos->getNu_Citas_Tratamientos()) > 0){
				$constraint .= " NU_CITAS_TRATAMIENTOS = ".$citas_tratamientos->getNu_Citas_Tratamientos();
			}

			$constraint .= ";";

			$consulta = $sql.$change.$constraint;

			echo("Update: ".$consulta);

			if($constraint != " where;"){
				DAO::executeUpdate($consulta);		
			}

			return $citas_tratamientos;

		}

		public function consult($citas_tratamientos){
			$Templates = new DataBase();
			$arraylist = new ArrayList();
			$citas_tratamientos_vo;

			$sql = "select * from citas_tratamientos ";
			$constraint = "where";
			$consulta = "";
		
			if($citas_tratamientos->getNu_Citas_Tratamientos() != -1 && strlen($citas_tratamientos->getNu_Citas_Tratamientos()) > 0){
				$constraint .= " NU_CITAS_TRATAMIENTOS = ".$citas_tratamientos->getNu_Citas_Tratamientos();
			}
			
			if($citas_tratamientos->getNu_Ficha() != -1 && strlen($citas_tratamientos->getNu_Ficha()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_FICHA = ".$citas_tratamientos->getNu_Ficha();
			}

			if($citas_tratamientos->getNu_Cita() != -1 && strlen($citas_tratamientos->getNu_Cita()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_CITA = ".$citas_tratamientos->getNu_Cita();
			}

			if($citas_tratamientos->getNu_Tratamiento() != -1 && strlen($citas_tratamientos->getNu_Tratamiento()) > 0){
				if($constraint != "where")
					$constraint.= " AND ";
				$constraint .= " NU_TRATAMIENTO = ".$citas_tratamientos->getNu_Tratamiento();
			}

			$constraint .= ";";

			if($constraint != "where;")
				$consulta = $sql.$constraint;
			else
				$consulta = $sql;

			$Consulta = DAO::executeQuery($consulta);

			while($row = $Templates->fetch_array($Consulta)){
				$citas_tratamientos_vo = new CITAS_TRATAMIENTOS_VO();
				$citas_tratamientos_vo->setNu_Citas_Tratamientos($row[0]);
				$citas_tratamientos_vo->setNu_Ficha($row[1]);
				$citas_tratamientos_vo->setNu_Cita($row[2]);
				$citas_tratamientos_vo->setNu_Tratamiento($row[3]);

				$arraylist->addItem($citas_tratamientos_vo);
			}

			return $arraylist;
		}
	}	
?>