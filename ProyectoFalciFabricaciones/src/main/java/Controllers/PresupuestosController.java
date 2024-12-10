/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.*;
import Views.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivand
 */
public class PresupuestosController {
    public static PresupuestosView presupuestosView = new PresupuestosView();
    
    public static RegistroPresupuestoView registroPresupuestoView = new RegistroPresupuestoView();
    
    public static EdicionDePresupuestoView edicionDePresupuestoView = new EdicionDePresupuestoView();
    
    public static void mostrarPresupuesto(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaPrestamos = c.prepareStatement("SELECT * FROM presupuestos");
            
            ResultSet resultadoConsultaPrestamo = consultaPrestamos.executeQuery();
            
            DefaultTableModel datos = (DefaultTableModel) presupuestosView.getjTable1().getModel();
            
            datos.setRowCount(0);
            
            ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
            
            while(resultadoConsultaPrestamo.next()){
                Presupuesto presupuesto = new Presupuesto(resultadoConsultaPrestamo.getInt("id"), resultadoConsultaPrestamo.getString("nombre"), resultadoConsultaPrestamo.getString("trabajo"), resultadoConsultaPrestamo.getInt("material"), resultadoConsultaPrestamo.getInt("manoDeObra"), resultadoConsultaPrestamo.getFloat("ganancia"), resultadoConsultaPrestamo.getFloat("total"));
                
                presupuestos.add(presupuesto);
            }
            
            for(int i=0; i<presupuestos.size(); i++){
                Presupuesto presupuesto = presupuestos.get(i);
                
                Object[] filas = new Object[7];
                filas[0] = presupuesto.getId();
                filas[1] = presupuesto.getNombre();
                filas[2] = presupuesto.getTrabajo();
                filas[3] = presupuesto.getMaterial();
                filas[4] = presupuesto.getManoDeObra();
                filas[5] = presupuesto.getGanancia();
                filas[6] = presupuesto.getTotal();
                
                datos.addRow(filas);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void registrarPresupuesto(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement registroPresupuesto = c.prepareStatement("INSERT INTO presupuestos(nombre, trabajo, material, manoDeObra, ganancia, total) VALUES(?, ?, ?, ?, ?, ?)");
            
            registroPresupuesto.setString(1, registroPresupuestoView.getNombreText().getText());
            registroPresupuesto.setString(2, registroPresupuestoView.getTrabajoText().getText());
            registroPresupuesto.setInt(3, Integer.parseInt(registroPresupuestoView.getMaterialText().getText()));
            registroPresupuesto.setInt(4, Integer.parseInt(registroPresupuestoView.getManoDeObraText().getText()));
            registroPresupuesto.setFloat(5, Float.parseFloat(registroPresupuestoView.getGananciaText().getText()));
            
            int material = Integer.parseInt(registroPresupuestoView.getMaterialText().getText());
            
            int manoDeObra = Integer.parseInt(registroPresupuestoView.getManoDeObraText().getText());
            
            float ganancia = Float.parseFloat(registroPresupuestoView.getGananciaText().getText());
            
            float total = (material+manoDeObra) + (material+manoDeObra)*(ganancia/100);
            
            registroPresupuesto.setFloat(6, total);
            
            registroPresupuesto.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void buscarPresupuesto(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaPresupuesto = c.prepareStatement("SELECT * FROM presupuestos");
            
            ResultSet resultadoConsultaPresupuesto = consultaPresupuesto.executeQuery();
            
            ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
            
            while(resultadoConsultaPresupuesto.next()){
                Presupuesto presupuesto = new Presupuesto(resultadoConsultaPresupuesto.getInt("id"), resultadoConsultaPresupuesto.getString("nombre"), resultadoConsultaPresupuesto.getString("trabajo"), resultadoConsultaPresupuesto.getInt("material"), resultadoConsultaPresupuesto.getInt("manoDeObra"), resultadoConsultaPresupuesto.getFloat("ganancia"), resultadoConsultaPresupuesto.getFloat("total"));
                
                presupuestos.add(presupuesto);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<presupuestos.size(); i++){
                Presupuesto presupuesto = presupuestos.get(i);
                
                String nombre = presupuesto.getNombre().toLowerCase();
                
                String nombreComparacion = presupuestosView.getNombreText().getText().toLowerCase();
                
                if(nombreComparacion.equals(nombre)){
                    PreparedStatement buscarPresupuesto = c.prepareStatement("SELECT * FROM presupuestos WHERE nombre = ?");
                    
                    buscarPresupuesto.setString(1, presupuestosView.getNombreText().getText());
                    
                    ResultSet resultadoBuscarPresupuesto = buscarPresupuesto.executeQuery();
                    
                    resultadoBuscarPresupuesto.next();
                    
                    DefaultTableModel datos = (DefaultTableModel) presupuestosView.getjTable1().getModel();
                    
                    datos.setRowCount(0);
                    
                    Presupuesto p = new Presupuesto(resultadoBuscarPresupuesto.getInt("id"), resultadoBuscarPresupuesto.getString("nombre"), resultadoBuscarPresupuesto.getString("trabajo"), resultadoBuscarPresupuesto.getInt("material"), resultadoBuscarPresupuesto.getInt("manoDeObra"), resultadoBuscarPresupuesto.getFloat("ganancia"), resultadoBuscarPresupuesto.getFloat("total"));
                    
                    Object[] filas = new Object[7];
                    filas[0] = p.getId();
                    filas[1] = p.getNombre();
                    filas[2] = p.getTrabajo();
                    filas[3] = p.getMaterial();
                    filas[4] = p.getManoDeObra();
                    filas[5] = p.getGanancia();
                    filas[6] = p.getTotal();
                    
                    datos.addRow(filas);
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "No se encontró el presupuesto");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarEditar(){
        int numeroFilas = presupuestosView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) presupuestosView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            String nombre = datos.getValueAt(numeroFilas, 1).toString();
            String trabajo = datos.getValueAt(numeroFilas, 2).toString();
            String material = datos.getValueAt(numeroFilas, 3).toString();
            String manoDeObra = datos.getValueAt(numeroFilas, 4).toString();
            String ganancia = datos.getValueAt(numeroFilas, 5).toString();
            
            edicionDePresupuestoView.getIdPresupuestoText().setText(id);
            edicionDePresupuestoView.getNombreText().setText(nombre);
            edicionDePresupuestoView.getTrabajoText().setText(trabajo);
            edicionDePresupuestoView.getMaterialText().setText(material);
            edicionDePresupuestoView.getManoDeObraText().setText(manoDeObra);
            edicionDePresupuestoView.getGananciaText().setText(ganancia);
        }
    }
    
    public static void editarPresupuesto(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement editarPresupuesto = c.prepareStatement("UPDATE presupuestos SET nombre = ?, trabajo = ?, material = ?, manoDeObra = ?, ganancia = ?, total = ? WHERE id = ?");
            
            editarPresupuesto.setString(1, edicionDePresupuestoView.getNombreText().getText());
            editarPresupuesto.setString(2, edicionDePresupuestoView.getTrabajoText().getText());
            editarPresupuesto.setInt(3, Integer.parseInt(edicionDePresupuestoView.getMaterialText().getText()));
            editarPresupuesto.setInt(4, Integer.parseInt(edicionDePresupuestoView.getManoDeObraText().getText()));
            editarPresupuesto.setFloat(5, Float.parseFloat(edicionDePresupuestoView.getGananciaText().getText()));
            
            int material = Integer.parseInt(edicionDePresupuestoView.getMaterialText().getText());
            
            int manoDeObra = Integer.parseInt(edicionDePresupuestoView.getManoDeObraText().getText());
            
            float ganancia = Float.parseFloat(edicionDePresupuestoView.getGananciaText().getText());
            
            float total = (material+manoDeObra) + (material+manoDeObra)*(ganancia/100);
            
            editarPresupuesto.setFloat(6, total);
            
            editarPresupuesto.setInt(7, Integer.parseInt(edicionDePresupuestoView.getIdPresupuestoText().getText()));
            
            editarPresupuesto.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void borrarPresupuesto(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement borrarPresupuesto = c.prepareStatement("DELETE FROM presupuestos WHERE id = ?");
            
            int numeroFilas = presupuestosView.getjTable1().getSelectedRow();
            
            DefaultTableModel datos = (DefaultTableModel) presupuestosView.getjTable1().getModel();
            
            if(numeroFilas >= 0){
                int id = Integer.parseInt(datos.getValueAt(numeroFilas, 0).toString());
                
                borrarPresupuesto.setInt(1, id);
                
                borrarPresupuesto.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
