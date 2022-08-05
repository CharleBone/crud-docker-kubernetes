# docker-services
# MICROSERVICIO USUARIOS

| DESCRIPCION  | URL               | PETICION | HEADER  | RESPUESTA
| ------ |-------------------|----------| ------ | ------ |
| Mostrar una lista de Personas | localhost:8001    | GET      | | JSON | 
| Agregar Persona | localhost:8001    | POST     | Content-Type: application/json |
| Buscar Persona | localhost:8001/1  | GET      |   | JSON
| Actualizar Persona | localhost:8001/1  | PUT      | Content-Type: application/json |
| Eliminar Persona | localhost:8001/1  |  DELETE  | Content-Type: application/json

- Ejemplo de como insertar un nuevo usuario

![N|Solid](https://github.com/CharleBone/docker-services/blob/master/usuarios/src/main/resources/static/imagenes_ejemplo/post-user.PNG)

# MICROSERVICIO CURSOS

| DESCRIPCION                 | URL              | PETICION | HEADER  | RESPUESTA
|-----------------------------|------------------|----------| ------ | ------ |
| Mostrar una lista de Cursos | localhost:8002   | GET      | | JSON | 
| Agregar Curso               | localhost:8002   | POST     | Content-Type: application/json |
| Buscar Curso                | localhost:8002/1 | GET      |   | JSON
| Actualizar Curso            | localhost:8002/1 | PUT      | Content-Type: application/json |
| Eliminar Curso              | localhost:8002/1 |  DELETE  | Content-Type: application/json

- Ejemplo de como insertar un nuevo curso

![N|Solid](https://github.com/CharleBone/docker-services/blob/master/usuarios/src/main/resources/static/imagenes_ejemplo/post-user.PNG)