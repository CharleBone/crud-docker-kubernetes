package org.bone.springcloud.cursos.clients;

import org.bone.springcloud.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuarios", url = "localhost:8001")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    Usuario usuarioPorId(@PathVariable Long id);

    @PostMapping("/")
    Usuario crearUsuario(@RequestBody Usuario usuario);

    @GetMapping("/listar")
    List<Usuario> usuariosDeUnCurso(@RequestParam List<Long> ids);
}
