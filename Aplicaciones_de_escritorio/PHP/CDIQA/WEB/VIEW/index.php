<html>
	<head>
		<title>Login</title>
		<?php 
			require("../CONTROLLER/CONTROLLER.php");
			
			if(isset($_SESSION)) 
				session_destroy();
						
		?>
		<link rel="stylesheet" href="../CSS/style.css" title="relative" type="text/css">
	</head>
	
	<body class="body_page">
		<div id="div_page">
			<div id="div_head">
				<center>
					<div id="div_presentacion">				

						<div id="div_logo">
							<img src="../IMG/medico.jpg" >
						</div>
						<div id="div_main">
							<div class="div_titulo">
								<p style="font-size:28px">CLINICA DERMATOLÓGICA DEL ISTMO</p>
								<p>Prolongación Juchitán #32. Tel. 971221212</p>
							</div>
							<div class="div_blue"></div>
							<div class="div_red"></div>
						</div>						
					</div>
				<center>
			</div>
			<center>
				<div id="div_contenido">
					<div id="div_login">
						<label class="label_title">
							Inicio de sesión
						</label>
						<center>
							<form action=<?php echo(CMD_CONTROLLER::INDEX_CMD); ?> method="POST">
								<table>
									<tr>
										<td>
											Usuario:
										</td>
										
									</tr>
									<tr>
										<td>
											<input type="text" name="User">
										</td>
									</tr>
									<tr>
										<td>
											Contraseña:
										</td>
									</tr>
									<tr>
										<td>
											<input type="password" name="Pass">
										</td>
									</tr>
									<tr>
										<td>
											<br><br>
											<input type="submit" value="Iniciar sesión" style="cursor:pointer;">
										</td>
									</tr>
								</table>
							</form>
						</center>
					</div>
				</div>
			</center>
		</div>
	</body>
</html>