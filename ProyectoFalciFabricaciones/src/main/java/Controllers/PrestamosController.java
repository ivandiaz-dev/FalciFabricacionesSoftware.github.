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
public class PrestamosController {
    public static PrestamosView prestamosView = new PrestamosView();
    
    public static RegistroPrestamosView registroPrestamosView = new RegistroPrestamosView();
    
    public static EdicionDePrestamosView edicionDePrestamosView = new EdicionDePrestamosView();
    
    public static AgregarPrestamosView agregarPrestamosView = new AgregarPrestamosView();
    
    public static DevolverPrestamosView devolverPrestamosView = new DevolverPrestamosView();
    
    public static void mostrarPrestamos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaPrestamos = c.prepareStatement("SELECT * FROM prestamos");
            
            ResultSet resultadoConsultaPrestamos = consultaPrestamos.executeQuery();
            
            DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
            
            datos.setRowCount(0);
            
            ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
            
            while(resultadoConsultaPrestamos.next()){
                Prestamo prestamo = new Prestamo(resultadoConsultaPrestamos.getInt("id"), resultadoConsultaPrestamos.getInt("documento"), resultadoConsultaPrestamos.getString("apellido"), resultadoConsultaPrestamos.getString("nombre"), resultadoConsultaPrestamos.getInt("monto"));
                
                prestamos.add(prestamo);
            }
            
