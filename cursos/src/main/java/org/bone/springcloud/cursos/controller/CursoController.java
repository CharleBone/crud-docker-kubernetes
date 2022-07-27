package org.bone.springcloud.cursos.controller;

import org.bone.springcloud.cursos.models.Usuario;
import org.bone.springcloud.cursos.models.entity.Curso;
import org.bone.springcloud.cursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Curso> listarCursos(){
        return cursoService.obtenerCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCurso(@PathVariable Long id){
        Optional<Curso> curso = cursoService.obtenerUsuariosPorCurso(id);
        return (curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarCurso(@Valid @RequestBody Curso curso, BindingResult result){
        if (result.hasErrors()) {
            return validar(result);
        }
        return ResponseEntity.ok(cursoService.guardarCurso(curso));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> editarCurso(@Valid @RequestBody Curso cursoActualizado, BindingResult result , @PathVariable Long id){
        if (result.hasErrors()) {
            return validar(result);
        }
        Curso curso = cursoService.editarCurso(id, cursoActualizado);
        return (curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id){
        Curso curso = cursoService.obtenerCursoPorId(id);
        if (curso != null) {
            cursoService.eliminarCurso(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/asignar-usuario/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> asignarUsuarioAlCurso(@RequestBody Usuario usuario, @PathVariable Long idCurso){
        Optional<Usuario> usuarioRecuperado = cursoService.asignarUsuario(usuario, idCurso);
        if (usuarioRecuperado.isPresent()){
            return ResponseEntity.ok(usuarioRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear-usuario/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> crearUsuarioAlCurso(@RequestBody Usuario usuario, @PathVariable Long idCurso){
        Optional<Usuario> usuarioRecuperado = cursoService.crearUsuario(usuario, idCurso);
        if (usuarioRecuperado.isPresent()){
            return ResponseEntity.ok(usuarioRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar-usuario/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> eliminarUsuarioAlCurso(@RequestBody Usuario usuario, @PathVariable Long idCurso){
        Optional<Usuario> usuarioRecuperado = cursoService.eliminarUsuario(usuario, idCurso);
        if (usuarioRecuperado.isPresent()){
            return ResponseEntity.ok(usuarioRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listar-por-curso/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarUsuariosPorCurso(@PathVariable Long idCurso){
        Optional<Curso> usuarioRecuperado = cursoService.obtenerUsuariosPorCurso(idCurso);
        if (!usuarioRecuperado.isEmpty()){
            return ResponseEntity.ok(usuarioRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar-curso-usuario/{idUsuario}")
    public ResponseEntity<?> eliminarCursoUsuario(@PathVariable Long idUsuario){
        cursoService.eliminarCursoUsuarioPorId(idUsuario);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> {
            errores.put(fieldError.getField(), "El campo " +
                    fieldError.getField() + " " + fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
