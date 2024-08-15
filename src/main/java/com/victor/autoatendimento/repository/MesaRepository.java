package com.victor.autoatendimento.repository;

import com.victor.autoatendimento.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    @SuppressWarnings("null")
    List<Mesa> findAll();

    Mesa findByCode(String code);

}
