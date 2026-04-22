/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.VacunacionDAO;
import veterinaria.mode.entity.Vacunacion;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class VacunacionService {
    
    public void crear (Vacunacion vacunacion){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunacionDAO(em).create(vacunacion);
        }finally{
            em.close();
        }
    }
     
     public Vacunacion buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VacunacionDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
     
     public List<Vacunacion> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VacunacionDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
     
     public void actualizar (Vacunacion vacunacion){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunacionDAO(em).actualizar(vacunacion);
        }finally{
            em.close();
        }
    }
     
     public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunacionDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
    
}
