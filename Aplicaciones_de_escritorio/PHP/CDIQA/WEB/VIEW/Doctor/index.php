<html>
	<head>
		<title>Doctor</title>		
		<LINK rel="stylesheet" href=" ../../CSS/doc.css" title="relative" type="text/css" >
        <script type="text/javascript" src=" script/script.js"></script>
		<script>
		var cont1=0;
		var cont2=0;
		
		var object;
		var string="";
		var array=[];
		
		var object_m;
		var string_m="";
		var array_m=[];
		
		function elegir(obj){
			var lis=document.getElementsByTagName("li");
			for(var i=0;i<lis.length;i++)
				lis[i].style.background="none";			
				
			var li=document.getElementById(""+obj.id);
			li.style.background="silver";
			
			object=obj;
		}
		
		function agregar(){
			var li=document.getElementById(""+object.id);
			li.style.display="none";
			array[cont1] = object.id;			
			string+=object.id+"<hr style='margin:0px;'>";
			document.getElementById("t_add").innerHTML="<div>"+string+"</div>";			
			cont1++;
		}
		
		function elegir_m(obj){
			var lis=document.getElementsByTagName("li");
			for(var i=0;i<lis.length;i++)
				lis[i].style.background="none";			
				
			var li=document.getElementById(""+obj.id);
			li.style.background="silver";
			object_m=obj;
		}

		function agregar_m(){	
			var li=document.getElementById(""+object_m.id);
			li.style.display="none";
			array_m[cont2] = object_m.id;
			
			string_m+=object_m.id+"<hr style='margin:0px;'>";
			document.getElementById("m_add").innerHTML="<div>"+string_m+"</div>";			
			cont2++;
		}

		function Pacientes() 
		{
			  document.getElementById("con_pac").style.display = "block";
			  document.getElementById("con_historial").style.display = "none";
			  document.getElementById("cons").style.display = "none";
			  document.getElementById("trata").style.display = "none";
			  document.getElementById("medi").style.display = "none";
			  document.getElementById("pres").style.display = "none";
			  document.getElementById("paciente").style.backgroundColor= "#fff";
			  document.getElementById("historial").style.backgroundColor= "silver";
			  document.getElementById("consulta").style.backgroundColor= "silver";
			  document.getElementById("tratamiento").style.backgroundColor= "silver";
			  document.getElementById("medicamento").style.backgroundColor= "silver";
			  document.getElementById("prescripcion").style.backgroundColor= "silver";
			  document.getElementById("guardar").style.backgroundColor= "silver";			  
		}
		function His_Cli() 
		{
			  document.getElementById("con_pac").style.display = "none";
			  document.getElementById("con_historial").style.display = "block";
			  document.getElementById("cons").style.display = "none";
			  document.getElementById("trata").style.display = "none";
			  document.getElementById("medi").style.display = "none";
			  document.getElementById("pres").style.display = "none";
			  document.getElementById("paciente").style.backgroundColor= "silver";
			  document.getElementById("historial").style.backgroundColor= "#fff";
			  document.getElementById("consulta").style.backgroundColor= "silver";
			  document.getElementById("tratamiento").style.backgroundColor= "silver";
			  document.getElementById("medicamento").style.backgroundColor= "silver";
			  document.getElementById("prescripcion").style.backgroundColor= "silver";
			  document.getElementById("guardar").style.backgroundColor= "silver";
			  //carga2();
		}
		function Con_Med() 
		{
			  document.getElementById("con_pac").style.display = "none";
			  document.getElementById("con_historial").style.display = "none";
			  document.getElementById("cons").style.display = "block";
			  document.getElementById("trata").style.display = "none";
			  document.getElementById("medi").style.display = "none";
			  document.getElementById("pres").style.display = "none";
			  document.getElementById("paciente").style.backgroundColor= "silver";
			  document.getElementById("historial").style.backgroundColor= "silver";
			  document.getElementById("consulta").style.backgroundColor= "#fff";
			  document.getElementById("tratamiento").style.backgroundColor= "silver";
			  document.getElementById("medicamento").style.backgroundColor= "silver";
			  document.getElementById("prescripcion").style.backgroundColor= "silver";
			  document.getElementById("guardar").style.backgroundColor= "silver";
		}
		function Tra_Med() 
		{
			  document.getElementById("con_pac").style.display = "none";
			  document.getElementById("con_historial").style.display = "none";
			  document.getElementById("cons").style.display = "none";
			  document.getElementById("trata").style.display = "block";
			  document.getElementById("medi").style.display = "none";
			  document.getElementById("pres").style.display = "none";
			  document.getElementById("paciente").style.backgroundColor= "silver";
			  document.getElementById("historial").style.backgroundColor= "silver";
			  document.getElementById("consulta").style.backgroundColor= "silver";
			  document.getElementById("tratamiento").style.backgroundColor= "#fff";
			  document.getElementById("medicamento").style.backgroundColor= "silver";
			  document.getElementById("prescripcion").style.backgroundColor= "silver";
			  document.getElementById("guardar").style.backgroundColor= "silver";
		}
		function Med_Med() 
		{
			  document.getElementById("con_pac").style.display = "none";
			  document.getElementById("con_historial").style.display = "none";
			  document.getElementById("cons").style.display = "none";
			  document.getElementById("trata").style.display = "none";
			  document.getElementById("medi").style.display = "block";
			  document.getElementById("pres").style.display = "none";
			  document.getElementById("paciente").style.backgroundColor= "silver";
			  document.getElementById("historial").style.backgroundColor= "silver";
			  document.getElementById("consulta").style.backgroundColor= "silver";
			  document.getElementById("tratamiento").style.backgroundColor= "silver";
			  document.getElementById("medicamento").style.backgroundColor= "#fff";
			  document.getElementById("prescripcion").style.backgroundColor= "silver";
			  document.getElementById("guardar").style.backgroundColor= "silver";
		}
		function Pres_Med() 
		{
			  document.getElementById("con_pac").style.display = "none";
			  document.getElementById("con_historial").style.display = "none";
			  document.getElementById("cons").style.display = "none";
			  document.getElementById("trata").style.display = "none";
			  document.getElementById("medi").style.display = "none";
			  document.getElementById("pres").style.display = "block";
			  document.getElementById("paciente").style.backgroundColor= "silver";
			  document.getElementById("historial").style.backgroundColor= "silver";
			  document.getElementById("consulta").style.backgroundColor= "silver";
			  document.getElementById("tratamiento").style.backgroundColor= "silver";
			  document.getElementById("medicamento").style.backgroundColor= "silver";
			  document.getElementById("prescripcion").style.backgroundColor= "#fff";
			  document.getElementById("guardar").style.backgroundColor= "silver";
		}
		function Guardar() 
		{			
			var text_area=document.getElementById("consulta_medica");									
			var text_area2=document.getElementById("prescripciones");											
			
			if (window.XMLHttpRequest){ xmlhttp=new XMLHttpRequest(); }
			else{ xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); }
			xmlhttp.onreadystatechange=function()
			{
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			  {					
				//document.getElementById("span").innerHTML=xmlhttp.responseText;
				alert(xmlhttp.responseText);
			  }
			  }
			xmlhttp.open("GET","add_php.php?array="+array+"&array_m="+array_m+"&consulta="+text_area.value+"&prescripcion="+text_area2.value,true);
			xmlhttp.send();
		}
		function color() 
		{
			document.getElementById("guardar").style.backgroundColor= "#0A0";
		}
		function color_back() 
		{
			document.getElementById("guardar").style.backgroundColor= "silver";
		}

		</script>

	</head>
	<?php
		session_start();
		/*session_start();
		if(!$_SESSION)
			header("location:index.php");
			
			
		require("BD.php");
        include("templates/conexion.php");*/
	?>
	<body>
	
		<body class="uno">
			<!--Div Principal-->
			<div class="dos">
			<!--Div Central-->
				<div class="tres">
					<!--Div Logotipo-->
					<div class="cuatro">
						<img class="cinco"src="../../IMG/medico.jpg" style="border-radius: 10px 10px 10px 10px;">
					</div>
					<!--Div Escritura-->
					<div class="seis">
						<p class="siete">Clínica Dermatológica del Istmo</p>
						<p class="ocho">Prolongación Juchitán #32. Tel. 971221212</p>
						<>
					</div>
					<div class="nueve"></div>
					<div class="diez"> </div>
					<div class="once"></div>
				</div>
			</div>
		<!--Div Contenedor-->
		<div class="doce">
			<div class="trece"></div>
			<div style="width: 960px; height:80px;">
				<div style="width: auto; height: auto; float: right; border-radius: 0px 0px 0px 10px; box-shadow: 1px 5px 5px #888888; margin-right:2px;">
					<div style="width: 80px; height: auto;  float: right; margin: 20px; background-color: #fff; border-radius: 10px;">
						<center>
						<img src="../../IMG/cerrar.png" width= 50px; height= 50px; style="margin:10px;">
						<div style="text-align:center">Salir</div>
						</center>
					</div>
					<div style="width: 80px; height: auto;  float: right;  margin: 20px 0px 20px 20px; background-color: #fff;  border-radius: 10px;">
						<center>
						<img src="../../IMG/receta.png" width= 50px; height= 50px; style="margin:10px;">
						<div style="text-align:center"><a href="consulta_doc.php" style="text-decoration: none; color: #000; cursor: default;">Consulta</a></div>
						</center>
					</div>
					<div style="width: 80px; height: auto;  float: right; margin: 20px 0px 20px 20px; background-color: #fff;  border-radius: 10px; background-color: #031298; color: #fff; font-weight: bold;">
						<center>
						<img src="../../IMG/msg.png" width= 50px; height= 50px; style="margin:10px;">
						<div style="text-align:center"><a href="index_doc.php" style="text-decoration: none; color: #fff; cursor: default;">Recepción</a></div>
						</center>
					</div>

					<div style="clear: both;"></div>
				</div>
				<div style="width: auto; height: auto; float: left; border-radius: 10px 0px 10px 0px; box-shadow: 1px 5px 5px #888888; margin-right:2px;">
					<div style="width: auto; height: auto;  float: left; margin: 20px 20px 20px 20px; background-color: #fff;  border-radius: 10px;">
						<center>
						<img src="../../IMG/nuevo.png" width= 50px; height= 50px; style="margin:10px;">
						</center>
						<div style="text-align:center; padding: 0px 10px 0px 10px;"><?php// echo($_SESSION["user"]);?></div>
					</div>
					<div style="clear: both;"></div>
				</div>
			</div>
			<div style="background-color: gray; width: 940px; height: 540px; margin-top: 70px; margin-left: 10px; border-radius: 10px;  ">
				<center>
					<div class="catorce" style="background-color:silver; text-align: right;">	
						<p></p>
						
						<p id="paciente" onclick="Pacientes()" style="padding: 10px; margin-top: 0px; background-color: #fff; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Paciente</p>
						<p id="historial" onclick="His_Cli()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Historial Médico</p>
						<p id="consulta" onclick="Con_Med()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Consulta médica</p>
						<p id="tratamiento" onclick="Tra_Med()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Agregar Tratamiento</p>
						<p id="medicamento" onclick="Med_Med()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Agregar Medicamentos</p>
						<p id="prescripcion" onclick="Pres_Med()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;">Agregar Prescripción</p>						
						<p id="guardar" onclick="Guardar();" onmouseover="color()" onmouseout="color_back()" style="padding: 10px; margin-top: 0px; background-color: silver; border-radius: 0px 0px 0px 0px; width: 160px; float: right; border-radius: 10px 0px 0px 10px; cursor: hand;" />Guardar y enviar</p>
					</div>
					<div class="diecinueve" id="conte" style="height: 500px;" >
						<div style="margin:20px; width: 630px; height:400px;">
							<script>/*
								function carga()
								{			
									if (window.XMLHttpRequest){ xmlhttp=new XMLHttpRequest(); }
									else{ xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); }
									xmlhttp.onreadystatechange=function()
									{
									  if (xmlhttp.readyState==4 && xmlhttp.status==200)
									  {
										document.getElementById("con_pac").innerHTML=xmlhttp.responseText;
									  }
									  }
									xmlhttp.open("GET","consulta.php?",true);
									xmlhttp.send();
								}
								
								function carga2()
								{			
									if (window.XMLHttpRequest){ xmlhttp=new XMLHttpRequest(); }
									else{ xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); }
									xmlhttp.onreadystatechange=function()
									{
									  if (xmlhttp.readyState==4 && xmlhttp.status==200)
									  {
										document.getElementById("con_historial").innerHTML=xmlhttp.responseText;
									  }
									  }
									xmlhttp.open("GET","historial.php? ",true);
									xmlhttp.send();
								}*/
							</script>
							<div id="con_pac">
							</div>
							<div id="con_historial" style="display:none;">																
							</div>							
								<div id="cons" style="display:none;"> 
										<h3 style="text-align: left; font-family: Cambria; font-size: 16px;">Consulta médica</h3>
										<center> 
										<hr>
										<textarea id="consulta_medica" style="position:absolute;width:600px;height:200px;" placeholder="Escriba aqui la consulta"></textarea>
								</div>
								<div id="trata" style="display:none;"> 
										<h3 style="text-align: left; font-family: Cambria; font-size: 18px;">Tratamientos del Paciente</h3>
										<center> 
										<hr>
										<label style="position:absolute;">Tratamientos</label>
										<div style="margin-top:40px;position:absolute;border:1px solid silver;width:200px;height:300px;overflow-y:scroll;
											text-align:left;font-size:20px;">
										<ul style="margin:0px;margin-left:0px;padding:0px;">
										<?php
											/*$sql="select * from tratamientos";
											$consulta = $miconexion -> consulta($sql);
											while($row = $miconexion->fetch_array($consulta)){
												echo("<li id=".$row[1]." class='sel_lista' onclick='elegir(this)' style='border-bottom:1px solid silver;'>".$row[1]."</li>");
												}*/
										?>
										</ul>
										</div>
										<button onclick="agregar();" style="width:100px;height:30px;background:blue;color:white;border:none;
											margin-top:150px;position:absolute;margin-left:265px;cursor:hand;">
											Agregar >>
										</button>
										
										<label style="position:absolute;margin-left:480px;">Tratamientos agregados</label>
										<div id="t_add" style="margin-top:40px;position:absolute;border:1px solid silver;width:200px;height:300px;overflow-y:scroll;
											text-align:left;font-size:20px;margin-left:420px;">
										<ul style="margin:0px;margin-left:0px;padding:0px;">										
										</ul>
										</div>
										
										
								</div>
								<div id="medi" style="display:none;"> 
										<h3 style="text-align: left; font-family: Cambria; font-size: 18px;">Medicamentos Recetados</h3>
										<center> 
										<hr>
										<label style="position:absolute;">Medicamentos</label>
										<div style="margin-top:40px;position:absolute;border:1px solid silver;width:200px;height:300px;overflow-y:scroll;
											text-align:left;font-size:20px;">
										<ul style="margin:0px;margin-left:0px;padding:0px;">
										<?php
											$sql="select * from medicamentos";
											$consulta = $miconexion -> consulta($sql);
											while($row = $miconexion->fetch_array($consulta)){
												echo("<li id=".$row[1]." class='sel_lista' onclick='elegir_m(this)' style='border-bottom:1px solid silver;'>".$row[1]."</li>");
												}
										?>
										</ul>
										</div>
										<button onclick="agregar_m();" style="width:100px;height:30px;background:blue;color:white;border:none;
											margin-top:150px;position:absolute;margin-left:265px;cursor:hand;">
											Agregar >>
										</button>
										
										<label style="position:absolute;margin-left:480px;">Medicamentos agregados</label>
										<div id="m_add"  style="margin-top:40px;position:absolute;border:1px solid silver;width:200px;height:300px;overflow-y:scroll;
											text-align:left;font-size:20px;margin-left:420px;">
										<ul style="margin:0px;margin-left:0px;padding:0px;">										
										</ul>
										</div>
										
								</div>
								<div id="pres" style="display:none;"> 
										<h3 style="text-align: left; font-family: Cambria; font-size: 18px;">Prescripción</h3>
										<center> 
										<hr>
										<textarea id="prescripciones" style="position:absolute;width:600px;height:200px;" placeholder="Escriba aqui la prescripción"></textarea>
								</div>
						</div>
					</div>
				</center>
			</div>
			<div style="height: 10px;"></div>
			<div class="veinticinco"></div>
		</div>
		<span id="span"></span>
		
	</body>
</html>