/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.HistorialClinicoDAO;
import veterinaria.mode.entity.HistorialClinico;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class HistorialClinicoService {
    
     public void crear (HistorialClinico historialclinico){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new HistorialClinicoDAO(em).create(historialclinico);
        }finally{
            em.close();
        }
    }
     
     public HistorialClinico buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new HistorialClinicoDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
     
     public List<HistorialClinico> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new HistorialClinicoDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
     
     public void actualizar (HistorialClinico historialclinico){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new HistorialClinicoDAO(em).actualizar(historialclinico);
        }finally{
            em.close();
        }
    }
     
     public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new HistorialClinicoDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
}
