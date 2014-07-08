<?php 
/*require("../../SRC/UTIL/Arraylist.php");
echo(
'<form action="../../SRC/COMMAND/INDEX_CMD.php" method="post" name="formulario">
	 <input type="hidden" name="User" value='.$_POST["user"].'>
	 <input type="hidden" name="Password" value='.$_POST["pass"].'>
	 <input type="submit" name="button" value="press" id="btn">
 </form>'
 );
$arraylist = new Arraylist();

foreach($_POST as $nombre_campo => $valor){ 
    $asignacion = "\$" . $nombre_campo . "='" . $valor . "';"; 
	$arraylist->addItem($asignacion);
    //eval($asignacion); 
	//echo($asignacion."<br>");
 }

echo("Usuario: ".$arraylist->Item(0)."<br>");
*/?>
<!--script>
	document.getElementById("btn").click();
</script-->