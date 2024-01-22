package com.example.servletdemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceEntry {
    private Long id;
    private String titel;
    private Date datum;
    private String beskrivning;
    private String kategori;
    private BigDecimal pris;
    private String agare;

    public String getAgare() {
        return agare;
    }

    public void setAgare(String agare) {
        this.agare = agare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public BigDecimal getPris() {
        return pris;
    }

    public void setPris(BigDecimal pris) {
        this.pris = pris;
    }
}
