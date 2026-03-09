
package veterinaria.mode.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tratamiento")
public class Tratamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTratamiento;
    
    @ManyToOne
    @JoinColumn(name = "historial_id", nullable = false)
    private HistorialClinico Historial;
    
    @ManyToOne 
    @JoinColumn(name = "medicamento_id", nullable = false)
    private Medicamento medicamento;
    
    private String dosis;
    private String frecuencia;
    private Integer duracion;
    private String indicaciones;
    
    public Long getIdTratamiento(){
        return idTratamiento;
    }
    
    public void setIdTratamiento(Long idTratamiendoto){
        this.idTratamiento = idTratamiento;
    }
    
    public HistorialClinico getHistorial(){
        return Historial;
    }
    
    public void setHistorial(HistorialClinico historial){
        this.Historial = historial;
    }
    
    public Medicamento getMedicamento(){
        return medicamento;
    }
    
    public void setMedicamento(Medicamento medicamento){
        this.medicamento = medicamento;
    }
    
    public String getDosis(){
        return dosis;
    }
    
    public void setDosis(String dosis){
        this.dosis = dosis;
    }
    
    public String getFrecuencia(){
        return frecuencia;
    }
    
    public void setFrecuencia(String frecuencia){
        this.frecuencia = frecuencia;
    }
    
    public Integer getDuracion(){
        return duracion;
    }
    
    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }
    
    public String getIndicaciones(){
        return indicaciones;
    }
    
    public void setIndicaciones(String indicaciones){
        this.indicaciones = indicaciones;
    }
   
}
