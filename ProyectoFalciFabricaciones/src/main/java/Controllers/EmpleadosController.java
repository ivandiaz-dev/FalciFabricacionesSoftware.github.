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
public class EmpleadosController {
    public static EmpleadosView empleadosView = new EmpleadosView();
    
    public static RegistroEmpleadosView registroEmpleadosView = new RegistroEmpleadosView();
    
    public static EdicionDeEmpleadosView edicionDeEmpleadosView = new EdicionDeEmpleadosView();
    
    public static void registrarEmpleados(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaEmpleados = c.prepareStatement("SELECT * FROM empleados");
            
            ResultSet resultadoConsultaEmpleados = consultaEmpleados.executeQuery();
            
            ArrayList<Empleado> empleados = new ArrayList<Empleado>();
            
            while(resultadoConsultaEmpleados.next()){
                Empleado empleado = new Empleado(resultadoConsultaEmpleados.getInt("id"), resultadoConsultaEmpleados.getInt("documento"), resultadoConsultaEmpleados.getString("nombre"), resultadoConsultaEmpleados.getString("apellido"), resultadoConsultaEmpleados.getString("domicilio"), resultadoConsultaEmpleados.getString("telefono"));
                
                empleados.add(empleado);
            }
            
            PreparedStatement registroUsuario = c.prepareStatement("INSERT INTO empleados(documento, nombre, apellido, domicilio, telefono) VALUES(?, ?, ?, ?, ?)");
            
            registroUsuario.setInt(1, Integer.parseInt(registroEmpleadosView.getDocumentoText().getText()));
            registroUsuario.setString(2, registroEmpleadosView.getNombreText().getText());
            registroUsuario.setString(3, registroEmpleadosView.getApellidoText().getText());
            registroUsuario.setString(4, registroEmpleadosView.getDomicilioText().getText());
            registroUsuario.setString(5, registroEmpleadosView.getTelefonoText().getText());
            
            boolean encontrado = false;
            
            for(int i=0; i<empleados.size(); i++){
                Empleado empleado = empleados.get(i);
                
                int documento = empleado.getDocumento();
                String telefono = empleado.getTelefono();
                String telefonoIngresado = registroEmpleadosView.getTelefonoText().getText();
                
                if(documento == Integer.parseInt(registroEmpleadosView.getDocumentoText().getText()) || telefono.equals(telefonoIngresado)){
                    JOptionPane.showMessageDialog(null, "Ya existe un empleado con este documento o telefono");
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                registroUsuario.executeUpdate();
            }
        }catch(Exception e){
        System.out.println(e);
        }
    }
    
