/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.mode.entity;

/**
 *
 * @author Alejandra Arias
 */

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacunacion")
public class Vacunacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacunacion;
    
    @ManyToOne 
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
    
    @ManyToOne 
    @JoinColumn(name = "vacuna_id", nullable = false)
    private Vacuna vacuna;
    
    private LocalDate fechaAplicacion;
    private LocalDate fechaProxima;
    private String observaciones;
    
    
    public Long getIdVacunacion(){
        return idVacunacion;
    }
    
    public void setIdVacunacion(Long idVacunacion){
        this.idVacunacion = idVacunacion;
    }
    
    public Mascota getMascota(){
        return mascota;
    } 
    
    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
    
    public Vacuna getVacuna(){
        return vacuna;
    } 
    
    public void setVacuna(Vacuna vacuna){
        this.vacuna = vacuna;
    }
    
    public LocalDate getFechaAplicacion(){
        return fechaAplicacion;
    } 
    
    public void setFechaAplicacion(LocalDate fechaAplicacion){
        this.fechaAplicacion = fechaAplicacion;
    }
    
    public LocalDate getFechaProxima(){
        return fechaProxima;
    } 
    
    public void setFechaProxima(LocalDate fechaProxima){
        this.fechaProxima = fechaProxima;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
}
