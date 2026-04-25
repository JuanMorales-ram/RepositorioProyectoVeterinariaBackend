/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import com.mycompany.veterinaria.service.MascotaService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import veterinaria.mode.entity.Mascota;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
/**
 *
 * @author juand
 */
@WebServlet("/api/mascotas")
public class MascotaController extends HttpServlet{
    
    private final MascotaService service = new MascotaService();
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws  IOException{
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        String id = req.getParameter("id");
        if ( id != null){
            Mascota mascota = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), mascota);
        }else{
            List<Mascota> mascotas = service.ListarTodos();
            mapper.writeValue(resp.getWriter(), mascotas);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Mascota mascota = mapper.readValue(req.getInputStream(), Mascota.class);
        service.crear(mascota);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Mascota mascota = mapper.readValue(req.getInputStream(), Mascota.class);
        service.actualizar(mascota);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        service.eliminar(Long.parseLong(id));
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    
    
    
}
