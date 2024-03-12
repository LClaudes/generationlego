package com.example.generationlego.service;

import com.example.generationlego.dao.UtenteDao;
import com.example.generationlego.model.Utenti;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {
    @Autowired
    private UtenteDao utenteDao;

    @Override
    public boolean controlloLogin(String username, String password, HttpSession session)
    {
        Utenti utente = utenteDao.findByUsernameAndPassword(username, password);
        if(utente != null)
        {
            session.setAttribute("utente", utente);
            return true;
        }
        return false;
    }

    @Override
    public void registraUtente(Utenti utente)
    {
        utenteDao.save(utente);
    }

    @Override
    public boolean controlloUsername(String username)
    {
        if(utenteDao.findByUsername(username) == null)
            return true;
        return false;
    }
}
