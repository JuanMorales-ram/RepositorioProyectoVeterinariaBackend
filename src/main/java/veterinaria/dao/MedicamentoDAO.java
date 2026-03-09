/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import veterinaria.mode.entity.Medicamento;

/**
 *
 * @author migad
 */
public class MedicamentoDAO extends GenericDAO<Medicamento, Long> {

    public MedicamentoDAO(EntityManager em) {
        super(em, Medicamento.class);
    }

}
