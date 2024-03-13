package com.example.generationlego.dao;

import com.example.generationlego.model.Playset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PlaysetDao extends CrudRepository<Playset, Integer>{
    Page<Playset> findAll(Pageable pageable);
}
