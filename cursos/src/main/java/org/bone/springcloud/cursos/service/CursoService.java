package org.bone.springcloud.cursos.service;

import org.bone.springcloud.cursos.models.Usuario;
import org.bone.springcloud.cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> obtenerCursos();
    Curso obtenerCursoPorId(Long id);
    Curso guardarCurso(Curso curso);
    Curso editarCurso(Long id, Curso curso);
    void eliminarCurso(Long id);
    void eliminarCursoUsuarioPorId(Long id);
    Optional<Usuario> asignarUsuario(Usuario usuario, Long idCurso);
    Optional<Usuario> crearUsuario(Usuario usuario, Long idCurso);
    Optional<Usuario> eliminarUsuario(Usuario usuario, Long id);
    Optional<Curso>  obtenerUsuariosPorCurso(Long idCurso);
}
