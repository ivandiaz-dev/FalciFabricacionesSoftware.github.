/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.*;
import Models.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivand
 */
public class LiquidacionController {
    public static LiquidacionView liquidacionView = new LiquidacionView();
    
    public static RegistroLiquidacionView registroLiquidacionView = new RegistroLiquidacionView();
    
    public static EdicionDeLiquidacionView edicionDeLiquidacionView = new EdicionDeLiquidacionView();
    
    public static CalculadoraDeLiquidacionView calculadoraDeLiquidacionView = new CalculadoraDeLiquidacionView();
    
    public static void mostrarLiquidacion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaLiquidacion = c.prepareStatement("SELECT * FROM liquidacion");
            
            ResultSet resultadoConsultaLiquidacion = consultaLiquidacion.executeQuery();
            
            DefaultTableModel datos = (DefaultTableModel) liquidacionView.getjTable1().getModel();
            
            datos.setRowCount(0);
            
            ArrayList<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
            
            while(resultadoConsultaLiquidacion.next()){
                Liquidacion liquidacion = new Liquidacion(resultadoConsultaLiquidacion.getInt("id"), resultadoConsultaLiquidacion.getInt("documento"), resultadoConsultaLiquidacion.getString("apellido"), resultadoConsultaLiquidacion.getString("nombre"), resultadoConsultaLiquidacion.getInt("semanal"));
                
                liquidaciones.add(liquidacion);
            }
            
