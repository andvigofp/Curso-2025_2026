# 1. Seleccionar los artículos de color negro y mostrar su número, nombre y peso, así como el nombre del proveedor.
select ar.art_codigo as codigo_artigo, ar.art_nome as nombre_articulo, ar.art_peso as peso_articulo, pr.prv_nome as nombre_provedor
from artigos as ar inner join provedores as pr on ar.art_provedor=pr.prv_id
where ar.art_color='NEGRO'; 

# 2. Mostrar para cada venta: nombre y apellidos del cliente y fecha de venta.
select cl.clt_nome as nombre, cl.clt_apelidos as apellidos, ve.ven_data as fecha_venta
from clientes as cl inner join vendas as ve on cl.clt_id=ve.ven_cliente;

# 3. Mostrar: número total de ventas, número de artículos vendidos, suma de unidades vendidas y la media de los precios de los artículos vendidos.
select count(distinct ve.ven_id) as numero_ventas,
    count(distinct dv.dev_artigo) as numero_articulos,
    sum(dv.dev_cantidade) as suma_unidades,
    round(avg(dv.dev_prezo_unitario),2) as media_precio
from vendas as ve inner join detalle_vendas as dv on dv.dev_venda = ve.ven_id;

# 4. Seleccionar para cada artículo su número, nombre, peso y el nombre que corresponde al peso (peso_nome), teniendo en cuenta la información contenida en la tabla pesos, 
# que dá un nombre a los pesos en función del intervalo al que pertenece, Ordenar el resultado por el peso del artículo, de mayor a menor.
select ar.art_codigo, ar.art_nome, ar.art_peso, pe.peso_nome
from artigos as ar inner join pesos as pe on ar.art_peso between peso_min and peso_max
order by ar.art_peso;

# 5. Seleccionar para cada venta:
# Datos de la venta: identificar y fecha de la venta.
# Datos del cliente: nombre del cliente (nombre y apellidos separados por coma).
# Datos del empleado: nombre del empleado (nombre y apellidos separados por coma). Mostrar los datos ordenados por el apellido y nombre del cliente.
