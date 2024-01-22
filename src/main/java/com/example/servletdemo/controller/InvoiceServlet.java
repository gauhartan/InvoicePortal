package com.example.servletdemo.controller;

import com.example.servletdemo.model.InvoiceEntry;
import com.example.servletdemo.service.InvoiceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/invoice/*")
public class InvoiceServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

        if (username == null) {
            resp.sendRedirect("/login.jsp");
        } else {

            List<InvoiceEntry> invoices = invoiceService.getAll(username);

            PrintWriter out = resp.getWriter();
            out.println("<table><tr><td>Titel</td><td>Datum</td><td>Beskrivning</td><td>kategori</td><td>Pris</td><td>Delete</td></tr>");
            for (InvoiceEntry invoice : invoices) {
                out.println("<tr><td>" + invoice.getTitel() + "</td><td>" + invoice.getDatum() + "</td><td>" + invoice.getBeskrivning() + "</td><td>" + invoice.getKategori() + "</td><td>" + invoice.getPris() + "</td><td><form action=\"/invoice/delete\" method=\"POST\"><input type=\"hidden\" name=\"id\" value=\"" + invoice.getId() + "\"/><button>Delete invoice</button></form></td></tr>");
            }
            out.println("</table>");
            req.getRequestDispatcher("/index.jsp").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()) {
            case "/new":
                createInvoice(req, resp);
                break;
            case "/delete":
                deleteInvoice(req, resp);
                break;
        }
    }

    private void deleteInvoice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

        Long id = Long.parseLong(req.getParameter("id"));

        if (username == null) {
            resp.sendRedirect("/login.jsp");
        } else {
            invoiceService.delete(id, username);
            resp.sendRedirect(req.getServletPath());
        }
    }

    private void createInvoice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

        if (username == null) {
            resp.sendRedirect("/login.jsp");
        } else {
            String titel = req.getParameter("titel");
            String beskrivning = req.getParameter("beskrivning");
            String kategori = req.getParameter("kategori");
            String pris = req.getParameter("pris");

            invoiceService.create(titel, beskrivning, kategori, new BigDecimal(pris), username);

            resp.sendRedirect(req.getServletPath());
        }
    }
}
