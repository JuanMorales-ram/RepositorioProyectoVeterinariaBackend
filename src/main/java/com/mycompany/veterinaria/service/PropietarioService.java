/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.dao.PropietarioDAO;
import veterinaria.mode.entity.Propietario;
import veterinaria.util.JPAUtil;

/**
 *
 * @author juand
 */
public class PropietarioService {
    
    public void crear (Propietario propietario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            PropietarioDAO dao = new PropietarioDAO(em);
            dao.create(propietario);
        }finally{
            em.close();
        }
    }
    
    public Propietario buscarPorId(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new PropietarioDAO(em).buscarPorId(id);
        }finally{
            em.close();
        }
    }
    
    public List <Propietario> ListarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return new PropietarioDAO(em).listarTodos();
        }finally{
            em.close();
        }
    }
    
    public void actualizar (Propietario propietario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new PropietarioDAO(em).actualizar(propietario);
        }finally{
            em.close();
        }
    }
    
    public void eliminar (Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            new PropietarioDAO(em).eliminar(id);
        }finally{
            em.close();
        }
    }
    
}
