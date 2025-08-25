create table usuarios(
	clave serial, 
	nombre varchar(20),
	email varchar (30),
	primary key(clave)
	);

create table posts(
	clave serial,
	limite varchar (200),
	codigousurio smallint references usuarios(clave),
	primary key(clave)
);

update t posts;
create table comentarios(
	clave serial,
	limite varchar(200),
	codigousuario smallint references usuarios(clave),
	codigopost smallint references post(clave),
	primary key(clave)
);
