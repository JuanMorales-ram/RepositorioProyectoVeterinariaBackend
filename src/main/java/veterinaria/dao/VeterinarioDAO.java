/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.Veterinario;

/**
 *
 * @author migad
 */
public class VeterinarioDAO extends GenericDAO<Veterinario, Long> {

    public VeterinarioDAO(EntityManager em) {
        super(em, Veterinario.class);
    }

    
    public long count(){
        return em.createQuery("SELECT COUNT(v) FROM Veterinario v", Long.class)
                .getSingleResult();
    }
}
