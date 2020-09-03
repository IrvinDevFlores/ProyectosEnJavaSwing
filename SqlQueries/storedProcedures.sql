go
CREATE PROC usp_ValidateUser
( @userName VARCHAR(50),
	@password VARCHAR(50)
)
AS
begin
declare @credentials TABLE(
	username varchar(50),
	userPassword varchar(50)
)

SELECT null,
	CASE WHEN NombreUsuario = 'korn' and PasswordUsuario = HASHBYTES('sha1', '1234') THEN  cast(1 as bit)
		ELSE   cast(0 as bit) end as TieneAcceso
	
FROM Usuarios;
end