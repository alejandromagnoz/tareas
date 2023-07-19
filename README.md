# Api Tareas Backend
## Swagger
Swagger http://localhost:8080/swagger-ui.html

Contiene los siguientes endpoints:
 
1. Endpoint para obtener tareas 
GET "http://localhost:8080/tareas"
Response Body Tarea
   {
   "id": 131,
   "descripcion": "ejemplo",
   "vigente": false,
   "fechaCreacion": "18/07/2023 14:02:54"
   }

2. Endpoint para Crear tarea
   POST "http://localhost:8080/tareas"
   Request Body Tarea a llenar
   {
   "descripcion": "ejemplo",
   "fechaCreacion": "18/07/2023 14:02:54",
   "id": 0,
   "vigente": false
   }

3. Endpoint para Editar tarea
   PUT "http://localhost:8080/tareas/{id}"
   Request Body Tarea a modificar
   {
   "descripcion": "modificado",
   "fechaCreacion": "18/07/2023 15:02:54",
   "id": 0,
   "vigente": true
   }

4. Endpoint para Remover tarea
   DELETE "http://localhost:8080/tareas/{id}"
   

## Estructura de directorios
```
/src/main/java/
/src/main/java/com/nvooaj/configuration
/src/main/java/com/nvooaj/controller
/src/main/java/com/nvooaj/exception
/src/main/java/com/nvooaj/entity
/src/main/java/com/nvooaj/repository
/src/main/java/com/nvooaj/service
/src/main/resources

/src/test/java/
/src/test/java/com/nvooaj/controller

```
## Java
- 1.8

## Instalación
1. Descargar el proyecto desde github:https://github.com/alejandromagnoz/tareas
o crear directorio en en el equipo local y mediante consola de comando ejecutar lo siguiente:
```
git clone https://github.com/alejandromagnoz/tareas.git

```

## Configuración
Abrir el proyecto de tipo **maven** en el IDE deseado y actualizar.  
Las versiones utilizadas están definidas en el archivo pom.xml.


## Ejecución
- Para ejecutar el proyecto, se puede utilizar el IDE intellij
- Abrir el proyecto  File --> Open...
- Esperar que cargue el proyecto y sus dependencias.
- En la pestaña Maven (lado derecho del Ide) presionar sobre el icono Execute maven goal el siguiente comando
```
mvn spring-boot:run
```
- Esperar que compile correctamente y que se inicie Started ApptareaApplication
- Acceder a Swagger para hacer pruebas o usar postman
```
http://localhost:8080/swagger-ui.html
```

## Pruebas
Para ejecutar las pruebas, es necesario ejecutar el comando siguiente:
```
mvn test
```

## Base de datos
Se usa una base de datos embebida h2 en el proyecto

- http://localhost:8080/h2-console
en la consola en JDBC URL cambiar valor por jdbc:h2:~/test
- User name: sa
- Pass (dejar vacio)


## Misceláneo

### Repositorios del proyecto

| Tipo                             | Nombre    | URL                                               |
| -------------------------------- | --------- | -------------------------------------------------------------------- |
| Repositorio de código fuente     | GitHub    | https://github.com/alejandromagnoz/tareas|



### IDE sugerido
Intellij - *IntelliJ IDEA 2023.1.2 (Community Edition)*
