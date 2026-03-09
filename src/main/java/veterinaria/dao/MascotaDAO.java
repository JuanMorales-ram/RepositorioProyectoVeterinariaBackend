/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import veterinaria.mode.entity.Mascota;

/**
 *
 * @author migad
 */
public class MascotaDAO extends GenericDAO<Mascota, Long>{
    
    public MascotaDAO(EntityManager em){
        super(em, Mascota.class);
    }
    
   public List<Mascota> buscarPorPropietario(Long idPropietario) {
    return em.createQuery(
        "SELECT m FROM Mascota m WHERE m.propietario.idPropietario = :id",
        Mascota.class
    )
    .setParameter("id", idPropietario)
    .getResultList();
}
    
}
