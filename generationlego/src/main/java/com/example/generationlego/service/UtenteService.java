package com.example.generationlego.service;

import com.example.generationlego.model.Utenti;
import jakarta.servlet.http.HttpSession;

public interface UtenteService {
    boolean controlloLogin(String username, String password, HttpSession session);
    void registraUtente(Utenti utente);
    boolean controlloUsername(String username);
}
