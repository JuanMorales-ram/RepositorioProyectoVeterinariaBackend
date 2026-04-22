/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.veterinaria.service.VeterinarioService;
import java.util.List;
import veterinaria.mode.entity.Veterinario;

@WebServlet("/api/veterinarios")
public class VeterinarioController extends HttpServlet {
    
    private final VeterinarioService service = new VeterinarioService();
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws  IOException{
        resp.setContentType("application/json");
        
        String id = req.getParameter("id");
        if ( id != null){
            Veterinario veterinario = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), veterinario);
        }else{
            List<Veterinario> veterinarios = service.listarTodos();
            mapper.writeValue(resp.getWriter(), veterinarios);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Veterinario veterinario = mapper.readValue(req.getInputStream(), Veterinario.class);
        service.crear(veterinario);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Veterinario mascota = mapper.readValue(req.getInputStream(), Veterinario.class);
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
