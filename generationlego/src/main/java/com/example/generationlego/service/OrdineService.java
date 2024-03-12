package com.example.generationlego.service;

import jakarta.servlet.http.HttpSession;

public interface OrdineService {
    void inviaOrdine(HttpSession session);
}
