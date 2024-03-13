package com.example.generationlego.service;

import com.example.generationlego.model.Utenti;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;

public interface UtenteService {
    String controlloLogin(String username, String password, HttpSession session);
    void registraUtente(Utenti utente);
    boolean controlloUsername(String username);
    boolean controlloDifferenzaData(LocalDate data,  int anni);
}
