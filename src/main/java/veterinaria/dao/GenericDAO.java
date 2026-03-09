/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author migad
 */
public class GenericDAO<T, ID> {

    protected EntityManager em;
    private Class<T> entityClass;

    protected GenericDAO(EntityManager em, Class<T> entitiClass) {

        this.em = em;
        this.entityClass = entitiClass;

    }

    public void create(T entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    public T buscarPorId(ID id) {
        return em.find(entityClass, id);
    }

    public List<T> listarTodos() {

        return em.createQuery(
                "SELECT e FROM" + entityClass.getSimpleName() + "e",
                entityClass
        ).getResultList();

    }

    public void actualizar(T entidad) {

        em.getTransaction().begin();
        em.merge(entidad);
        em.getTransaction().commit();
    }

    public void eliminar(ID id) {

        em.getTransaction().begin();
        T entidad = buscarPorId(id);
        if (entidad != null) {
            em.remove(entidad);
        }
        em.getTransaction().commit();

    }

}
