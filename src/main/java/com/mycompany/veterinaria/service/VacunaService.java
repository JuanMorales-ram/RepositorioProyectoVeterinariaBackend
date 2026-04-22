/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.VacunaDAO;
import veterinaria.mode.entity.Vacuna;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class VacunaService {
    
    public void crear (Vacuna vacuna){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunaDAO(em).create(vacuna);
        }finally{
            em.close();
        }
    }
    
     public Vacuna buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VacunaDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
     
     public List<Vacuna> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new VacunaDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
     
     public void actualizar (Vacuna vacuna){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunaDAO(em).actualizar(vacuna);
        }finally{
            em.close();
        }
    }
     
     public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new VacunaDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
}
