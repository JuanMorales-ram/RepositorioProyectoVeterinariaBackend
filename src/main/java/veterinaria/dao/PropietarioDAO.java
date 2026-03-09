/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.Propietario;

/**
 *
 * @author migad
 */
public class PropietarioDAO extends GenericDAO<Propietario, Long> {

    public PropietarioDAO(EntityManager em) {
        super(em, Propietario.class);
    }

}
