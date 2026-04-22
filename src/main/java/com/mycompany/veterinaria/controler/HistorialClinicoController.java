/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import com.mycompany.veterinaria.service.HistorialClinicoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import veterinaria.mode.entity.HistorialClinico;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author juand
 */
@WebServlet("/api/historialclinico")
public class HistorialClinicoController extends HttpServlet {

    private final HistorialClinicoService service = new HistorialClinicoService();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        String id = req.getParameter("id");
        if (id != null) {
            HistorialClinico historial = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), historial);
        } else {
            List<HistorialClinico> historiales = service.listarTodos();
            mapper.writeValue(resp.getWriter(), historiales);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HistorialClinico historial = mapper.readValue(req.getInputStream(), HistorialClinico.class);
        service.crear(historial);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HistorialClinico historial = mapper.readValue(req.getInputStream(), HistorialClinico.class);
        service.actualizar(historial);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        service.eliminar(Long.parseLong(id));
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
