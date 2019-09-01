SELECT * FROM documento
SELECT * FROM persona
SELECT * FROM historial
SELECT * FROM rol
SELECT * FROM prioridad
SELECT * FROM estado
SELECT * FROM tipoDocumento
SELECT * FROM tipoIdentificacion
SELECT NOW();

INSERT INTO documento(idDocumento,visualizaciones,idRemitente,idDestinatario,idRecepcionista,idEstado,idPrioridad,fechaRadicacion,idOficina,idtipoDocumento)
VALUES (1,1,1000225552,1000225552,1000225552,1,1,NOW(),1,1)
GO

DELETE FROM documento

INSERT INTO historial(`idHistoria`,`idDocumento`,`fechaHistoria`,`respuestaComen`,`idDestinatario`) 
VALUES (1,1,NOW(),'COMENTARIO PRUBEA PONGA CUALQUIER VAINA',1000225552)

INSERT INTO oficina VALUES(2,"Ventas",3215)

INSERT INTO tipoIdentificacion VALUES (1,'Cédula de Ciudadanía')

INSERT INTO rol VALUES (1,'SuperADMIN')

INSERT INTO documento(idRemitente) VALUES ('1000225552')

INSERT INTO estado VALUES (1,'En proceso')

INSERT INTO prioridad VALUES (1,'Maxima')

INSERT INTO tipoDocumento VALUES (2,'Contratos')

INSERT INTO persona VALUES (1000225552,1,'MANUEL SEBASTIAN', 'CARDENAS PASCAGAZA', 'sc260101@gmail.com', 7317299, 3138230477, 'TV 13D ESTE #54-37 SUR',1)

SELECT CONCAT(P.nombre,' ',P.apellido)nombre,P.numeroIdentificacion,P.direccion,P.telefonoFijo,P.telefonoCelular,P.correo,R.descripcion,O.nombreOficina FROM persona P 
INNER JOIN rol R ON P.rol=R.idRol INNER JOIN oficina O ON O.idOficina=P.oficina
WHERE P.rol>1

SELECT * FROM persona WHERE rol=1