/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.mode.entity.Tratamiento;

/**
 *
 * @author migad
 */
public class TratamientoDAO extends GenericDAO<Tratamiento, Long> {

    public TratamientoDAO(EntityManager em) {
        super(em, Tratamiento.class);
    }

    public List<Tratamiento> buscarPorHistorial(Long idHistorial) {
        return em.createQuery(
            "SELECT t FROM Tratamiento t WHERE t.historial.idHistorial = :id",
            Tratamiento.class
        )
        .setParameter("id", idHistorial)
        .getResultList();
    }
}