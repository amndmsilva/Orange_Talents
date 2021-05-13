package com.amandasantos.orangeTalents.domain.repository;

import com.amandasantos.orangeTalents.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
