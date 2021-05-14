package com.amandasantos.orangeTalents.domain.service;

import com.amandasantos.orangeTalents.domain.exception.NegocioException;
import com.amandasantos.orangeTalents.domain.model.Usuario;
import com.amandasantos.orangeTalents.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {

        String cpf = usuario.getCpf();
        cpf=cpf.replace(".", "").replace("-", "");
        Integer quantidadeUsuarios = usuarioRepository.countByEmailOrCpf(usuario.getEmail(), cpf);

        if (quantidadeUsuarios > 0){
            throw new NegocioException("Já existe um usuario cadastrado com este e-mail ou CPF");
        }

        return usuarioRepository.save(usuario);
    }
}
