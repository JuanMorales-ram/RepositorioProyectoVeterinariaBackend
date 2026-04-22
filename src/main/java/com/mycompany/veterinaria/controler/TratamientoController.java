/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import com.mycompany.veterinaria.service.TratamientoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import veterinaria.mode.entity.Tratamiento;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author juand
 */
@WebServlet("/api/tratamientos")
public class TratamientoController extends HttpServlet {

    private final TratamientoService service = new TratamientoService();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        String id = req.getParameter("id");
        if (id != null) {
            Tratamiento tratamiento = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), tratamiento);
        } else {
            List<Tratamiento> tratamientos = service.listarTodos();
            mapper.writeValue(resp.getWriter(), tratamientos);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Tratamiento tratamiento = mapper.readValue(req.getInputStream(), Tratamiento.class);
        service.crear(tratamiento);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Tratamiento tratamiento = mapper.readValue(req.getInputStream(), Tratamiento.class);
        service.actualizar(tratamiento);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        service.eliminar(Long.parseLong(id));
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
