/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import com.mycompany.veterinaria.DTO.UsuarioDTO;
import jakarta.persistence.EntityManager;
import java.util.Set;
import java.util.stream.Collectors;
import veterinaria.dao.UsuarioDAO;
import veterinaria.mode.entity.Usuario;
import veterinaria.util.JPAUtil;
import veterinaria.util.PasswordUtil;




public class AuthService {
    
    public UsuarioDTO login(String username, String passwordPlano){
        
        EntityManager em = JPAUtil.getEntityManager();
        try{
            UsuarioDAO dao = new UsuarioDAO(em);
            Usuario usuario = dao.buscarPorUsername(username);
            
            if (usuario == null) return null;
            if (!usuario.getEstado()) return null;
            
            if (!PasswordUtil.verificar(passwordPlano, usuario.getPasswordHash())){
                return null;
            }
            
            Set<String> roles = usuario.getRoles()
                    .stream()
                    .map(ur -> ur.getRol().getNombre())
                    .collect(Collectors.toSet());
            
            return new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getUsername(),
                    roles
            );
            
            
        }finally {
            em.close();
        }
    }
    
}
