package com.example.generationlego.dao;

import com.example.generationlego.model.Playset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaysetDao extends CrudRepository<Playset, Integer>{
    Page<Playset> findAll(Pageable pageable);

    List<Playset> findByBrandNome(String nome);

    List<Playset> findByEta(String eta);

    List<Playset> findByBrandNomeAndEta(String nome, String eta);
}
