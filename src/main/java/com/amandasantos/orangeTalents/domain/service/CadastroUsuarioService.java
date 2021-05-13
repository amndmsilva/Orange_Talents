package com.amandasantos.orangeTalents.domain.service;

import com.amandasantos.orangeTalents.domain.exception.NegocioException;
import com.amandasantos.orangeTalents.domain.model.Usuario;
import com.amandasantos.orangeTalents.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroUsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findByEmailOrCpf(usuario.getEmail(), usuario.getCpf());

        if (usuarioExistente != null && !usuarioExistente.equals(usuario)){
            throw new NegocioException("Já existe um usuario cadastrado com este e-mail ou CPF");
        }

        return usuarioRepository.save(usuario);
    }

    public void excluir(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
