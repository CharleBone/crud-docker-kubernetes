package org.bone.springcloud.cursos.service;

import org.bone.springcloud.cursos.clients.UsuarioClientRest;
import org.bone.springcloud.cursos.models.Usuario;
import org.bone.springcloud.cursos.models.entity.Curso;
import org.bone.springcloud.cursos.models.entity.CursoUsuario;
import org.bone.springcloud.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioClientRest usuarioClientRest;

    @Override
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso editarCurso(Long id, Curso curso) {
        Curso cursoOriginal = cursoRepository.findById(id).orElse(null);
        if (cursoOriginal != null) {
            cursoOriginal.setNombre(curso.getNombre());
        }
        return cursoOriginal;
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarCursoUsuarioPorId(Long id) {
        cursoRepository.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long idCurso) {
        Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
        if (optionalCurso.isPresent()){
            Usuario usuarioMSVC = usuarioClientRest.usuarioPorId(usuario.getId());

            addOrRemoveUsuariosDeCurso(optionalCurso, usuarioMSVC, true);
            return Optional.of(usuarioMSVC);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> crearUsuario(Usuario usuario, Long idCurso) {
        Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
        if (optionalCurso.isPresent()){
            Usuario usuarioMSVC = usuarioClientRest.crearUsuario(usuario);

            addOrRemoveUsuariosDeCurso(optionalCurso, usuarioMSVC, true);
            return Optional.of(usuarioMSVC);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> eliminarUsuario(Usuario usuario, Long idCurso) {
        Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
        if (optionalCurso.isPresent()){
            Usuario usuarioMSVC = usuarioClientRest.usuarioPorId(usuario.getId());
            addOrRemoveUsuariosDeCurso(optionalCurso, usuarioMSVC, false);
            return Optional.of(usuarioMSVC);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Curso> obtenerUsuariosPorCurso(Long idCurso) {
        Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
        List<Long> Idusuarios = new ArrayList<>();

        if (optionalCurso.isPresent()){
            Curso curso = optionalCurso.get();
            if (!curso.getCursoUsuarios().isEmpty()) {
                optionalCurso.get().getCursoUsuarios().forEach(cursoUsuario -> Idusuarios.add(cursoUsuario.getUsuarioId()));
                List<Usuario> usuarios = usuarioClientRest.usuariosDeUnCurso(Idusuarios);
                curso.setUsuarios(usuarios);
            }
            return Optional.of(curso);
        }
        return Optional.empty();
    }

    private void addOrRemoveUsuariosDeCurso(Optional<Curso> optionalCurso, Usuario usuarioMSVC, boolean seAgrega) {
        Curso curso = optionalCurso.get();

        CursoUsuario cursoUsuario = new CursoUsuario();
        cursoUsuario.setUsuarioId(usuarioMSVC.getId());

        if (seAgrega) {
            curso.addCursoUsuario(cursoUsuario);
        } else {
            curso.removeCursoUsuario(cursoUsuario);
        }
        cursoRepository.save(curso);
    }
}
