/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.*;
import java.awt.BorderLayout;

/**
 *
 * @author ivand
 */
public class PrincipalController {
    public static PrincipalView principalView = new PrincipalView();
    
    public static void mostrar(){
        principalView.setVisible(true);
    }
    
    public static void ocultar(){
        principalView.setVisible(false);
    }
    
    public static void mostrarHome(){
        HomeController.homeView.setSize(750,410);
        HomeController.homeView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(HomeController.homeView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEmpleados(){
        EmpleadosController.empleadosView.setSize(750,440);
        EmpleadosController.empleadosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(EmpleadosController.empleadosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRegistroEmpleados(){
        EmpleadosController.registroEmpleadosView.setSize(750,440);
        EmpleadosController.registroEmpleadosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(EmpleadosController.registroEmpleadosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEdicionDeEmpleados(){
        EmpleadosController.edicionDeEmpleadosView.setSize(750,440);
        EmpleadosController.edicionDeEmpleadosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(EmpleadosController.edicionDeEmpleadosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarLiquidacion(){
        LiquidacionController.liquidacionView.setSize(750,440);
        LiquidacionController.liquidacionView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(LiquidacionController.liquidacionView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRegistroLiquidacion(){
        LiquidacionController.registroLiquidacionView.setSize(750,440);
        LiquidacionController.registroLiquidacionView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(LiquidacionController.registroLiquidacionView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEdicionDeLiquidacion(){
        LiquidacionController.edicionDeLiquidacionView.setSize(750,440);
        LiquidacionController.edicionDeLiquidacionView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(LiquidacionController.edicionDeLiquidacionView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarCalculadoraDeLiquidacion(){
        LiquidacionController.calculadoraDeLiquidacionView.setSize(750,440);
        LiquidacionController.calculadoraDeLiquidacionView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(LiquidacionController.calculadoraDeLiquidacionView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarPrestamos(){
        PrestamosController.prestamosView.setSize(750,440);
        PrestamosController.prestamosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PrestamosController.prestamosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRegistroPrestamos(){
        PrestamosController.registroPrestamosView.setSize(750,440);
        PrestamosController.registroPrestamosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PrestamosController.registroPrestamosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEdicionDePrestamos(){
        PrestamosController.edicionDePrestamosView.setSize(750,440);
        PrestamosController.edicionDePrestamosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PrestamosController.edicionDePrestamosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarAgregarPrestamos(){
        PrestamosController.agregarPrestamosView.setSize(750,440);
        PrestamosController.agregarPrestamosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PrestamosController.agregarPrestamosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarDevolverPrestamos(){
        PrestamosController.devolverPrestamosView.setSize(750,440);
        PrestamosController.devolverPrestamosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PrestamosController.devolverPrestamosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarStock(){
        StockController.stockView.setSize(750,440);
        StockController.stockView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(StockController.stockView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRegistroStock(){
        StockController.registroStockView.setSize(750,440);
        StockController.registroStockView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(StockController.registroStockView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEdicionDeStock(){
        StockController.edicionDeStockView.setSize(750,440);
        StockController.edicionDeStockView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(StockController.edicionDeStockView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarAgregarStock(){
        StockController.agregarStockView.setSize(750,440);
        StockController.agregarStockView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(StockController.agregarStockView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRestarStock(){
        StockController.restarStockView.setSize(750,440);
        StockController.restarStockView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(StockController.restarStockView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarPresupuesto(){
        PresupuestosController.presupuestosView.setSize(750,440);
        PresupuestosController.presupuestosView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PresupuestosController.presupuestosView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarRegistroPresupuesto(){
        PresupuestosController.registroPresupuestoView.setSize(750,440);
        PresupuestosController.registroPresupuestoView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PresupuestosController.registroPresupuestoView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
    
    public static void mostrarEdicionDePresupuesto(){
        PresupuestosController.edicionDePresupuestoView.setSize(750,440);
        PresupuestosController.edicionDePresupuestoView.setLocation(0,0);
        
        principalView.getContent().removeAll();
        principalView.getContent().add(PresupuestosController.edicionDePresupuestoView, BorderLayout.CENTER);
        principalView.getContent().revalidate();
        principalView.getContent().repaint();
    }
}
