SELECT * FROM documento
SELECT * FROM persona
SELECT * FROM historial
SELECT * FROM rol
SELECT * FROM prioridad
SELECT * FROM estado
SELECT * FROM tipoDocumento
SELECT * FROM tipoIdentificacion
SELECT * FROM oficina
SELECT NOW();

INSERT INTO documento(idDocumento,visualizaciones,idRemitente,idDestinatario,idRecepcionista,idEstado,idPrioridad,fechaRadicacion,idOficina,idtipoDocumento)
VALUES (1,1,1000225552,1000225552,1000225552,1,1,NOW(),1,1)
GO

UPDATE persona SET clave='',usuario='' WHERE numeroIdentificacion = 1000225552

DELETE FROM documento
WHERE idDocumento=1

INSERT INTO historial(`idHistoria`,`idDocumento`,`fechaHistoria`,`respuestaComen`,`idDestinatario`) 
VALUES (2,8,NOW(),'COMENTARIO PRUBEA PONGA CUALQUIER VAINA',1111)

INSERT INTO oficina VALUES(2,"Ventas",3215)

INSERT INTO tipoIdentificacion VALUES (1,'Cédula de Ciudadanía')

INSERT INTO rol VALUES (1,'SuperADMIN')

INSERT INTO documento(idRemitente) VALUES ('1000225552')

INSERT INTO estado VALUES (1,'En proceso')

INSERT INTO prioridad VALUES (1,'Maxima')

INSERT INTO tipoDocumento VALUES (2,'Contratos')

INSERT INTO persona(numeroIdentificacion,tipoIdentificacion,nombre,apellido,correo,telefonoFijo,telefonoCelular,direccion,rol,usuario,clave,oficina) VALUES (987654321,1,'Prueba Prueba', 'Prueba Prueba', 'Prueba@gmail.com',98765432, 3219558419, '12345678901',2,'Prueba','987654321')

SELECT CONCAT(P.nombre,' ',P.apellido)nombre,P.numeroIdentificacion,P.direccion,P.telefonoFijo,P.telefonoCelular,P.correo,R.descripcion,O.nombreOficina FROM persona P 
INNER JOIN rol R ON P.rol=R.idRol INNER JOIN oficina O ON O.idOficina=P.oficina
WHERE P.rol>1

SELECT * FROM persona WHERE rol=1

SELECT CONCAT(nombre,' ',apellido)nombre,numeroIdentificacion 
FROM persona WHERE rol > 1 AND oficina=2

SELECT documentoPDF FROM documento

SELECT CONCAT(p.nombre,' ',p.apellido)nombre,d.idDocumento,d.visualizaciones,d.fechaRadicacion,r.descripcion,o.nombreOficina,t.descripcion FROM documento d INNER JOIN persona p ON d.`idRemitente`=p.`numeroIdentificacion` INNER JOIN oficina o ON d.`idOficina`=o.idOficina INNER JOIN prioridad r ON d.idPrioridad=r.idPrioridad INNER JOIN tipoDocumento t ON d.`idtipoDocumento`=t.`idtipoDocumento` WHERE idDestinatario=1000225552

SELECT * FROM rol WHERE idRol != 1

DELETE FROM persona WHERE numeroIdentificacion!=1000225552 AND numeroIdentificacion!=1002313750

INSERT INTO documento(`idRemitente`,`idDestinatario`,`idRecepcionista`) VALUES('159','159','159')