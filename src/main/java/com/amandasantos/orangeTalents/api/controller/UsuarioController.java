package com.amandasantos.orangeTalents.api.controller;

import com.amandasantos.orangeTalents.domain.model.Usuario;
import com.amandasantos.orangeTalents.domain.repository.UsuarioRepository;
import com.amandasantos.orangeTalents.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

}
