select
m.nombre AS moneda,
COUNT(*) AS cantidad_uso
from factura f

join moneda m on m.id =f.moneda_id
group by m.nombre
order by cantidad_uso desc

limit 10;