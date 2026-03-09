
package veterinaria.mode.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "mascotaalergia")
public class MascotaAlergia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
    
    @ManyToOne
    @JoinColumn(name = "alergia_id", nullable = false)
    private Alergia alergia;
    
    private String observaciones;
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
     public Mascota getMascota(){
         return mascota;
     }
     
     public void setMascota(Mascota mascota){
         this.mascota = mascota;
     }
     
     public Alergia getAlergia(){
         return alergia;
     }
     
     public void setAlergia(Alergia alergia){
         this.alergia = alergia;
     }
     
     public String getObservaciones(){
         return observaciones;
     }
     
     public void setObservaciones(String observaciones){
         this.observaciones = observaciones;
     }
   
}
