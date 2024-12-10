/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ivand
 */
public class Prestamo {
    private int id;
    private int documento;
    private String apellido;
    private String nombre;
    private int monto;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setDocumento(int documento){
        this.documento = documento;
    }
    public int getDocumento(){
        return documento;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getApellido(){
        return apellido;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setMonto(int monto){
        this.monto = monto;
    }
    public int getMonto(){
        return monto;
    }
    
    public Prestamo(){
        
    }
    
    public Prestamo(int id, int documento, String apellido, String nombre, int monto){
        this.id = id;
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.monto = monto;
    }
    
    @Override
    public String toString(){
        return getId() + " - " + getDocumento() + " - " + getApellido() + " - " + getNombre() + " - " + getMonto();
    }
}
