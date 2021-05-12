package com.amandasantos.orangeTalents.domain.repository;

import com.amandasantos.orangeTalents.domain.model.CadastroEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroEnderecoRepository extends JpaRepository<CadastroEndereco, Long> {

}