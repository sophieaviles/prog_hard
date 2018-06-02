/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo;

import java.io.Serializable;

/**
 *
 * @author J y D
 */
public class MdatosEnvio implements Serializable {
    
    private int id_dato;
    private double Humedad;
    private String Fecha;

    public int getId_dato() {
        return id_dato;
    }

    public void setId_dato(int id_dato) {
        this.id_dato = id_dato;
    }

    public double getHumedad() {
        return Humedad;
    }

    public void setHumedad(double Humedad) {
        this.Humedad = Humedad;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
   

    
    
    
   

}
