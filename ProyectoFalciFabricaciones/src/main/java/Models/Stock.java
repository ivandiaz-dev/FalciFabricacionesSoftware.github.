/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ivand
 */
public class Stock {
    private int id;
    private String codigo;
    private String tipo;
    private String espesor;
    private String material;
    private int medida;
    private int cantidad; 
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    
    public void setEspesor(String espesor){
        this.espesor = espesor;
    }
    public String getEspesor(){
        return espesor;
    }
    
    public void setMaterial(String material){
        this.material = material;
    }
    public String getMaterial(){
        return material;
    }
    
    public void setMedida(int medida){
        this.medida = medida;
    }
    public int getMedida(){
        return medida;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
    
    public Stock(){
        
    }
    
    public Stock(int id, String codigo, String tipo, String espesor, String material, int medida, int cantidad){
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.espesor = espesor;
        this.material = material;
        this.medida = medida;
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return getId() + " - " + getCodigo() + " - " + getTipo() + " - " + getEspesor() + " - " + getMaterial() + " - " + getMedida() + " - " + getCantidad();
    }
}
