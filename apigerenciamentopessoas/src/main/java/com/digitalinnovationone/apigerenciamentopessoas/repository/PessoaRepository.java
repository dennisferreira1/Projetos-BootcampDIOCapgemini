package com.digitalinnovationone.apigerenciamentopessoas.repository;

import com.digitalinnovationone.apigerenciamentopessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

