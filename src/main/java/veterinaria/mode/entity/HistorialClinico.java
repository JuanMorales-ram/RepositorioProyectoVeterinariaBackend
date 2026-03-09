
package veterinaria.mode.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "historialclinico")
public class HistorialClinico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
    
    @ManyToOne 
    @JoinColumn(name = "idMascota", nullable = false )
    private Mascota mascota;
    
    @ManyToOne
    @JoinColumn(name = "idVeterinario", nullable = false)
    private Veterinario veterinario;
    
    private LocalDateTime fechaAtencion;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;
    private Double peso;
    private Double temperatura;
    
    @OneToMany(mappedBy = "historialclinico", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamientos;
    
    public long getIdHistorial(){
        return idHistorial;
    }
    
    public void setIdHistorial(Long idHistorial){
        this.idHistorial = idHistorial;
    }
    
    public Mascota getMascota(){
        return mascota;
    }
    
    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
    
    public Veterinario getVeterinario(){
        return veterinario;
    }
    
    public void setVeterinario(Veterinario veterinario){
        this.veterinario = veterinario;
    }
    
    public LocalDateTime getFechaAtencion(){
        return fechaAtencion;
    }
    
    public void setFechaAtencion(LocalDateTime fechaAtencion){
        this.fechaAtencion = fechaAtencion;
    }
    
    public String getMotivoConsulta(){
        return motivoConsulta;
    }
    
    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta = motivoConsulta ;
    }
    
    public String getDiagnostico(){
        return diagnostico;
    }
    
    public void setDiagnostico(String diagnostico){
        this.diagnostico = diagnostico;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
  
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
    public Double getPeso(){
        return peso;
    }
    
    public void setPeso(Double peso){
        this.peso = peso;
    }
    
    public Double getTemperatura(){
        return temperatura;
    }
    
    public void setTemperatura(Double temperatura){
        this.temperatura = temperatura;
    }
    
    public List<Tratamiento> getTratamientos(){
        return tratamientos;
    }
    
    public void setTratamientos(List<Tratamiento> tratamientos){
        this.tratamientos = tratamientos;
    }
    
}
