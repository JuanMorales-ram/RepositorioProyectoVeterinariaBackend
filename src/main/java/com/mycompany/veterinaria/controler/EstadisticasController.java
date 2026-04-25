/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import jakarta.servlet.annotation.WebServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import veterinaria.dao.MascotaDAO;
import veterinaria.dao.PropietarioDAO;
import veterinaria.dao.VeterinarioDAO;
import veterinaria.util.JPAUtil;

@WebServlet("/api/estadisticas")
public class EstadisticasController extends HttpServlet{
    
    private final MascotaDAO mascotaDAO = new MascotaDAO(JPAUtil.getEntityManager());
    private final PropietarioDAO propietarioDAO = new PropietarioDAO(JPAUtil.getEntityManager());
    private final VeterinarioDAO veterinarioDAO = new VeterinarioDAO(JPAUtil.getEntityManager());
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        long mascotasCount = mascotaDAO.count();
        long propietariosCount = propietarioDAO.count();
        long veterinariosCount = veterinarioDAO.count();
        
        Map<String, Long> estadisticas = new HashMap<>();
        estadisticas.put("mascotas", mascotasCount);
        estadisticas.put("Propietarios", propietariosCount);
        estadisticas.put("veterinarios", veterinariosCount);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        new ObjectMapper().writeValue(resp.getWriter(), estadisticas);
    }
    
}
