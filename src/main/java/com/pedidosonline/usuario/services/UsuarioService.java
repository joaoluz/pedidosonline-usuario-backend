package com.pedidosonline.usuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.repositories.UsuarioRepository;
import com.pedidosonline.usuario.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        List<Usuario> lista = usuarioRepository.findAll();
        return lista.stream().map(x -> new UsuarioDTO(x)).toList();
    }

    public UsuarioDTO findById(Integer idUsuario) {
        Optional<Usuario> obj = usuarioRepository.findById(idUsuario);
        return obj.map(x -> new UsuarioDTO(x)).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado " + idUsuario));
    }

    public Usuario create(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer idUsuario, Usuario usuario) throws Exception {
        findById(idUsuario);  //Talvez seja inútil
        usuario.setIdUsuario(idUsuario);
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

}
