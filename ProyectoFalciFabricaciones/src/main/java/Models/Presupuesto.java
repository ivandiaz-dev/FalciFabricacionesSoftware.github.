/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ivand
 */
public class Presupuesto {
    private int id;
    private String nombre;
    private String trabajo;
    private int material;
    private int manoDeObra;
    private float ganancia;
    private float total;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setTrabajo(String trabajo){
        this.trabajo = trabajo;
    }
    public String getTrabajo(){
        return trabajo;
    }
    
    public void setMaterial(int material){
        this.material = material;
    }
    public int getMaterial(){
        return material;
    }
    
    public void setManoDeObra(int manoDeObra){
        this.manoDeObra = manoDeObra;
    }
    public int getManoDeObra(){
        return manoDeObra;
    }
    
    public void setGanancia(float ganancia){
        this.ganancia = ganancia;
    }
    public float getGanancia(){
        return ganancia;
    }
    
    public void setTotal(float total){
        this.total = total;
    }
    public float getTotal(){
        return total;
    }
    
    public Presupuesto(){
        
    }
    
    public Presupuesto(int id, String nombre, String trabajo, int material, int manoDeObra, float ganancia, float total){
        this.id = id;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.material = material;
        this.manoDeObra = manoDeObra;
        this.ganancia = ganancia;
        this.total = total;
    }
    
    @Override
    public String toString(){
        return getId() + " - " + getNombre() + " - " + getTrabajo() + " - " + getMaterial() + " - " + getManoDeObra() + " - " + getGanancia() + " - " + getTotal();
    }
}
