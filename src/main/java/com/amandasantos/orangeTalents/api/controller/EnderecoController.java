package com.amandasantos.orangeTalents.api.controller;

import com.amandasantos.orangeTalents.domain.exception.NegocioException;
import com.amandasantos.orangeTalents.domain.model.Cep;
import com.amandasantos.orangeTalents.domain.model.Endereco;
import com.amandasantos.orangeTalents.domain.repository.EnderecoRepository;
import com.amandasantos.orangeTalents.domain.service.CepService;
import com.amandasantos.orangeTalents.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CepService cepService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco cadastar(@RequestBody Endereco endereco) {
        return enderecoService.criar(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Endereco>> buscar(@PathVariable Long id) {
       List<Endereco> endereco = enderecoRepository.findByUsuarioId(id);
        if (endereco != null && !endereco.isEmpty() ) {
            return ResponseEntity.ok(endereco);
        }
        throw new NegocioException("Usuário não encontrado");
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable String cep) {
        Cep endereco = cepService.buscaEnderecoPorCep(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }

}
