
package veterinaria.mode.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "alergia")
public class Alergia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlergia;
    
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "alergia")
    private List<MascotaAlergia> mascotas;
    
    public Long getIdAlergia(){
        return idAlergia;
    }
    
    public void serIdAlergia(Long idAlergia){
        this.idAlergia = idAlergia;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public List<MascotaAlergia> getMascota(){
        return mascotas;
    }
    
    public void setMascotas(List<MascotaAlergia> mascotas){
        this.mascotas = mascotas;
    }
    
}

