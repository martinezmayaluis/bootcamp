package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT c.id, c.nombre, c.apellido, COUNT(f.id) AS cantidad_factura\r\n" + //
                        "\r\n" + //
                        "FROM cliente c\r\n" + //
                        "\r\n" + //
                        "JOIN factura f on c.id = f.cliente_id\r\n" + //
                        "JOIN factura_detalle fd on f.id =fd.factura_id\r\n" + //
                        "JOIN producto p on p.id =fd.producto_id\r\n" + //
                        "\r\n" + //
                        "GROUP BY c.id, c.nombre, c.apellido\r\n" + //
                        "\r\n" + //
                        "ORDER BY cantidad_factura DESC\r\n" + //
                        "LIMIT 10;")){
                            while(rs.next()){
                                String nombre = rs.getString("nombre");
                                String apellido = rs.getString("apellido");
                                int cantfactura = rs.getInt("cantidad_factura");

                                System.out.println("Clientes: " + nombre + " " + apellido +  " - " + cantfactura);
                            }
                        }
          
        
    }
}