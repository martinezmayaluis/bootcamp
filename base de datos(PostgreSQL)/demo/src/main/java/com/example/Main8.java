package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main8 {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select f.id, f.fecha_emision, SUM(fd.cantidad * p.precio) AS total\r\n" + //
                        "from factura f\r\n" + //
                        "\r\n" + //
                        "join factura_detalle fd on fd.factura_id = f.id\r\n" + //
                        "join producto p on p.id = fd.producto_id\r\n" + //
                        " group by f.id, f.fecha_emision\r\n" + //
                        " order by total desc\r\n" + //
                        "\r\n" + //
                        " limit 10;")){
                            while(rs.next()){
                                
                                int montoTotal = rs.getInt("id");

                                int total = rs.getInt("total");

                                System.out.println("Facturas: " + montoTotal + " " + " - " + total);
                            }
                        }
          
        
    }
}
