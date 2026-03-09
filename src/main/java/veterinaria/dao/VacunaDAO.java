/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.Vacuna;

/**
 *
 * @author migad
 */
public class VacunaDAO extends GenericDAO<Vacuna, Long> {

    public VacunaDAO(EntityManager em) {
        super(em, Vacuna.class);
    }

}
