package com.amandasantos.orangeTalents.domain.repository;

import com.amandasantos.orangeTalents.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeContaining(String nome);
    Usuario findByEmail(String email);


}
