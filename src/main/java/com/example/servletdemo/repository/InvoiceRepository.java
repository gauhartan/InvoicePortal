package com.example.servletdemo.repository;

import com.example.servletdemo.model.InvoiceEntry;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Integration mot databas
public class InvoiceRepository {
    private final Connection conn;

    public InvoiceRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/journaldb", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<InvoiceEntry> getAll() {
        List<InvoiceEntry> invoices = new ArrayList<>();
        String sql = "SELECT id, titel, datum, beskrivning, kategori, pris FROM invoice";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                InvoiceEntry invoice = new InvoiceEntry();

                invoice.setId(rs.getLong("id"));
                invoice.setTitel(rs.getString("titel"));
                invoice.setDatum(rs.getDate("datum"));
                invoice.setBeskrivning(rs.getString("beskrivning"));
                invoice.setKategori(rs.getString("kategori"));
                invoice.setPris(rs.getBigDecimal("pris"));

                invoices.add(invoice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return invoices;
    }

    public List<InvoiceEntry> getAll(String agare) {
        List<InvoiceEntry> invoices = new ArrayList<>();
        String sql = "SELECT id, titel, datum, beskrivning, kategori, pris FROM invoice WHERE agare=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, agare);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                InvoiceEntry invoice = new InvoiceEntry();

                invoice.setId(rs.getLong("id"));
                invoice.setTitel(rs.getString("titel"));
                invoice.setDatum(rs.getDate("datum"));
                invoice.setBeskrivning(rs.getString("beskrivning"));
                invoice.setKategori(rs.getString("kategori"));
                invoice.setPris(rs.getBigDecimal("pris"));

                invoices.add(invoice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return invoices;
    }

    public void create(String titel, String beskrivning, String kategori, BigDecimal pris, String agare) {
        String sql =
                "INSERT INTO invoice (titel, beskrivning, kategori, pris, agare)" +
                        "VALUES (?, ?, ?, ?, ?)"; // parametriserad fråga (query)

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, titel);
            pstmt.setString(2, beskrivning);
            pstmt.setString(3, kategori);
            pstmt.setBigDecimal(4, pris);
            pstmt.setString(5, agare);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean delete(Long id, String agare) {
        String sql = "DELETE FROM invoice WHERE id=? AND agare=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.setString(2, agare);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

//    public JournalEntry update(JournalEntry entry) {
//        return null;
//    }
}
