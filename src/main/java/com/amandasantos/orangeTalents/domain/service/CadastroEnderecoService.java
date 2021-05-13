package com.amandasantos.orangeTalents.domain.service;

import com.amandasantos.orangeTalents.domain.exception.NegocioException;
import com.amandasantos.orangeTalents.domain.model.CadastroEndereco;
import com.amandasantos.orangeTalents.domain.model.Usuario;
import com.amandasantos.orangeTalents.domain.repository.CadastroEnderecoRepository;
import com.amandasantos.orangeTalents.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEnderecoService {

    @Autowired
    private CadastroEnderecoRepository cadastroEnderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CadastroEndereco criar(CadastroEndereco cadastroEndereco) {
        Usuario usuario = usuarioRepository.findById(cadastroEndereco.getUsuario().getId())
                .orElseThrow(() -> new NegocioException("Usuário não encontrado"));

        cadastroEndereco.setUsuario(usuario);

        return cadastroEnderecoRepository.save(cadastroEndereco);
    }
}
