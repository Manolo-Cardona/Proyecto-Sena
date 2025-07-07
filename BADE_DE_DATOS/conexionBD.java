import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
  public static void main(String[] args) {

    // Datos para la conexion con MySQL 

    String url = "jdbc:mysql://localhost:3306/bd_citas_medicas";
    String usuario = "root";
    String password = "";

    Connection conexion;
    Statement statement;
    ResultSet rs;

    try {

      // Registrar el driver JDBC

      Class.forName("com.mysql.cj.jdbc.Driver");

      // Creación de la conexión

      conexion = DriverManager.getConnection(url, usuario, password);

      System.out.println("Conexión exitosa a la base de datos!");
      System.out.println("");

      // Consulta para la tabla de usuario, está tabla es importante porque le hereda a paciente y médico
      
      statement = conexion.createStatement();
      rs = statement.executeQuery("SELECT * FROM usuario");
      rs.next();

      System.out.println("--- Tabla de datos sobre los usuarios: ");
      System.out.println("");

      do {
        System.out.println(rs.getInt("id_usuario")+" : "+rs.getString("nombre_usuario")+" : "+rs.getString("apellido_usuario")+" : "+rs.getInt("documento_usuario")+" : "+rs.getString("correo_electronico_usuario"));
      } while(rs.next());


      // Consulta para la tabla paciente
      
      statement = conexion.createStatement();
      rs = statement.executeQuery("SELECT * FROM paciente");
      rs.next();

      System.out.println("");
      System.out.println("--- Tabla de datos sobre los pacientes: ");
      System.out.println("");

      do {
        System.out.println(rs.getInt("id_paciente")+" : "+rs.getDate("fecha_nacimiento")+" : "+rs.getString("EPS_paciente"));
      } while(rs.next());


      // Consulta para la tabla paciente
      
      statement = conexion.createStatement();
      rs = statement.executeQuery("SELECT * FROM medico");
      rs.next();

      System.out.println("");
      System.out.println("--- Tabla de datos sobre los médicos: ");
      System.out.println("");

      do {
        System.out.println(rs.getInt("id_medico")+" : "+rs.getString("especialidad_medico")+" : "+rs.getString("num_tarjeta_profesional"));
      } while(rs.next());

      conexion.close();
      
    } catch (ClassNotFoundException e) {
      System.out.println("Driver no encontrado: " + e.getMessage());

    } catch (SQLException e) {
      System.out.println("Error al conectar: " + e.getMessage());

    }

  }

}
