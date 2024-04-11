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
        validacaoDeEmailECpf(usuario);   // <-- Dispara a validação
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) throws Exception {
        validacaoDeEmailECpf(usuario);   // <-- Dispara a validação 
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer idUsuario) {
        findById(idUsuario);
        usuarioRepository.deleteById(idUsuario);
    }

    private void validacaoDeEmailECpf(Usuario usuario) {   //verifica se o email e cpf não repetidos
        Optional<Usuario> validacaoEmail = usuarioRepository.findByEmail(usuario.getEmail());
        Optional<Usuario> validacaoNrCpf = usuarioRepository.findByNrCpf(usuario.getNrCpf());
    
        if (validacaoEmail.isPresent() && !validacaoEmail.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    
        if (validacaoNrCpf.isPresent() && !validacaoNrCpf.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new DataIntegratyViolationException("CPF já cadastrado no sistema");
        }
    }

    

}
