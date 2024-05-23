package vista;

import java.awt.*;
import java.sql.Connection;

import javax.swing.*;

import bbdd.Conexion;


public class CarritoFrame extends JFrame{
	
	private Carrito JPanelCarrito = new Carrito();
	
    public CarritoFrame() {
    	setSize(1000,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("La Redonda");
        
        add(JPanelCarrito);
    
        JPanelCarrito.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }
    
	public static void main(String[] args) {
		new Principal();
	}

}
