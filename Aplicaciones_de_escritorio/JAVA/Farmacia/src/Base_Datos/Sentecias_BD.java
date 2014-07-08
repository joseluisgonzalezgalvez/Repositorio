/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Sentecias_BD{
    static public Connection conn = null;//para realizar la conexion
    static private Statement st;//para definir una sentencia en Mysql
    static private ResultSet rs;//para almacenar la informacion obtenida de la BD
    Connection conexion;
    ResultSet resultado;
    
    public void Open(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Farmacia_PV", "sa", "root");
            st = conn.createStatement();
          }catch ( Exception  e ) {
              JOptionPane.showMessageDialog(null,"¡Ocurrió un error  al conectarse con el Servidor de BD, Porfavor Contacte a mantenimiento","Configuración de Servidor",JOptionPane.INFORMATION_MESSAGE);
          }
    }
    public void Close (){
    	try{
               conn.close();
           	st.close();
        }
        catch(SQLException ex){}
    }
    public void Alta_Provedor(String Nombre,String Empresa,String Direccion,String Telefono) throws SQLException{
        String Consultando = "Insert into Provedor VALUES ('"+Nombre+"','"+Empresa+"','"+Direccion+"','"+Telefono+"')";
            st.executeUpdate(Consultando);
    }
    public void Alta_Paciente(String Nombre,String Direccion,String Ciudad,String Telefono,int Edad,String Sexo, double Peso,double altura,String Estado) throws SQLException
            {
        String Consultando = "Insert into Paciente VALUES ('"+Nombre+"','"+Direccion+"','"+Ciudad+"','"+Telefono+"','"+Edad+"','"+Sexo+"','"+Peso+"','"+altura+"','"+Estado+"')";
            st.executeUpdate(Consultando);
    }
    
    public void Alta_receta(int Id_Em,int Id_Paciente,String Descripcion) throws SQLException{
        JOptionPane.showMessageDialog(null, "Insert into Receta VALUES ("+Id_Em+","+Id_Paciente+",'"+Descripcion+"')");
        String Consultando = "Insert into Receta VALUES ("+Id_Em+","+Id_Paciente+",'"+Descripcion+"')";
            st.executeUpdate(Consultando);
    }
    
    public void Alta_Producto(String Nombre,String Cientifico,String Tipo,String Fecha,String Empaqe,Double Precio,int Cantidad,int Cantidad_Min,int Cantidad_Max,int Id,String Dire) throws SQLException{
        String Consulta = "exec Altas_Productos '"+Nombre+"','"+Cientifico+"','"+Tipo+"','"+Fecha+"','"+Empaqe+"','"+Precio+"','"+Cantidad+"','"+Cantidad_Min+"','"+Cantidad_Max+"','"+Id+"','"+Dire+"'";
            st.executeUpdate(Consulta);
    }
    public ResultSet Consulta_Clave_Provedor(){
        try{
            String sql ="Select * From Provedor";
            rs= st.executeQuery(sql);
        }
        catch(SQLException e){
        }
        return rs;
    }
    public void Modificar_Provedor(String Columna,String Valor_Nuevo,int Id_Provedor) throws SQLException{
        String Consultando = "Update Provedor set "+Columna+" = '"+Valor_Nuevo+"' Where Id_Provedor = "+Id_Provedor+"";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    } 
    
    
    public void Modificar_Empleado(String Columna,String Valor_Nuevo,int Id_Provedor) throws SQLException{
        String Consultando = "Update Empleado set "+Columna+" = '"+Valor_Nuevo+"' Where Id_Empleado = "+Id_Provedor+"";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    }   
    
    
    public void Modificar_Producto(String Columna,String Valor_Nuevo,int Id_Pro) throws SQLException{
        String Consultando = "Update Producto set "+Columna+" = '"+Valor_Nuevo+"' Where Id_Producto = "+Id_Pro+"";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    }
    public void Modificar_Producto_int(String Columna,int Valor_Nuevo,int Id_Pro) throws SQLException{
        String Consultando = "Update Producto set "+Columna+" = '"+Valor_Nuevo+"' Where Id_Producto = "+Id_Pro+"";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    }
    
    public void Modificar_Producto_Double(String Columna,Double Valor_Nuevo,int Id_Pro) throws SQLException{
        String Consultando = "Update Producto set "+Columna+" = '"+Valor_Nuevo+"' Where Id_Producto = "+Id_Pro+"";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    }
    
    
    
    public void Modificar_Cantidad(int Valor_Nuevo,int Id_Pro) throws SQLException{
        String Consultando = "Update Producto set Cantidad_Producto =  "+Id_Pro+" Where Id_Producto ='"+Valor_Nuevo+"'";
        JOptionPane.showMessageDialog(null,Consultando);
            st.executeUpdate(Consultando);
    }  
    public void Eliminar_Provedor(int Id_Provedor) throws SQLException{
        String Consultando = "Delete Provedor Where Id_Provedor = "+Id_Provedor+"";
        JOptionPane.showMessageDialog(null,Consultando);
        st.executeUpdate(Consultando);
    }    
    public void Eliminar_Empleado(int Id_Provedor) throws SQLException{
        String Consultando = "Delete Empleado Where Id_Empleado = "+Id_Provedor+"";
        JOptionPane.showMessageDialog(null,Consultando);
        st.executeUpdate(Consultando);
    }   
    public void Eliminar_Productos(int Id_Pro) throws SQLException{
        String Consultando = "Delete Producto Where Id_Producto = "+Id_Pro+"";
        JOptionPane.showMessageDialog(null,Consultando);
        st.executeUpdate(Consultando);
    }     
    public ResultSet Consulta_Nombre_Empleado(){
        try{
            String sql ="Select Nombre_Empleado From Empleado";
            rs= st.executeQuery(sql);
        }
        catch(SQLException e){
        }
        return rs;
    }
    public String Fuc_Cadena(String Columna, int Posicion){
        String n="";
        try {
            rs = st.executeQuery("Select "+Columna+" From Provedor Where Id_Provedor ='"+Posicion+"'");
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {System.out.println("Error");}
        return n;
    }
    public ResultSet Llenar_Tabla_Profesor(){
        try{
            st=conn.createStatement();
            rs=st.executeQuery("Select * From Provedor");
        }catch(SQLException ex){
        }
        return rs;
    }
    public ResultSet Llenar_Tabla_Empleado(){
        try{
            st=conn.createStatement();
            rs=st.executeQuery("Select * From Empleado");
        }catch(SQLException ex){
        }
        return rs;
    }
    public ResultSet Llenar_Tabla_Producto(){
        try{
            st=conn.createStatement();
            rs=st.executeQuery("Select Id_Producto,Nombre_Producto,Nombre_Cientifico,Forma_Farmaceutica,Fecha_Caducidad,Cantidad,Precio,Cantidad_Producto,Existencia_Minima,Existencia_Maxima,Imagen From Producto");
        }catch(SQLException ex){
        }
        return rs;
    }
    public ResultSet Llenar_Tabla_Profesor_Consulta(String Columna,String Dato){
        try{
            st=conn.createStatement();
            //JOptionPane.showMessageDialog(null,"Select * From Provedor Where '"+Columna+"' ='"+Dato+"'");
            rs=st.executeQuery("Select * From Provedor Where "+Columna+" ='"+Dato+"'");
           // JOptionPane.showMessageDialog(null,rs);
        }catch(SQLException ex){
        }
        return rs;
    }
    public ResultSet Llenar_Tabla_Empleado_Consulta(String Columna,String Dato){
        try{
            st=conn.createStatement();
            //JOptionPane.showMessageDialog(null,"Select * From Provedor Where '"+Columna+"' ='"+Dato+"'");
            rs=st.executeQuery("Select * From Empleado Where "+Columna+" ='"+Dato+"'");
           // JOptionPane.showMessageDialog(null,rs);
        }catch(SQLException ex){
        }
        return rs;
    }
    
    public ResultSet Llenar_Tabla_Producto_Consulta(String Columna,String Dato){
        try{
            st=conn.createStatement();
            //JOptionPane.showMessageDialog(null,"Select * From Producto Where '"+Columna+"' ='"+Dato+"'");
            rs=st.executeQuery("Select * From Producto Where "+Columna+" ='"+Dato+"'");

            //JOptionPane.showMessageDialog(null,rs);
        }catch(SQLException ex){
        }
        return rs;
    }
    public ResultSet Llenar_Tabla_Producto_Consulta_Por_Factura(String Columna,String Dato){
        try{
            st=conn.createStatement();
            //JOptionPane.showMessageDialog(null,"Select * From Producto Where '"+Columna+"' ='"+Dato+"'");
            rs=st.executeQuery("Select Id_Producto,Nombre_Producto,Nombre_Cientifico,Forma_Farmaceutica,Cantidad,Cantidad_Producto,Precio From Producto Where "+Columna+" ='"+Dato+"'");

            //JOptionPane.showMessageDialog(null,rs);
        }catch(SQLException ex){
        }
        return rs;
    }
    public int Contar_Empleados(String Puesto){
        String n="";
        int Contado=0;
        try {
            rs = st.executeQuery("Select Nombre_Empleado From Empleado Where Puesto ='"+Puesto+"'");
            while (rs.next()){
                n=rs.getString(1);
                Contado++;
            }
        } catch (SQLException ex) {}
        return Contado;
    }
    public int Maximo(int Id_Pro){
        int n=0;
        try {
            //JOptionPane.showMessageDialog(null,"Select Existencia_Minima From Producto Where Id_Producto ='"+Id_Pro+"'");
            rs = st.executeQuery("Select Existencia_Maxima From Producto Where Id_Producto ='"+Id_Pro+"'");
            
            while (rs.next()){
                n=rs.getInt(1);
                
            }
        } catch (SQLException ex) {}
        return n;
    }
    public int Minima(int Id_Pro){
        int n=0;
        try {
            //JOptionPane.showMessageDialog(null,"Select Existencia_Minima From Producto Where Id_Producto ='"+Id_Pro+"'");
            rs = st.executeQuery("Select Existencia_Minima From Producto Where Id_Producto ='"+Id_Pro+"'");
            
            while (rs.next()){
                n=rs.getInt(1);
                
            }
        } catch (SQLException ex) {}
        return n;
    }
    public int Cantid(int Id_Pro){
        int n=0;
        try {
            //JOptionPane.showMessageDialog(null,"Select Existencia_Minima From Producto Where Id_Producto ='"+Id_Pro+"'");
            rs = st.executeQuery("Select Cantidad_Producto From Producto Where Id_Producto ='"+Id_Pro+"'");
            
            while (rs.next()){
                n=rs.getInt(1);
                
            }
        } catch (SQLException ex) {}
        return n;
    }
    public JComboBox Pruebita(String Columna,JComboBox Nombres){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
                Nombres.addItem(n);
                //JOptionPane.showMessageDialog(null,n);
            }
        } catch (SQLException ex) {}
        return Nombres;
        
    }
    public String Obtener_Contrasenia(String Nombre){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Contrasenia From Empleado Where Nombre_Empleado ='"+Nombre+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
    }
        public String Obtener_Id(String Name){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Id_Empleado From Empleado Where Nombre_Empleado ='"+Name+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
        }
        public String Obtener_Id_Paciente(String Name){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Id_Paciente From Paciente Where Nombre_Paciente ='"+Name+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
        } 
        public String Obtener_Cedula(String Name){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Cedula_Profesional From Empleado Where Nombre_Empleado ='"+Name+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
        }
        public String Obtener_Especialidad(String Name){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Especialidad From Empleado Where Nombre_Empleado ='"+Name+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
        }
        public String Obtener_Name(String Nombre){
        String n="";
        try {
            //JOptionPane.showMessageDialog(null,"Select Nombre_Empleado From Empleado Where Puesto ='"+Columna+"'");
            rs = st.executeQuery("Select Nombre_Empleado From Empleado Where Id_Empleado ='"+Nombre+"'");
            //JOptionPane.showMessageDialog(null,rs);
            while (rs.next()){
                n=rs.getString(1);
            }
        } catch (SQLException ex) {}
        return n;
    }
            /*public void Alta_Empleado(String Nombre,String Dire,String Tele,String puest,String contra) throws SQLException{
        String Consultando = "Insert into Empleado VALUES ('"+Nombre+"','"+Dire+"','"+Tele+"','"+puest+"','"+contra+"')";
            st.executeUpdate(Consultando);
    }
*/
    public void Alta_Empleado2(String Nombre,String Dire,String Tele,String puest,String Ce,String Espe,String contra) throws SQLException{
        String Consultando = "Insert into Empleado VALUES ('"+Nombre+"','"+Dire+"','"+Tele+"','"+puest+"','"+Ce+"','"+Espe+"','"+contra+"')";
            st.executeUpdate(Consultando);
    }/*
    public static void main (String Args[]) throws SQLException{
        Sentecias_BD v = new Sentecias_BD();
        v.Open();
        v.Alta_Empleado("Hola","Hola","0123456789","Servicio", "1");
//        v.Alta_Paciente("JOse", "Nose", "Ixtepec", "971115246",20,"H",60.00, 1.80, "Medic");
        v.Close();   
    }
*/
}
