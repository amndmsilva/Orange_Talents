package com.amandasantos.orangeTalents.api.controller;

import com.amandasantos.orangeTalents.domain.model.Endereco;
import com.amandasantos.orangeTalents.domain.repository.EnderecoRepository;
import com.amandasantos.orangeTalents.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco cadastar(@RequestBody Endereco endereco) {
        return enderecoService.criar(endereco);
    }

    @GetMapping
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscar(@PathVariable Long id) {
       Optional<Endereco> Endereco = enderecoRepository.findById(id);

       if (Endereco.isPresent()) {
           return ResponseEntity.ok(Endereco.get());
       }

       return ResponseEntity.notFound().build();
    }
}
