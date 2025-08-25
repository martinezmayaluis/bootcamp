package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main4 {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select\r\n" + //
                        "pr.nombre as proveedor,\r\n" + //
                        "COUNT (*) as top\r\n" + //
                        "from producto p\r\n" + //
                        "\r\n" + //
                        "join proveedor pr on pr.id = p.proveedor_id\r\n" + //
                        "group by pr.nombre \r\n" + //
                        "order by top desc\r\n" + //
                        "limit 10;")){
                            while(rs.next()){
                                String nombre = rs.getString("proveedor");

                                int top = rs.getInt("top");

                                System.out.println("Proveedores: " + nombre + " " + " - " + top);
                            }
                        }
          
        
    }
}