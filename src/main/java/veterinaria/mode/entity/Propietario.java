
package veterinaria.mode.entity;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropietario;
    
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion;
    
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;
    
    private Long getIdPropietario(){
        return idPropietario;
    }
    
    public void setIdPropietario(Long idPropietario){
        this.idPropietario = idPropietario;
    }
    
    public String getTipoDocuemnto(){
        return tipoDocumento;
    }
    
    public void setTipoDocumento(String tipodocumento){
        this.tipoDocumento = tipoDocumento;
    }
    
    public String getNumeroDocumento(){
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento){
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void getApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getTlefono(){
        return apellidos;
    }
    
    public void getTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void getEmail(String email){
        this.email = email;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void getDireccion(String direccion){
        this.direccion = direccion;
    }
    
   public List<Mascota> getMascotas(){
       return mascotas;
   }
   
   public void setMascotas(List<Mascota> mascotas){
       this.mascotas = mascotas;
   }
}
