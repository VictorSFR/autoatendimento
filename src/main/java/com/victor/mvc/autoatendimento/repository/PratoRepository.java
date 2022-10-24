package com.victor.mvc.autoatendimento.repository;

import com.victor.mvc.autoatendimento.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

     List<Prato> findAll();

     Prato findByNomePrato(String nomePrato);
     Prato deleteByNomePrato(String nomePrato);
     Prato deleteById(long id);

}
