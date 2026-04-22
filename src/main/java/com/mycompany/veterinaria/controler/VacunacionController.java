/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import com.mycompany.veterinaria.service.VacunacionService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import veterinaria.mode.entity.Vacunacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author juand
 */
@WebServlet("/api/vacunaciones")
public class VacunacionController extends HttpServlet {

    private final VacunacionService service = new VacunacionService();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        String id = req.getParameter("id");
        if (id != null) {
            Vacunacion vacunacion = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), vacunacion);
        } else {
            List<Vacunacion> vacunaciones = service.listarTodos();
            mapper.writeValue(resp.getWriter(), vacunaciones);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Vacunacion vacunacion = mapper.readValue(req.getInputStream(), Vacunacion.class);
        service.crear(vacunacion);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Vacunacion vacunacion = mapper.readValue(req.getInputStream(), Vacunacion.class);
        service.actualizar(vacunacion);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        service.eliminar(Long.parseLong(id));
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
