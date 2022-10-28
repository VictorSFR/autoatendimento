package com.victor.mvc.autoatendimento.repository;

import com.victor.mvc.autoatendimento.model.Mesa;
import com.victor.mvc.autoatendimento.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findAll();
    Mesa findByCode(String code);

}
