package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main3 {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select\r\n" + //
                        "m.nombre AS moneda,\r\n" + //
                        "COUNT(*) AS cantidad_uso\r\n" + //
                        "from factura f\r\n" + //
                        "\r\n" + //
                        "join moneda m on m.id =f.moneda_id\r\n" + //
                        "group by m.nombre\r\n" + //
                        "order by cantidad_uso desc\r\n" + //
                        "\r\n" + //
                        "limit 10;")){
                            while(rs.next()){
                                String nombre = rs.getString("moneda");
                                int cantidad_uso = rs.getInt("cantidad_uso");

                                System.out.println("Monedas: " + nombre + " " + " - " + cantidad_uso);
                            }
                        }
          
        
    }
}