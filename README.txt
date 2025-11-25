- Santander Río, Ejercicio técnico:

Se realizó una aplicación que contiene un ABM REST de una entidad "Banco", utilizando el siguiente stack:

1) Java 21
2) SpringBoot v3.5.8
3) Hibernate
4) Persistencia de datos en Memoria (H2)
5) Swagger Api p/documentación de endpoints e información de Entidad Request.
6) Tests unitarios con Mockito
7) Arquitectura sencilla
8) Seguridad en peticiónes mediante Authentication por Bearer Token y configuración CORS

* Pasos:
1) Ejecutar mvn clean install para descargar dependencias utilizadas.
2) Validar el IDE configurado en Java 21
3) Dar Run a la clase MsBankApplication
4) Listo!

* URLs:
Actuador: http://localhost:8080/bank-service/actuator/health
Swagger: http://localhost:8080/bank-service/swagger-ui/index.html
H2Database: http://localhost:8080/bank-service/h2-console