            for(int i=0; i<prestamos.size(); i++){
                Prestamo prestamo = prestamos.get(i);
                
                Object[] filas = new Object[5];
                filas[0] = prestamo.getId();
                filas[1] = prestamo.getDocumento();
                filas[2] = prestamo.getApellido();
                filas[3] = prestamo.getNombre();
                filas[4] = prestamo.getMonto();
                
                datos.addRow(filas);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void registrarPrestamos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement registroPrestamo = c.prepareStatement("INSERT INTO prestamos(documento, apellido, nombre, monto) VALUES(?, ?, ?, ?)");
            
            registroPrestamo.setInt(1, Integer.parseInt(registroPrestamosView.getDocumentoText().getText()));
            registroPrestamo.setString(2, registroPrestamosView.getApellidoText().getText());
            registroPrestamo.setString(3, registroPrestamosView.getNombreText().getText());
            registroPrestamo.setInt(4, Integer.parseInt(registroPrestamosView.getMontoText().getText()));
            
            PreparedStatement consultaPrestamo = c.prepareStatement("SELECT * FROM prestamos");
            
            ResultSet resultadoConsultaPrestamo = consultaPrestamo.executeQuery();
            
            ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
            
            while(resultadoConsultaPrestamo.next()){
                Prestamo prestamo = new Prestamo(resultadoConsultaPrestamo.getInt("id"), resultadoConsultaPrestamo.getInt("documento"), resultadoConsultaPrestamo.getString("apellido"), resultadoConsultaPrestamo.getString("nombre"), resultadoConsultaPrestamo.getInt("monto"));
                
                prestamos.add(prestamo);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<prestamos.size(); i++){
                Prestamo prestamo = prestamos.get(i);
                
                int documento = prestamo.getDocumento();
                
                if(documento == Integer.parseInt(registroPrestamosView.getDocumentoText().getText())){
                    JOptionPane.showMessageDialog(null, "El documento ya está registrado");
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                registroPrestamo.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void buscarPrestamo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaPrestamos = c.prepareStatement("SELECT * FROM prestamos");
            
            ResultSet resultadoConsultaPrestamos = consultaPrestamos.executeQuery();
            
            ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
            
            while(resultadoConsultaPrestamos.next()){
                Prestamo prestamo = new Prestamo(resultadoConsultaPrestamos.getInt("id"), resultadoConsultaPrestamos.getInt("documento"), resultadoConsultaPrestamos.getString("apellido"), resultadoConsultaPrestamos.getString("nombre"), resultadoConsultaPrestamos.getInt("monto"));
                
                prestamos.add(prestamo);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<prestamos.size(); i++){
                Prestamo prestamo = prestamos.get(i);
                
                int documento = prestamo.getDocumento();
                
                if(documento == Integer.parseInt(prestamosView.getDocumentoText().getText())){
                    PreparedStatement buscarPrestamo = c.prepareStatement("SELECT * FROM prestamos WHERE documento = ?");
                    
                    buscarPrestamo.setInt(1, Integer.parseInt(prestamosView.getDocumentoText().getText()));
                    
                    ResultSet resultadoBuscarPrestamo = buscarPrestamo.executeQuery();
                    
                    resultadoBuscarPrestamo.next();
                    
                    DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
                    
                    datos.setRowCount(0);
                    
                    Prestamo p = new Prestamo(resultadoBuscarPrestamo.getInt("id"), resultadoBuscarPrestamo.getInt("documento"), resultadoBuscarPrestamo.getString("apellido"), resultadoBuscarPrestamo.getString("nombre"), resultadoBuscarPrestamo.getInt("monto"));
                    
                    Object[] filas = new Object[5];
                    filas[0] = p.getId();
                    filas[1] = p.getDocumento();
                    filas[2] = p.getApellido();
                    filas[3] = p.getNombre();
                    filas[4] = p.getMonto();
                    
                    datos.addRow(filas);
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "No se encontró el prestamo");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCampoEditar(){
        int numeroFilas = prestamosView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            String documento = datos.getValueAt(numeroFilas, 1).toString();
            String apellido = datos.getValueAt(numeroFilas, 2).toString();
            String nombre = datos.getValueAt(numeroFilas, 3).toString();
            String monto = datos.getValueAt(numeroFilas, 4).toString();
            
            edicionDePrestamosView.getNombreText().setText(nombre);
            edicionDePrestamosView.getApellidoText().setText(apellido);
            edicionDePrestamosView.getDocumentoText().setText(documento);
            edicionDePrestamosView.getMontoText().setText(monto);
            edicionDePrestamosView.getIdPrestamoText().setText(id);
        }
    }
    
    public static void editarPrestamo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement editarPrestamo = c.prepareStatement("UPDATE prestamos SET documento = ?, apellido = ?, nombre = ?, monto = ? WHERE id = ?");
            
            editarPrestamo.setInt(1, Integer.parseInt(edicionDePrestamosView.getDocumentoText().getText()));
            editarPrestamo.setString(2, edicionDePrestamosView.getApellidoText().getText());
            editarPrestamo.setString(3, edicionDePrestamosView.getNombreText().getText());
            editarPrestamo.setInt(4, Integer.parseInt(edicionDePrestamosView.getMontoText().getText()));
            editarPrestamo.setInt(5, Integer.parseInt(edicionDePrestamosView.getIdPrestamoText().getText()));
            
            editarPrestamo.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCampoAgregar(){
        int numeroFilas = prestamosView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            
            agregarPrestamosView.getIdPrestamoText().setText(id);
        }
    }
    
    public static void agregarAlPrestamo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaMonto = c.prepareStatement("SELECT * FROM prestamos WHERE id = ?");
            
            consultaMonto.setInt(1, Integer.parseInt(agregarPrestamosView.getIdPrestamoText().getText()));
            
            ResultSet resultadoConsultaMonto = consultaMonto.executeQuery();
            
            resultadoConsultaMonto.next();
            
            Prestamo prestamo = new Prestamo(resultadoConsultaMonto.getInt("id"), resultadoConsultaMonto.getInt("documento"), resultadoConsultaMonto.getString("apellido"), resultadoConsultaMonto.getString("nombre"), resultadoConsultaMonto.getInt("monto"));
            
            int monto = prestamo.getMonto();
            
            PreparedStatement editarMonto = c.prepareStatement("UPDATE prestamos SET monto = ? WHERE id = ?");
            
            int agregado = Integer.parseInt(agregarPrestamosView.getMontoText().getText());
            
            int montoNuevo = monto + agregado;
            
            editarMonto.setInt(1, montoNuevo);
            editarMonto.setInt(2, Integer.parseInt(agregarPrestamosView.getIdPrestamoText().getText()));
            
            editarMonto.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCampoDevolver(){
        int numeroFilas = prestamosView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            
            devolverPrestamosView.getIdPrestamoText().setText(id);
        }
    }
    
    public static void devolverAlPrestamo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaMonto = c.prepareStatement("SELECT * FROM prestamos WHERE id = ?");
            
            consultaMonto.setInt(1, Integer.parseInt(devolverPrestamosView.getIdPrestamoText().getText()));
            
            ResultSet resultadoConsultaMonto = consultaMonto.executeQuery();
            
            resultadoConsultaMonto.next();
            
            Prestamo prestamo = new Prestamo(resultadoConsultaMonto.getInt("id"), resultadoConsultaMonto.getInt("documento"), resultadoConsultaMonto.getString("apellido"), resultadoConsultaMonto.getString("nombre"), resultadoConsultaMonto.getInt("monto"));
            
            int monto = prestamo.getMonto();
            
            PreparedStatement editarMonto = c.prepareStatement("UPDATE prestamos SET monto = ? WHERE id = ?");
            
            int devolucion = Integer.parseInt(devolverPrestamosView.getMontoText().getText());
            
            int montoNuevo = monto - devolucion;
            
            editarMonto.setInt(1, montoNuevo);
            editarMonto.setInt(2, Integer.parseInt(devolverPrestamosView.getIdPrestamoText().getText()));
            
            editarMonto.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void borrarPrestamo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement eliminarPrestamo = c.prepareStatement("DELETE FROM prestamos WHERE id = ?");
            
            int numeroFilas = prestamosView.getjTable1().getSelectedRow();
            
            DefaultTableModel datos = (DefaultTableModel) prestamosView.getjTable1().getModel();
            
            if(numeroFilas >= 0){
                int id = Integer.parseInt(datos.getValueAt(numeroFilas, 0).toString());
                
                eliminarPrestamo.setInt(1, id);
                
                eliminarPrestamo.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
