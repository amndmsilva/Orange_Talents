package com.amandasantos.orangeTalents.domain.service;

import com.amandasantos.orangeTalents.domain.exception.NegocioException;
import com.amandasantos.orangeTalents.domain.model.Endereco;
import com.amandasantos.orangeTalents.domain.model.Usuario;
import com.amandasantos.orangeTalents.domain.repository.EnderecoRepository;
import com.amandasantos.orangeTalents.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Endereco criar(Endereco endereco) {
        Usuario usuario = usuarioRepository.findById(endereco.getUsuario().getId())
                .orElseThrow(() -> new NegocioException("Usuário não encontrado"));

        endereco.setUsuario(usuario);

        return enderecoRepository.save(endereco);
    }

}
