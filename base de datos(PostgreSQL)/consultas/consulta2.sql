SELECT c.id, c.nombre, c.apellido, ROUND(SUM(fd.cantidad + p.precio)) AS total

FROM cliente c

JOIN factura f on c.id = f.cliente_id
JOIN factura_detalle fd on f.id =fd.factura_id
JOIN producto p on p.id =fd.producto_id

GROUP BY c.id, c.nombre, c.apellido

ORDER BY total DESC
LIMIT 10;