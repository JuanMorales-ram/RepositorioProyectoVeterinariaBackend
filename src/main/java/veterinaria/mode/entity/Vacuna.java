
package veterinaria.mode.entity;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vacuna")
public class Vacuna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacuna;
    
    private String nombre;
    private String descripcion;
    private String especieAplicable;
    
    @OneToMany(mappedBy = "vacuna")
    private List<Vacunacion> vacunaciones;

    public Long getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Long idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecieAplicable() {
        return especieAplicable;
    }

    public void setEspecieAplicable(String especieAplicable) {
        this.especieAplicable = especieAplicable;
    }

    public List<Vacunacion> getVacunaciones() {
        return vacunaciones;
    }

    public void setVacunaciones(List<Vacunacion> vacunaciones) {
        this.vacunaciones = vacunaciones;
    }
    
  
    
}
