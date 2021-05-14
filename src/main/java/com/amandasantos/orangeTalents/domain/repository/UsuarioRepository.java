package com.amandasantos.orangeTalents.domain.repository;

import com.amandasantos.orangeTalents.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Integer countByEmailOrCpf(String email, String cpf);
}
