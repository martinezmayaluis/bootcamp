SELECT p.id, p.nombre, COUNT(fd.producto_id) AS cantidad_producto

FROM factura_detalle fd

JOIN producto p ON p.id = fd.producto_id

GROUP BY p.id, p.nombre

ORDER BY cantidad_producto DESC
LIMIT 10;