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
public class StockController {
    public static StockView stockView = new StockView();
    
    public static RegistroStockView registroStockView = new RegistroStockView();
    
    public static EdicionDeStockView edicionDeStockView = new EdicionDeStockView();
    
    public static AgregarStockView agregarStockView = new AgregarStockView();
    
    public static RestarStockView restarStockView = new RestarStockView();
    
    public static void mostrarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaStock = c.prepareStatement("SELECT * FROM stock");
            
            ResultSet resultadoConsultaStock = consultaStock.executeQuery();
            
            DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
            
            datos.setRowCount(0);
            
            ArrayList<Stock> listaStock = new ArrayList<Stock>();
            
            while(resultadoConsultaStock.next()){
                Stock stock = new Stock(resultadoConsultaStock.getInt("id"), resultadoConsultaStock.getString("codigo"), resultadoConsultaStock.getString("tipo"), resultadoConsultaStock.getString("espesor"), resultadoConsultaStock.getString("material"), resultadoConsultaStock.getInt("medida"), resultadoConsultaStock.getInt("cantidad"));
                
                listaStock.add(stock);
            }
            
            for(int i=0; i<listaStock.size(); i++){
                Stock stock = listaStock.get(i);
                
                Object[] filas = new Object[7];
                filas[0] = stock.getId();
                filas[1] = stock.getCodigo();
                filas[2] = stock.getTipo();
                filas[3] = stock.getEspesor();
                filas[4] = stock.getMaterial();
                filas[5] = stock.getMedida();
                filas[6] = stock.getCantidad();
                
                datos.addRow(filas);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void registrarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaStock = c.prepareStatement("SELECT * FROM stock");
            
            ResultSet resultadoConsultaStock = consultaStock.executeQuery();
            
            ArrayList<Stock> listaStock = new ArrayList<Stock>();
            
            while(resultadoConsultaStock.next()){
                Stock stock = new Stock(resultadoConsultaStock.getInt("id"), resultadoConsultaStock.getString("codigo"), resultadoConsultaStock.getString("tipo"), resultadoConsultaStock.getString("espesor"), resultadoConsultaStock.getString("material"), resultadoConsultaStock.getInt("medida"), resultadoConsultaStock.getInt("cantidad"));
                
                listaStock.add(stock);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<listaStock.size(); i++){
                Stock stock = listaStock.get(i);
                
                String codigo = stock.getCodigo();
                
                String codigoComparacion = registroStockView.getCodigoText().getText();
                
                if(codigo.equals(codigoComparacion)){
                    JOptionPane.showMessageDialog(null, "El codigo ya está registrado");
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            PreparedStatement registroStock = c.prepareStatement("INSERT INTO stock(codigo, tipo, espesor, material, medida, cantidad) VALUES(?, ?, ?, ?, ?, ?)");
            
            registroStock.setString(1, registroStockView.getCodigoText().getText());
            registroStock.setString(2, registroStockView.getTipoComboBox().getSelectedItem().toString());
            registroStock.setString(3, registroStockView.getEspesorText().getText());
            registroStock.setString(4, registroStockView.getMaterialComboBox().getSelectedItem().toString());
            registroStock.setInt(5, Integer.parseInt(registroStockView.getMedidaText().getText()));
            registroStock.setInt(6, Integer.parseInt(registroStockView.getCantidadText().getText()));
            
            if(!encontrado){
                registroStock.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void buscarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaStock = c.prepareStatement("SELECT * FROM stock");
            
            ResultSet resultadoConsultaStock = consultaStock.executeQuery();
            
            ArrayList<Stock> listaStock = new ArrayList<Stock>();
            
            while(resultadoConsultaStock.next()){
                Stock stock = new Stock(resultadoConsultaStock.getInt("id"), resultadoConsultaStock.getString("codigo"), resultadoConsultaStock.getString("tipo"), resultadoConsultaStock.getString("espesor"), resultadoConsultaStock.getString("material"), resultadoConsultaStock.getInt("medida"), resultadoConsultaStock.getInt("cantidad"));
                
                listaStock.add(stock);
            }
            
            boolean encontrado = false;
            
            for(int i=0; i<listaStock.size(); i++){
                Stock stock = listaStock.get(i);
                
                String codigo = stock.getCodigo();
                String tipo = stock.getTipo();
                
                String codigoComparacion = stockView.getCodigoText().getText();
                String tipoComparacion = stockView.getTipoComboBox().getSelectedItem().toString();
                
                if(codigoComparacion.equals(codigo) || tipoComparacion.equals(tipo)){
                    PreparedStatement buscarStock = c.prepareStatement("SELECT * FROM stock WHERE codigo = ? OR tipo = ?");
                    
                    buscarStock.setString(1, stockView.getCodigoText().getText());
                    buscarStock.setString(2, stockView.getTipoComboBox().getSelectedItem().toString());
                    
                    ResultSet resultadoBuscarStock = buscarStock.executeQuery();
                    
                    DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
                    
                    datos.setRowCount(0);
                    
                    ArrayList<Stock> lista = new ArrayList<Stock>();
                    
                    while(resultadoBuscarStock.next()){
                        Stock s = new Stock(resultadoBuscarStock.getInt("id"), resultadoBuscarStock.getString("codigo"), resultadoBuscarStock.getString("tipo"), resultadoBuscarStock.getString("espesor"), resultadoBuscarStock.getString("material"), resultadoBuscarStock.getInt("medida"), resultadoBuscarStock.getInt("cantidad"));
                        
                        lista.add(s);
                    }
                    
                    for(int j=0; j<lista.size(); j++){
                        Stock s = lista.get(j);
                        
                        Object[] filas = new Object[7];
                        filas[0] = s.getId();
                        filas[1] = s.getCodigo();
                        filas[2] = s.getTipo();
                        filas[3] = s.getEspesor();
                        filas[4] = s.getMaterial();
                        filas[5] = s.getMedida();
                        filas[6] = s.getCantidad();
                        
                        datos.addRow(filas);
                    }
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "No se encontró el material");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarEditarStock(){
        int numeroFilas = stockView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            String codigo = datos.getValueAt(numeroFilas, 1).toString();
            String tipo = datos.getValueAt(numeroFilas, 2).toString();
            String espesor = datos.getValueAt(numeroFilas, 3).toString();
            String material = datos.getValueAt(numeroFilas, 4).toString();
            String medida = datos.getValueAt(numeroFilas, 5).toString();
            String cantidad = datos.getValueAt(numeroFilas, 6).toString();
            
            edicionDeStockView.getIdStockText().setText(id);
            edicionDeStockView.getCodigoText().setText(codigo);
            edicionDeStockView.getTipoComboBox().setSelectedItem(tipo);
            edicionDeStockView.getEspesorText().setText(espesor);
            edicionDeStockView.getMaterialComboBox().setSelectedItem(material);
            edicionDeStockView.getMedidaText().setText(medida);
            edicionDeStockView.getCantidadText().setText(cantidad);
        }
    }
    
    public static void editarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement editarStock = c.prepareStatement("UPDATE stock SET codigo = ?, tipo = ?, espesor = ?, material = ?, medida = ?, cantidad = ? WHERE id = ?");
            
            editarStock.setString(1, edicionDeStockView.getCodigoText().getText());
            editarStock.setString(2, edicionDeStockView.getTipoComboBox().getSelectedItem().toString());
            editarStock.setString(3, edicionDeStockView.getEspesorText().getText());
            editarStock.setString(4, edicionDeStockView.getMaterialComboBox().getSelectedItem().toString());
            editarStock.setInt(5, Integer.parseInt(edicionDeStockView.getMedidaText().getText()));
            editarStock.setInt(6, Integer.parseInt(edicionDeStockView.getCantidadText().getText()));
            editarStock.setInt(7, Integer.parseInt(edicionDeStockView.getIdStockText().getText()));
            
            editarStock.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCamposAgregar(){
        int numeroFilas = stockView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            
            agregarStockView.getIdStockText().setText(id);
        }
    }
    
    public static void agregarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaStock = c.prepareStatement("SELECT * FROM stock WHERE id = ?");
            
            consultaStock.setInt(1, Integer.parseInt(agregarStockView.getIdStockText().getText()));
            
            ResultSet resultadoConsultaStock = consultaStock.executeQuery();
            
            resultadoConsultaStock.next();
            
            Stock stock = new Stock(resultadoConsultaStock.getInt("id"), resultadoConsultaStock.getString("codigo"), resultadoConsultaStock.getString("tipo"), resultadoConsultaStock.getString("espesor"), resultadoConsultaStock.getString("material"), resultadoConsultaStock.getInt("medida"), resultadoConsultaStock.getInt("cantidad"));
            
            int cantidad = stock.getCantidad();
            
            int agregado = Integer.parseInt(agregarStockView.getCantidadCañosText().getText());
            
            int nuevaCantidad = cantidad + agregado;
            
            PreparedStatement editarStock = c.prepareStatement("UPDATE stock SET cantidad = ? WHERE id = ?");
            
            editarStock.setInt(1, nuevaCantidad);
            editarStock.setInt(2, Integer.parseInt(agregarStockView.getIdStockText().getText()));
            
            editarStock.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void rellenarCamposRestar(){
        int numeroFilas = stockView.getjTable1().getSelectedRow();
        
        DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
        
        if(numeroFilas >= 0){
            String id = datos.getValueAt(numeroFilas, 0).toString();
            
            restarStockView.getIdStockText().setText(id);
        }
    }
    
    public static void restarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaStock = c.prepareStatement("SELECT * FROM stock WHERE id = ?");
            
            consultaStock.setInt(1, Integer.parseInt(restarStockView.getIdStockText().getText()));
            
            ResultSet resultadoConsultaStock = consultaStock.executeQuery();
            
            resultadoConsultaStock.next();
            
            Stock stock = new Stock(resultadoConsultaStock.getInt("id"), resultadoConsultaStock.getString("codigo"), resultadoConsultaStock.getString("tipo"), resultadoConsultaStock.getString("espesor"), resultadoConsultaStock.getString("material"), resultadoConsultaStock.getInt("medida"), resultadoConsultaStock.getInt("cantidad"));
            
            int cantidad = stock.getCantidad();
            
            int restar = Integer.parseInt(restarStockView.getCantidadCañosText().getText());
            
            int nuevaCantidad = cantidad - restar;
            
            PreparedStatement restarStock = c.prepareStatement("UPDATE stock SET cantidad = ? WHERE id = ?");
            
            restarStock.setInt(1, nuevaCantidad);
            restarStock.setInt(2, Integer.parseInt(restarStockView.getIdStockText().getText()));
            
            restarStock.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void borrarStock(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement borrarStock = c.prepareStatement("DELETE FROM stock WHERE id = ?");
            
            int numeroFilas = stockView.getjTable1().getSelectedRow();
            
            DefaultTableModel datos = (DefaultTableModel) stockView.getjTable1().getModel();
            
            if(numeroFilas >= 0){
                int id = Integer.parseInt(datos.getValueAt(numeroFilas, 0).toString());
                
                borrarStock.setInt(1, id);
                
                borrarStock.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
