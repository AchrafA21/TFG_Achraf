/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;

    public Conexion() {
        try {
            // Cargar el driver de la base de datos (en este caso, HSQLDB)
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "SA", "");

            System.out.println("Conexión establecida correctamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver de la base de datos: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
