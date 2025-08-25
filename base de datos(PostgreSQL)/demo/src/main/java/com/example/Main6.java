package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main6 {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT p.id, p.nombre, COUNT(fd.producto_id) AS cantidad_producto\r\n" + //
                        "\r\n" + //
                        "FROM factura_detalle fd\r\n" + //
                        "\r\n" + //
                        "JOIN producto p ON p.id = fd.producto_id\r\n" + //
                        "\r\n" + //
                        "GROUP BY p.id, p.nombre\r\n" + //
                        "\r\n" + //
                        "ORDER BY cantidad_producto ASC\r\n" + //
                        "LIMIT 10;")){
                            while(rs.next()){
                                String nombre = rs.getString("nombre");

                                int cantidad = rs.getInt("cantidad_producto");

                                System.out.println("Productos: " + nombre + " " + " - " + cantidad);
                            }
                        }
          
        
    }
}