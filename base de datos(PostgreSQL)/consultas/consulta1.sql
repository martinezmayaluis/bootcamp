SELECT c.id, c.nombre, c.apellido, COUNT(f.id) AS cantidad_factura

FROM cliente c

JOIN factura f on c.id = f.cliente_id
JOIN factura_detalle fd on f.id =fd.factura_id
JOIN producto p on p.id =fd.producto_id

GROUP BY c.id, c.nombre, c.apellido

ORDER BY cantidad_factura DESC
LIMIT 10;