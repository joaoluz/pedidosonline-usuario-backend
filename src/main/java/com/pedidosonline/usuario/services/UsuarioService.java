package com.pedidosonline.usuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.repositories.UsuarioRepository;
import com.pedidosonline.usuario.services.exceptions.DataIntegratyViolationException;
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
        return obj.map(x -> new UsuarioDTO(x)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Usuario create(Usuario usuario) {
        findByEmail(usuario);
        findByNrCpf(usuario);
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer idUsuario, Usuario usuario) throws Exception {
        findById(idUsuario);
        usuario.setIdUsuario(idUsuario);
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer idUsuario) {
        findById(idUsuario);
        usuarioRepository.deleteById(idUsuario);
    }

    //erro se o e-mail já for cadastrado
    private void findByEmail(Usuario obj) {
        Optional<Usuario> usr = usuarioRepository.findByEmail(obj.getEmail());
        if (usr.isPresent()) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }

    //erro se o CPF já for cadastrado
    private void findByNrCpf(Usuario obj) {
        Optional<Usuario> usr = usuarioRepository.findByNrCpf(obj.getNrCpf());
        if (usr.isPresent()) {
            throw new DataIntegratyViolationException("CPF já cadastrado no sistema");
        }
    }

    

}
