
package veterinaria.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
  
    
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("veterinariaPU"); 
    
    
    private JPAUtil(){
        //evita instanciacion
    }
    
    public static EntityManager getEntityManager(){
    
        return emf.createEntityManager(); 
    }
    
    public static void close(){
        if (emf !=null && emf.isOpen()){
            emf.close();
        }
    }
}
