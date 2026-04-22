/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.TratamientoDAO;
import veterinaria.mode.entity.Tratamiento;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class TratamientoService {
    
    public void crear (Tratamiento tratamiento){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new TratamientoDAO(em).create(tratamiento);
        }finally{
            em.close();
        }
    }
    
    public Tratamiento buscarPorId (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new TratamientoDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
    
    public List<Tratamiento> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new TratamientoDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
    public void actualizar (Tratamiento tratamiento){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new TratamientoDAO(em).actualizar(tratamiento);
        }finally{
            em.close();
        }
    }
    
    public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new TratamientoDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
    
}
