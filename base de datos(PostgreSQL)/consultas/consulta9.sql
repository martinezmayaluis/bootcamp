select f.id, f.fecha_emision, round(SUM(fd.cantidad * p.precio)) AS total, round(SUM(fd.cantidad * p.precio)*0.10) AS IVA 
from factura f

join factura_detalle fd on fd.factura_id = f.id
join producto p on p.id = fd.producto_id
 group by f.id, f.fecha_emision
 order by IVA desc

 limit 10;