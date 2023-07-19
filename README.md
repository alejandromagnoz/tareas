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
/src/main/java/com/nvvoaj/configuration
/src/main/java/com/nvvoaj/controller
/src/main/java/com/nvvoaj/exception
/src/main/java/com/nvvoaj/entity
/src/main/java/com/nvvoaj/repository
/src/main/java/com/nvvoaj/service
/src/main/resources

```

## Instalación
1. Descargar el proyecto desde github:
```
git clone https://github.com/alejandromagnoz/tareas.git


```

## Configuración
Abrir el proyecto de tipo **maven** en el IDE deseado y actualizar.  
Las versiones utilizadas están definidas en el archivo pom.xml.


## Ejecución
Para ejecutar el proyecto, se puede utilizar el IDE o simplemente desde la línea de
comandos, ejecutar cualquiera de estas opciones:

### Java

```
#java -jar target/apptarea 0.0.1-SNAPSHOT.jar
```

### Maven plugin
```
mvn spring-boot:run
```


## Pruebas
Para ejecutar las pruebas, es necesario ejecutar el comando siguiente:
```
mvn test
```

## Base de datos
Se usa una base de datos embebida h2 en el proyecto


## Misceláneo

### Repositorios del proyecto

| Tipo                             | Nombre    | URL                                               |
| -------------------------------- | --------- | -------------------------------------------------------------------- |
| Repositorio de código fuente     | GitHub    | https://github.com/alejandromagnoz/tareas.git|



### IDE sugerido
Intellij - *IntelliJ IDEA 2023.1.2 (Community Edition)*
