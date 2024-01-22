package com.example.servletdemo.service;

import com.example.servletdemo.model.InvoiceEntry;
import com.example.servletdemo.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.util.List;

// Inne i service hanteras vanligen undantag och fel i den in eller ut data som skickas eller tas emot
public class InvoiceService {

    private final InvoiceRepository invoiceRepository = new InvoiceRepository();

    public List<InvoiceEntry> getAll(String agare) {
        return invoiceRepository.getAll(agare);
    }

    public void create(String titel, String beskrivning, String kategori, BigDecimal pris, String agare) {
        invoiceRepository.create(titel, beskrivning, kategori, pris, agare);
    }

    public boolean delete(Long id, String agare) {
        return invoiceRepository.delete(id, agare);
    }

}
