create table Bancos(
	idBanco int primary key identity(1,1),
	NombreBanco varchar(20) not null
);


create table Agencias(
	idAgencia int primary key identity(1,1),
	NombreAgencia varchar(40) not null,
	UbicacionAgencia varchar(40) not null,
	idBanco int foreign key(idBanco)
	references Bancos(idBanco) not null
);

create table Empleados(
	DNIEmpleado varchar(13) primary key ,
	NombresEmpleado varchar(40) not null,
	ApellidosEmpleado varchar(40) not null,
	FechaNacimiento date not null,
	Cargo varchar(30) not null,
	idBanco int  foreign key(idBanco)
	references Bancos(idBanco) not null
);


create table Usuarios(
	idUsuario int primary key identity(1,1),
	NombreUsuario varchar(30) not null,
	PasswordUsuario varbinary(50) not null,
	Estado bit not null,
	DNIEmpleado varchar(13) null
);

create table Permisos(
	idPermiso int primary key identity(1,1),
	DescripcionPermiso varchar(50) not null
);

create table PermisosUsuarios(
	 idPermisoUsuario int primary key identity(1,1),
	 idUsuario int foreign key (idUsuario) 
		references Usuarios(idUsuario) not null,
	 idPermiso int foreign key (idPermiso)
	 references Permisos(idPermiso) not null
);


create table Clientes(
	DNICliente varchar(13) primary key ,
	FechaNacimiento date not null,
	NombresCliente varchar(30) not null,
	Apellidos varchar(30) not null,
	Genero varchar(20) not null,
	EstadoCivil varchar(20) not null,
	Email varchar(50) not null,
	CelularCliente varchar(30) not null,
	TelefonoCliente varchar(30) not null
);

create table Cuentas(
	NoCuentaCliente varchar(50) primary key,
	SaldoApertura decimal(8,2) not null,
	Saldo decimal(8,2) not null,
	TipoCuenta varchar(40) not null,
	DNICliente varchar(13) foreign key (DNICliente)
	references Clientes(DNICliente) not null
);

create table Operaciones(
	idOperacion int primary key identity(1,1),
	NombreOperacion varchar(50) not null
);

create table Transacciones(
	idTransaccion int primary key identity(1,1),
	FechaTransaccion date not null,
	idOperacion int foreign key (idOperacion)
	references Operaciones(idOperacion) not null,
	NoCuentaCliente varchar(50) foreign key(NoCuentaCliente)
	references Cuentas(NoCuentaCliente) not null,
	SaldoAnterior decimal(8,2) not null,
	Importe decimal(8,2) not null,
	SaldoNuevo decimal(8,2) not null,
	DNIEmpleado varchar(13) foreign key(DNIEmpleado)
	references Empleados(DNIEmpleado) not null,
	idAgencia int foreign key(idAgencia)
	references Agencias(idAgencia) not null
);
