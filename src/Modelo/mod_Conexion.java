package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mod_Conexion {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Librería de MySQL

    private String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    private String database = "notas";

    // Host
    private String hostname = "localhost";

    // Puerto
    private String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    private String username = "root";

    // Clave de usuario
    private String password = "*pass*";

    //Variable conexion
    private Connection con = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public Connection getConexion() {

        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mod_Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return con;
    }

}
