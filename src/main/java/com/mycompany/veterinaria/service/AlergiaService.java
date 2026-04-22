/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.AlergiaDAO;
import veterinaria.mode.entity.Alergia;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class AlergiaService {
    
    public void crear (Alergia alergia){
        EntityManager em = JPAUtil.getEntityManager();
        try{
             new AlergiaDAO(em).create(alergia);
        }finally{
            em.close();
        }
    }
    
    public Alergia buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new AlergiaDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
    
    public List<Alergia> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new AlergiaDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
    public void actualizar (Alergia alergia){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new AlergiaDAO(em).actualizar(alergia);
        }finally{
            em.close();
        }
    }
    
    public void eliminar ( Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new AlergiaDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
}
