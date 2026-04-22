/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.VeterinarioDAO;
import veterinaria.mode.entity.Veterinario;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class VeterinarioService {
    
    public void crear (Veterinario veterinario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VeterinarioDAO(em).create(veterinario);
        }finally{
            em.close();
        }
    }
    
    public Veterinario buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VeterinarioDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
    
    public List<Veterinario> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VeterinarioDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
    public void actualizar (Veterinario veterinario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VeterinarioDAO(em).actualizar(veterinario);
        }finally{
            em.close();
        }
    }
    
    public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VeterinarioDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
    
}
