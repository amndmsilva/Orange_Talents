package com.amandasantos.orangeTalents.api.controller;

import com.amandasantos.orangeTalents.domain.model.CadastroEndereco;
import com.amandasantos.orangeTalents.domain.repository.CadastroEnderecoRepository;
import com.amandasantos.orangeTalents.domain.service.CadastroEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastro-endereco")
public class CadastroEnderecoController {

    @Autowired
    private CadastroEnderecoService cadastroEnderecoService;

    @Autowired
    private CadastroEnderecoRepository cadastroEnderecoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroEndereco cadastar(@RequestBody CadastroEndereco cadastroEndereco) {
        return cadastroEnderecoService.criar(cadastroEndereco);
    }

    @GetMapping
    public List<CadastroEndereco> listar() {
        return cadastroEnderecoRepository.findAll();
    }

    @GetMapping("/{cadastroEnderecoId}")
    public ResponseEntity<CadastroEndereco> buscar(@PathVariable Long cadastroEnderecoId) {
       Optional<CadastroEndereco> cadastroEndereco = cadastroEnderecoRepository.findById(cadastroEnderecoId);

       if (cadastroEndereco.isPresent()) {
           return ResponseEntity.ok(cadastroEndereco.get());
       }

       return ResponseEntity.notFound().build();
    }
}