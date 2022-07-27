package org.bone.springcloud.usuarios.service;

import org.bone.springcloud.usuarios.client.CursoClienteRest;
import org.bone.springcloud.usuarios.entity.Usuario;
import org.bone.springcloud.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @Autowired
    private CursoClienteRest cursoClienteRest;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioOriginal = usuariosRepository.findById(id).orElse(null);
        if (usuarioOriginal != null) {
            usuarioOriginal.setNombre(usuario.getNombre());
            usuarioOriginal.setEmail(usuario.getEmail());
            usuarioOriginal.setPassword(usuario.getPassword());
        }
        return usuarioOriginal;
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
        cursoClienteRest.eliminarCursoUsuarioPorId(id);
    }

    @Override
    public Usuario obtenerPorEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Override
    public boolean existePorEmail(String email) {
        return usuariosRepository.existsByEmail(email);
    }

    @Override
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return usuariosRepository.findAllById(ids);
    }
}
