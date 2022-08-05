# docker-services
# API

| DESCRIPCION  | URL               | PETICION | HEADER  | RESPUESTA
| ------ |-------------------|----------| ------ | ------ |
| Mostrar una lista de Personas | localhost:8001    | GET      | | JSON | 
| Agregar Persona | localhost:8001    | POST     | Content-Type: application/json |
| Buscar Persona | localhost:8001/1  | GET      |   | JSON
| Actualizar Persona | localhost:8001/1  | PUT      | Content-Type: application/json |
| Eliminar Persona | localhost:8001/1  |  DELETE  | Content-Type: application/json