            for(int i=0; i<liquidaciones.size(); i++){
                Liquidacion liquidacion = liquidaciones.get(i);
                
                Object[] filas = new Object[5];
                filas[0] = liquidacion.getId();
                filas[1] = liquidacion.getDocumento();
                filas[2] = liquidacion.getApellido();
                filas[3] = liquidacion.getNombre();
                filas[4] = liquidacion.getSemanal();
                
                datos.addRow(filas);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void registrarLiquidacion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement registroLiquidacion = c.prepareStatement("INSERT INTO liquidacion(documento, apellido, nombre, semanal) VALUES(?, ?, ?, ?)");
            
            registroLiquidacion.setInt(1, Integer.parseInt(registroLiquidacionView.getDocumentoText().getText()));
            registroLiquidacion.setString(2, registroLiquidacionView.getApellidoText().getText());
            registroLiquidacion.setString(3, registroLiquidacionView.getNombreText().getText());
            registroLiquidacion.setInt(4, Integer.parseInt(registroLiquidacionView.getSemanalText().getText()));
            
            PreparedStatement consultaLiquidacion = c.prepareStatement("SELECT * FROM liquidacion");
            
            ResultSet resultadoConsultaLiquidacion = consultaLiquidacion.executeQuery();
            
            ArrayList<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
            
            while(resultadoConsultaLiquidacion.next()){
                Liquidacion liquidacion = new Liquidacion(resultadoConsultaLiquidacion.getInt("id"), resultadoConsultaLiquidacion.getInt("documento"), resultadoConsultaLiquidacion.getString("apellido"), resultadoConsultaLiquidacion.getString("nombre"), resultadoConsultaLiquidacion.getInt("semanal"));
                
                liquidaciones.add(liquidacion);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<liquidaciones.size(); i++){
                Liquidacion liquidacion = liquidaciones.get(i);
                
                int documento = liquidacion.getDocumento();
                
                if(documento == Integer.parseInt(registroLiquidacionView.getDocumentoText().getText())){
                    JOptionPane.showMessageDialog(null, "Este documento ya está registrado");
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                registroLiquidacion.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void buscarLiquidacion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaLiquidacion = c.prepareStatement("SELECT * FROM liquidacion");
            
            ResultSet resultadoConsultaLiquidacion = consultaLiquidacion.executeQuery();
            
            ArrayList<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
            
            while(resultadoConsultaLiquidacion.next()){
                Liquidacion liquidacion = new Liquidacion(resultadoConsultaLiquidacion.getInt("id"), resultadoConsultaLiquidacion.getInt("documento"), resultadoConsultaLiquidacion.getString("apellido"), resultadoConsultaLiquidacion.getString("nombre"), resultadoConsultaLiquidacion.getInt("semanal"));   
                
                liquidaciones.add(liquidacion);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<liquidaciones.size(); i++){
                Liquidacion liquidacion = liquidaciones.get(i);
                
                int documento = liquidacion.getDocumento();
                
                if(documento == Integer.parseInt(liquidacionView.getDocumentoText().getText())){
                    PreparedStatement buscarLiquidacion = c.prepareStatement("SELECT * FROM liquidacion WHERE documento = ?");
                    
                    buscarLiquidacion.setInt(1, Integer.parseInt(liquidacionView.getDocumentoText().getText()));
                    
                    ResultSet resultadoBuscarLiquidacion = buscarLiquidacion.executeQuery();
                    
                    resultadoBuscarLiquidacion.next();
                    
                    DefaultTableModel datos = (DefaultTableModel) liquidacionView.getjTable1().getModel();
                    
                    datos.setRowCount(0);
                    
                    Liquidacion l = new Liquidacion(resultadoBuscarLiquidacion.getInt("id"), resultadoBuscarLiquidacion.getInt("documento"), resultadoBuscarLiquidacion.getString("apellido"), resultadoBuscarLiquidacion.getString("nombre"), resultadoBuscarLiquidacion.getInt("semanal"));
                    
                    Object[] filas = new Object[5];
                    filas[0] = l.getId();
                    filas[1] = l.getDocumento();
                    filas[2] = l.getApellido();
                    filas[3] = l.getNombre();
                    filas[4] = l.getSemanal();
                    
                    datos.addRow(filas);
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "No se encontró el documento.");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCampos(){
        int numeroFilas = liquidacionView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) liquidacionView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            String documento = datos.getValueAt(numeroFilas, 1).toString();
            String apellido = datos.getValueAt(numeroFilas, 2).toString();
            String nombre = datos.getValueAt(numeroFilas, 3).toString();
            String semanal = datos.getValueAt(numeroFilas, 4).toString();
            
            edicionDeLiquidacionView.getIdLiquidacionText().setText(id);
            edicionDeLiquidacionView.getDocumentoText().setText(documento);
            edicionDeLiquidacionView.getApellidoText().setText(apellido);
            edicionDeLiquidacionView.getNombreText().setText(nombre);
            edicionDeLiquidacionView.getSemanalText().setText(semanal);
        }
    }
    
    public static void editarLiquidacion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement editarLiquidacion = c.prepareStatement("UPDATE liquidacion SET documento = ?, apellido = ?, nombre = ?, semanal = ? WHERE id = ?");
            
            editarLiquidacion.setInt(1, Integer.parseInt(edicionDeLiquidacionView.getDocumentoText().getText()));
            editarLiquidacion.setString(2, edicionDeLiquidacionView.getApellidoText().getText());
            editarLiquidacion.setString(3, edicionDeLiquidacionView.getNombreText().getText());
            editarLiquidacion.setInt(4, Integer.parseInt(edicionDeLiquidacionView.getSemanalText().getText()));
            editarLiquidacion.setInt(5, Integer.parseInt(edicionDeLiquidacionView.getIdLiquidacionText().getText()));
            
            editarLiquidacion.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCamposCalculadora(){
        int numeroFilas = liquidacionView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) liquidacionView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            String documento = datos.getValueAt(numeroFilas, 1).toString();
            String apellido = datos.getValueAt(numeroFilas, 2).toString();
            String nombre = datos.getValueAt(numeroFilas, 3).toString();
            String semanal = datos.getValueAt(numeroFilas, 4).toString();
            
            calculadoraDeLiquidacionView.getSueldoText().setText(semanal);
        }
    }
    
    public static void calcularLiquidacion(){
        float sueldo = Float.parseFloat(calculadoraDeLiquidacionView.getSueldoText().getText());
        float cantidadHora =  Float.parseFloat(calculadoraDeLiquidacionView.getHorasText().getText());
        float cantidadHoraExtra = Float.parseFloat(calculadoraDeLiquidacionView.getHorasExtrasText().getText());
        
        float sueldoHora = (sueldo/5) / 8;
        
        float diaNormal = sueldoHora * cantidadHora;
        float Extra = (sueldoHora*2) * cantidadHoraExtra;
        
        float totalPagar = diaNormal + Extra;
        
        JOptionPane.showMessageDialog(null, "El total a pagar es: $" + totalPagar);
    }
    
    public static void borrarLiquidacion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement borrarLiquidacion = c.prepareStatement("DELETE FROM liquidacion WHERE id = ?");
            
            int numeroFilas = liquidacionView.getjTable1().getSelectedRow();
            
            DefaultTableModel datos = (DefaultTableModel) liquidacionView.getjTable1().getModel();
            
            if(numeroFilas >= 0){
                int id = Integer.parseInt(datos.getValueAt(numeroFilas, 0).toString());
                
                borrarLiquidacion.setInt(1, id);
                
                borrarLiquidacion.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
