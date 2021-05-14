package com.amandasantos.orangeTalents.domain.service;

import com.amandasantos.orangeTalents.domain.model.Cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    Cep buscaEnderecoPorCep(@PathVariable("cep") String cep);

}