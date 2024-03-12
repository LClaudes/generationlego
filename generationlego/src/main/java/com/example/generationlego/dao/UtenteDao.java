package com.example.generationlego.dao;

import com.example.generationlego.model.Utenti;
import org.springframework.data.repository.CrudRepository;

public interface UtenteDao extends CrudRepository<Utenti, Integer> {
    Utenti findByUsernameAndPassword(String username, String password);

    Utenti findByUsername(String username);
}
