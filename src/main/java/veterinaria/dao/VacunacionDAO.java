/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.Vacunacion;

/**
 *
 * @author migad
 */
public class VacunacionDAO extends GenericDAO<Vacunacion, Long> {

    public VacunacionDAO(EntityManager em) {
        super(em, Vacunacion.class);
    }

}
