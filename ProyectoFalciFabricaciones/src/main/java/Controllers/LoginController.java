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

/**
 *
 * @author ivand
 */
public class LoginController {
    public static LoginView loginView = new LoginView();
    
    public static void mostrar(){
        loginView.setVisible(true);
    }
    
    public static void ocultar(){
        loginView.setVisible(false);
    }
    
    public static void validar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_falci_fabricaciones", "root", "lasmesadas2016");
            
            PreparedStatement consultaAdministradores = c.prepareStatement("SELECT * FROM administradores");
            
            ResultSet resultadoConsultaAdministradores = consultaAdministradores.executeQuery();
            
            ArrayList<Administrador> administradores = new ArrayList<Administrador>();
            
            while(resultadoConsultaAdministradores.next()){
                Administrador administrador = new Administrador(resultadoConsultaAdministradores.getString("usuario"), resultadoConsultaAdministradores.getString("clave"));
                
                administradores.add(administrador);
            }
            
            boolean encontrado = false;
            
            String usuarioIngresado = loginView.getUsuarioText().getText();
            String claveIngresada = loginView.getClaveText().getText();
            
            for(int i=0; i<administradores.size(); i++){
                Administrador administrador = administradores.get(i);
                
                administrador.toString();
                
                String usuario = administrador.getUsuario();
                String clave = administrador.getClave();
                
                if(usuario.equals(usuarioIngresado) && clave.equals(claveIngresada)){
                    PrincipalController.mostrar();
                    LoginController.ocultar();
                    
                    encontrado = true;
                    
                    break;
                }
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "Datos incorrectos!");
            }
        }catch(Exception e){
            System.out.println();
        }
    }
}
