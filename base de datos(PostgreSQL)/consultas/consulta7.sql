	SELECT 
	    f.fecha_emision, 
	    c.nombre AS nombre_cliente, 
	    c.apellido, 
	    p.nombre AS nombre_producto, 
	    ft.nombre AS tipo_factura, 
	    fd.cantidad
	from factura f
	
	join cliente c on c.id = f.cliente_id
	join factura_detalle fd on fd.factura_id = f.id
	join producto p on p.id = fd.producto_id
	join factura_tipo ft on ft.id = f.factura_tipo_id
	
	order by fd.cantidad;


