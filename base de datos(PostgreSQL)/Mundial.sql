create table equipos(
	clave serial,
	nombre varchar(20),
	integrates int,
	primary key (clave)
	);

create table grupos(
	clave serial,	
	nombre varchar(20),
	codigoequipos smallint references equipos(clave),
	primary key (clave)
);

create table partidos(
	clave serial,
	tiempo varchar (20),
	puntaje_final varchar(10),
	codigoequipos smallint references equipos(clave),
	codigofases smallint references fases(clave),
	primary key (clave)
);

create table resultados(
	clave serial,
	ganador varchar(20),
	codigopartidos smallint references partidos(clave),
	primary key (clave)
);

create table fases(
	clave serial,
	nombre varchar(20),
	primary key (clave)
);
