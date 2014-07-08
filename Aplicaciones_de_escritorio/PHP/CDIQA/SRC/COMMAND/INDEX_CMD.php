<?php
	//require("../UTIL/ArrayList.php");
	//require("../VO/EMPLEADOS_VO.php");
	require("../../WEB/CONTROLLER/CONTROLLER.php");
	require("../FACADE/EMPLEADOS_FACADE.php");
	class INDEX_CMD{
		function __construct(){
			$ArrayList = new ArrayList();

			$Empleados_Facade = new EMPLEADOS_FACADE();
			$Empleados = new EMPLEADOS_VO();
			$Empleados->setSt_Usuario($_POST["User"]);			
			$ArrayList = $Empleados_Facade->consult($Empleados);
			for($i=0; $i<$ArrayList->size(); $i++){
				$Empleados = $ArrayList->item($i);
			}
			if($Empleados->getSt_Password()==$_POST["Pass"]){
				if(isset($_SESSION["USUARIO"]))
					session_destroy();

				session_start();

				$_SESSION["ID"] = $Empleados->getNu_Empleado();
				$_SESSION["PUESTO"] = $Empleados->getSt_Puesto();
				$_SESSION["NOMBRE"] = $Empleados->getSt_Nombre();
				$_SESSION["APELLIDO"] = $Empleados->getSt_Apellidos();
				$_SESSION["USUARIO"] = $Empleados->getSt_Usuario();
				$_SESSION["PASSWORD"] = $Empleados->getSt_Password();

				switch($Empleados->getSt_Puesto()){
					case "DOCTOR": header("location:".
								VIEW_CONTROLLER::DOCTOR);
								break;

					case "SECRETARIA": header("location:".
								VIEW_CONTROLLER::SECRETARIA);
								break;

					case "ADMINISTRADOR" : header("location:".
								VIEW_CONTROLLER::ADMINISTRADOR);
								break;
				}
			}else{
				echo("CONTRASEÑA INCORRECTA");
			}				
		}
	}


	new INDEX_CMD();

?>