
package veterinaria.mode.entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;
    
    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Propietario propietario;
    
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String color;
    private Double pesoActual;
    private Boolean esterilizado;
    private String estado;
    
    @OneToMany(mappedBy = "historialclinico", cascade = CascadeType.ALL)
    private List<HistorialClinico> historiales;
    
    @OneToMany(mappedBy = "mascotaAlergia", cascade = CascadeType.ALL)
    private List<MascotaAlergia> mascota;
    
    
    public Long getIdMascota(){
        return idMascota;
    }
    
    public void setIdMascota(Long isMascota){
        this.idMascota = idMascota;
    }
    
    public Propietario getPropietario(){
        return propietario;
    }
    
    public void setPropietario(Propietario propietario){
        this.propietario = propietario;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getEspecie(){
        return especie;
    }
    
    public void setEspecie(String especie){
        this.especie = especie;
    }
    
    public String getRaza(){
        return raza;
    }
    
    public void setRaza(String raza){
        this.raza = raza;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public Double getPesoActual(){
        return pesoActual;
    }
    
    public void setPesoActual(Double pesoActual){
        this.pesoActual = pesoActual;
    }
    
    public Boolean getEsterilizado(){
        return esterilizado;
    }
    
    public void setEsterilizado(Boolean esterilizado){
        this.esterilizado = esterilizado;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado (String estado){
        this.estado = estado;
    }
    
    public List<HistorialClinico> getHistoriales(){
        return historiales;
    }
    
    public void setHistoriales(List<HistorialClinico> historiales){
        this.historiales = historiales;
    }
    
    
}
