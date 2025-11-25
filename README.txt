- Ejercicio técnico:

Se desarrolló una aplicación REST CRUD (ABM) de la entidad Bank, utilizando el siguiente stack:

1) Java 21
2) Spring Boot 3.5.8
3) Jakarta Persistence (JPA)
4) Base de datos en memoria H2
5) Swagger/OpenAPI para documentación
6) Tests unitarios con JUnit + Mockito
7) Arquitectura en capas sencilla (Controller → Service → Repository)
8) Seguridad mediante Bearer Token + configuración CORS
9) Spring Actuator.

* Pasos:
1) Ejecutar mvn clean install.
3) Dar Run a la clase MsBankApplication.

* URLs principales

Health Check (Actuator)
    http://localhost:8080/bank-service/actuator/health
Swagger UI
    http://localhost:8080/bank-service/swagger-ui/index.html
Consola de H2
    http://localhost:8080/bank-service/h2-console