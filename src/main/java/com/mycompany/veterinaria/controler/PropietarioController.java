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
import com.mycompany.veterinaria.service.PropietarioService;
import java.util.List;
import veterinaria.mode.entity.Propietario;


@WebServlet("/api/propietarios")
public class PropietarioController extends HttpServlet {
    
    private final PropietarioService service = new PropietarioService();
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        
        String id = req.getParameter("id");
        if( id != null){
            Propietario propietario = service.buscarPorId(Long.parseLong(id));
            mapper.writeValue(resp.getWriter(), propietario);
        }else{
            List<Propietario> propietarios = service.ListarTodos();
            mapper.writeValue(resp.getWriter(), propietarios);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Propietario propietario = mapper.readValue(req.getInputStream(), Propietario.class);
        service.crear(propietario);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        service.eliminar(Long.parseLong(id));
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    
}
