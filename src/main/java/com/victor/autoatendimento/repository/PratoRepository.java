package com.victor.autoatendimento.repository;

import com.victor.autoatendimento.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

    @NonNull
	List<Prato> findAll();

    @NonNull
	Optional<Prato> findById(@NonNull Long id);

    Prato findByNomePrato(String nomePrato);

    Prato deleteByNomePrato(String nomePrato);

    Prato deleteById(long id);

}
