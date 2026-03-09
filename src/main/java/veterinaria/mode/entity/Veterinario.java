
package veterinaria.mode.entity;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinario")
public class Veterinario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeterinario;
    
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String telefono;
    private String email;
    private String estado;
    
    @OneToMany(mappedBy = "veterinario")
    private List<HistorialClinico> historiales;
    
    public Long getIdVeterinario(){
        return idVeterinario;
    }
    
    public void setIdVeterinario(Long idVeterinario){
        this.idVeterinario = idVeterinario;
    }
    
    public String getTipoDocuemnto(){
        return tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }
    
    public String getNumeroDocumento(){
        return tipoDocumento;
    }
    
    public void serNumeroDocumento(String numeroDocumento){
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
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
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
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public List<HistorialClinico> getHistoriales(){
        return historiales;
    }
    
    public void setHistoriales(List<HistorialClinico> historiales){
        this.historiales = historiales;
    }
    
}
