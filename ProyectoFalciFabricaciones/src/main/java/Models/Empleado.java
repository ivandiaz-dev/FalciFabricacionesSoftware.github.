/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ivand
 */
public class Empleado {
    private int id; 
    private int documento; 
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    
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
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getApellido(){
        return apellido;
    }
    
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
    public String getDomicilio(){
        return domicilio;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getTelefono(){
        return telefono;
    }
    
    public Empleado(){
        
    }
    
    public Empleado(int id, int documento, String nombre, String apellido, String domicilio, String telefono){
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return getId() + " - " + getDocumento() + " - " + getNombre() + " - " + getApellido() + " - " + getDomicilio() + " - " + getTelefono();
    }
}
