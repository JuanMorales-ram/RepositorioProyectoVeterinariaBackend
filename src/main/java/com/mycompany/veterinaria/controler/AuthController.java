/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.veterinaria.DTO.LoginRequestDTO;
import com.mycompany.veterinaria.DTO.UsuarioDTO;
import com.mycompany.veterinaria.service.AuthService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/api/login")
public class AuthController extends HttpServlet {
    
    private final AuthService authService = new AuthService();
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        LoginRequestDTO login = mapper.readValue(req.getInputStream(), LoginRequestDTO.class);
        
        UsuarioDTO usuarioDTO = authService.login(login.getUsername(), login.getPassword());
        
        if (usuarioDTO == null){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Credenciales inválidas");
            return;
        }
        
        HttpSession session = req.getSession(true);
        session.setAttribute("usuario", usuarioDTO);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        mapper.writeValue(resp.getWriter(), usuarioDTO);
    }
    
}
