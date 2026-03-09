/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.HistorialClinico;

/**
 *
 * @author migad
 */
public class HistorialClinicoDAO extends GenericDAO<HistorialClinico, Long> {

    public HistorialClinicoDAO(EntityManager em) {
        super(em, HistorialClinico.class);
    }

}
