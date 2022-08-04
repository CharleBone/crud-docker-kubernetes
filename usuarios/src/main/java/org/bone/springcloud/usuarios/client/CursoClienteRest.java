package org.bone.springcloud.usuarios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cursos", url = "${cursos.url}")
public interface CursoClienteRest {

    @DeleteMapping("/eliminar-curso-usuario/{idUsuario}")
    void eliminarCursoUsuarioPorId(@PathVariable Long idUsuario);
}
