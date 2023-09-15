package practicas.baseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class pruebaBD {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/universidad";
        String usuario = "root";
        String contraseña = "";

        try {
            Connection conexión = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            // Realiza operaciones con la base de datos aquí
            conexión.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
