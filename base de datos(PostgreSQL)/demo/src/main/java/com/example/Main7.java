package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main7 {
    public static void main(String[] args) throws Exception {
          
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market?user=postgres&password=tuputanga");
        try( Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT \r\n" + //
                        "\t    f.fecha_emision, \r\n" + //
                        "\t    c.nombre AS nombre_cliente, \r\n" + //
                        "\t    c.apellido, \r\n" + //
                        "\t    p.nombre AS nombre_producto, \r\n" + //
                        "\t    ft.nombre AS tipo_factura, \r\n" + //
                        "\t    fd.cantidad\r\n" + //
                        "\tfrom factura f\r\n" + //
                        "\t\r\n" + //
                        "\tjoin cliente c on c.id = f.cliente_id\r\n" + //
                        "\tjoin factura_detalle fd on fd.factura_id = f.id\r\n" + //
                        "\tjoin producto p on p.id = fd.producto_id\r\n" + //
                        "\tjoin factura_tipo ft on ft.id = f.factura_tipo_id\r\n" + //
                        "\t\r\n" + //
                        "\torder by fd.cantidad;")){
                            while(rs.next()){
                                String fecha = rs.getString("fecha_emision");
                                String nombre = rs.getString("nombre_cliente");
                                String apellido = rs.getString("apellido");
                                String producto = rs.getString("nombre_producto");
                                int cantidad = rs.getInt("cantidad");
                                String tipoFac = rs.getString("tipo_factura");

                                System.out.println("Clientes: " + fecha + " " + nombre + " " + apellido + " " + producto + " - " + cantidad + " " + tipoFac);
                            }
                        }
          
        
    }
}