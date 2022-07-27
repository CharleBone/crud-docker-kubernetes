package org.bone.springcloud.usuarios.service;

import org.bone.springcloud.usuarios.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario buscarPorId(Long id);

    Usuario guardarUsuario(Usuario usuario);

    Usuario editarUsuario(Long id, Usuario usuario);

    void eliminarUsuario(Long id);

    Usuario obtenerPorEmail(String email);

    boolean existePorEmail(String email);

    List<Usuario> listarPorIds(Iterable<Long> ids);

}