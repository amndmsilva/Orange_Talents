package com.amandasantos.orangeTalents.controller;

import com.amandasantos.orangeTalents.model.Usuario;
import com.amandasantos.orangeTalents.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<Usuario> listar() {
        return manager.createQuery("from Usuario", Usuario.class).getResultList();
    }
}
