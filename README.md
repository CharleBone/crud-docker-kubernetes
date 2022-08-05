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

![N|Solid](https://github.com/CharleBone/docker-services/blob/master/cursos/src/main/resources/static/images_ejemplo/post-curso.PNG)

# CONEXIONES ENTRE MICROSERVICIOS

| DESCRIPCION                              | URL                               | PETICION | HEADER  | RESPUESTA
|------------------------------------------|-----------------------------------|----------| ------ | ------ |
| Lista Por curso las personas             | localhost:8002/listar-por-curso/1 | GET      | | JSON | 
| Crea un usuario y lo agrega al curso     | localhost:8002/crear-usuario/1    | POST     | Content-Type: application/json |
| Asignar un usuario ya existente al curso | localhost:8002/asignar-usuario/1  | PUT      | Content-Type: application/json |
| Eliminar un usuario de un curso          | localhost:8002/eliminar-usuario/1 | DELETE   |  Content-Type: application/json


- Ejemplos
  ![N|Solid](https://github.com/CharleBone/docker-services/blob/master/cursos/src/main/resources/static/images_ejemplo/put-asignar-usuario-curso.PNG)

  ![N|Solid](https://github.com/CharleBone/docker-services/blob/master/cursos/src/main/resources/static/images_ejemplo/post-crear-usuario-desde-curso.PNG)

  ![N|Solid](https://github.com/CharleBone/docker-services/blob/master/cursos/src/main/resources/static/images_ejemplo/delete-elimina-usuario-del-curso.PNG)