    public static void mostrarEmpleados(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaEmpleados = c.prepareStatement("SELECT * FROM empleados");
            
            ResultSet resultadoConsultaEmpleados = consultaEmpleados.executeQuery();
            
            DefaultTableModel datos = (DefaultTableModel) EmpleadosController.empleadosView.getjTable1().getModel();
            
            datos.setRowCount(0);
            
            ArrayList<Empleado> empleados = new ArrayList<Empleado>();
            
            while(resultadoConsultaEmpleados.next()){
                Empleado empleado = new Empleado(resultadoConsultaEmpleados.getInt("id"), resultadoConsultaEmpleados.getInt("documento"), resultadoConsultaEmpleados.getString("nombre"), resultadoConsultaEmpleados.getString("apellido"), resultadoConsultaEmpleados.getString("domicilio"), resultadoConsultaEmpleados.getString("telefono"));
                
                empleados.add(empleado);
            }
            
            for(int i=0; i<empleados.size(); i++){
                Empleado empleado = empleados.get(i);
                
                Object[] filas = new Object[6];
                filas[0] = empleado.getId();
                filas[1] = empleado.getDocumento();
                filas[2] = empleado.getNombre();
                filas[3] = empleado.getApellido();
                filas[4] = empleado.getDomicilio();
                filas[5] = empleado.getTelefono();
                
                datos.addRow(filas);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void buscarEmpleados(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement totalEmpleados = c.prepareStatement("SELECT * FROM empleados");
            
            ResultSet resultadoEmpleados = totalEmpleados.executeQuery();
            
            ArrayList<Empleado> empleados = new ArrayList<Empleado>();
            
            boolean encontrado = false;
            
            while(resultadoEmpleados.next()){
                Empleado empleado = new Empleado(resultadoEmpleados.getInt("id"), resultadoEmpleados.getInt("documento"), resultadoEmpleados.getString("nombre"), resultadoEmpleados.getString("apellido"), resultadoEmpleados.getString("domicilio"), resultadoEmpleados.getString("telefono"));
                
                empleados.add(empleado);
            }
            
            for(int i=0; i<empleados.size(); i++){
                Empleado empleado = empleados.get(i);
                
                int documento = empleado.getDocumento();
                
                if(documento == Integer.parseInt(empleadosView.getDocumentoText().getText())){
                    PreparedStatement consultaEmpleados = c.prepareStatement("SELECT * FROM empleados WHERE documento = ?");
            
                    consultaEmpleados.setInt(1, Integer.parseInt(empleadosView.getDocumentoText().getText()));
                    
                    ResultSet resultadoConsultaEmpleados = consultaEmpleados.executeQuery();
                    
                    resultadoConsultaEmpleados.next();
                    
                    DefaultTableModel datos = (DefaultTableModel) empleadosView.getjTable1().getModel();
            
                    datos.setRowCount(0);
                    
                    Empleado e = new Empleado(resultadoConsultaEmpleados.getInt("id"), resultadoConsultaEmpleados.getInt("documento"), resultadoConsultaEmpleados.getString("nombre"), resultadoConsultaEmpleados.getString("apellido"), resultadoConsultaEmpleados.getString("domicilio"), resultadoConsultaEmpleados.getString("telefono"));
            
                    Object[] filas = new Object[6];
                    filas[0] = e.getId();
                    filas[1] = e.getDocumento();
                    filas[2] = e.getNombre();
                    filas[3] = e.getApellido();
                    filas[4] = e.getDomicilio();
                    filas[5] = e.getTelefono();
                    
                    datos.addRow(filas);
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "No se encontró el empleado");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCampos(){
        int numeroFila = empleadosView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) empleadosView.getjTable1().getModel();
        
        if(numeroFila >= 0){
            String id = datos.getValueAt(numeroFila, 0).toString();
            String documento = datos.getValueAt(numeroFila, 1).toString();
            String nombre = datos.getValueAt(numeroFila, 2).toString();
            String apellido = datos.getValueAt(numeroFila, 3).toString();
            String domicilio = datos.getValueAt(numeroFila, 4).toString();
            String telefono = datos.getValueAt(numeroFila, 5).toString();
            
            edicionDeEmpleadosView.getIdEmpleadoText().setText(id);
            edicionDeEmpleadosView.getDocumentoText().setText(documento);
            edicionDeEmpleadosView.getNombreText().setText(nombre);
            edicionDeEmpleadosView.getApellidoText().setText(apellido);
            edicionDeEmpleadosView.getDomicilioText().setText(domicilio);
            edicionDeEmpleadosView.getTelefonoText().setText(telefono);
        }
    }
    
    public static void editarEmpleados(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement edicionEmpleado = c.prepareStatement("UPDATE empleados SET documento = ?, nombre = ?, apellido = ?, domicilio = ?, telefono = ? WHERE id = ?");
            
            edicionEmpleado.setInt(1, Integer.parseInt(edicionDeEmpleadosView.getDocumentoText().getText()));
            edicionEmpleado.setString(2, edicionDeEmpleadosView.getNombreText().getText());
            edicionEmpleado.setString(3, edicionDeEmpleadosView.getApellidoText().getText());
            edicionEmpleado.setString(4, edicionDeEmpleadosView.getDomicilioText().getText());
            edicionEmpleado.setString(5, edicionDeEmpleadosView.getTelefonoText().getText());
            edicionEmpleado.setInt(6, Integer.parseInt(edicionDeEmpleadosView.getIdEmpleadoText().getText()));
            
            edicionEmpleado.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void borrarEmpleados(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement borrarEmpleado = c.prepareStatement("DELETE FROM empleados WHERE id = ?");
            
            int numeroFila = empleadosView.getjTable1().getSelectedRow();
            
            DefaultTableModel datos = (DefaultTableModel) empleadosView.getjTable1().getModel();
            
            if(numeroFila >= 0){
                int id = Integer.parseInt(datos.getValueAt(numeroFila, 0).toString());
                
                borrarEmpleado.setInt(1, id);
                
                borrarEmpleado.executeUpdate();
            }   
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
