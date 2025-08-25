select f.id, f.fecha_emision, SUM(fd.cantidad * p.precio) AS total
from factura f

join factura_detalle fd on fd.factura_id = f.id
join producto p on p.id = fd.producto_id
 group by f.id, f.fecha_emision
 order by total desc

 limit 10;