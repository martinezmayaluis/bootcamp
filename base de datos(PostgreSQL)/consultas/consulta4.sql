select
pr.nombre as proveedor,
COUNT (*) as top
from producto p

join proveedor pr on pr.id = p.proveedor_id
group by pr.nombre 
order by top desc
limit 10;