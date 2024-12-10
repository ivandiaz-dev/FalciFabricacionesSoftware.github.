/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ivand
 */
public class Administrador {
    private String usuario;
    private String clave;
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getUsuario(){
        return usuario;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    public String getClave(){
        return clave;
    }
    
    public Administrador(){
        
    }
    
    public Administrador(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }
    
    @Override
    public String toString(){
        return getUsuario() + " - " + getClave();
    }
}
