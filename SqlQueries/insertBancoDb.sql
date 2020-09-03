--Bancos
insert into Bancos(NombreBanco) values('Banpais');

--Agencias
insert into Agencias(NombreAgencia, UbicacionAgencia, idBanco)
	values('Torre','San Pedro Sula', 1); 

insert into Agencias(NombreAgencia, UbicacionAgencia, idBanco)
	values('Plaza pedregal','San Pedro Sula', 1); 

insert into Agencias(NombreAgencia, UbicacionAgencia, idBanco)
	values('Megal Mall','San Pedro Sula', 1); 

insert into Agencias(NombreAgencia, UbicacionAgencia, idBanco)
	values('Principal la Ceiba','La Ceiba', 1); 

insert into Agencias(NombreAgencia, UbicacionAgencia, idBanco)
	values('Principal Tegus','Tegucigalpa', 1); 

--Empleados
insert into Empleados(DNIEmpleado, NombresEmpleado, ApellidosEmpleado, 
	FechaNacimiento, Cargo, idBanco)
	values('0101199702703','Jose','Cubas','2019-06-20', 'Cajero', 1); 

insert into Empleados(DNIEmpleado, NombresEmpleado, ApellidosEmpleado, 
	FechaNacimiento, Cargo, idBanco)
	values('0601198002703','Arnel','Cubas','1959-06-20', 'Cajero', 1); 

--Clientes
insert into Clientes(DNICliente, FechaNacimiento, NombresCliente, Apellidos,
	 Genero, EstadoCivil, Email, 
			CelularCliente, TelefonoCliente)
			values('030419903984', '1998-05-06', 'Jeison Erlik', 'Martinez', 'M', 'Soltero', 
			'jesion@gmail.com', '96658545', 'Pendiente');

insert into Clientes(DNICliente, FechaNacimiento, NombresCliente, Apellidos, 
	Genero, EstadoCivil, Email, 
			CelularCliente, TelefonoCliente)
			values('070419707984', '1998-08-06', 'Josh Gerson', 'Ramirez', 'M', 'Soltero', 
			'gerson@gmail.com', '88078545', 'Pendiente');

--Cuentas
insert into Cuentas(NoCuentaCliente, SaldoApertura, Saldo, TipoCuenta, DNICliente)
			values('6667771',5000, 5000, 'Clasica', '070419707984');

--Operaciones
insert into Operaciones( NombreOperacion)
			values('Deposito');

insert into Operaciones( NombreOperacion)
			values('Retiro');


--Usuarios

begin
declare @encriptedPass varbinary(50) = HASHBYTES('sha1','1234');
insert into Usuarios(NombreUsuario, PasswordUsuario, Estado,DNIEmpleado)
	values ('korn', @encriptedPass, 1,'0101199702703');
end
--Permisos
insert into Permisos(DescripcionPermiso)
	values ('HacerTransaccines');

--Permisos usuarios
insert into PermisosUsuarios(idUsuario, idPermiso) 
	values(1,1);