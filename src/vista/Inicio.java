package vista;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import bbdd.Conexion;

public class Inicio extends JPanel{
	
	private Principal principal;

	public PanelImagen panelFondo;

	public JLabel titulo;
	public JLabel logo;
    public JButton iniciarSesion;
    public JButton Registrarse;
    
    public Inicio(Principal principal) {
    	this.principal = principal;
    	
    	setLayout(null);
    	
    	//Título
    	titulo = new JLabel("La Redonda");
        titulo.setFont(new Font("Arial", Font.BOLD, 70));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(275, 75, 450, 60);
        add(titulo);
        
        //Imagen
        ImageIcon logo_imagen = new ImageIcon(getClass().getResource("/imagenes/logo.jpg"));
        logo = new JLabel(logo_imagen);
        logo.setBounds(550, 275, 300, 300);
        add(logo);
        
        //Botón iniciar sesión
        iniciarSesion = new JButton("INICIAR SESIÓN");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
        iniciarSesion.setBorder(new LineBorder(Color.BLACK, 2));
        iniciarSesion.setBackground(new Color(241, 39, 39));
        iniciarSesion.setForeground(Color.BLACK);
        iniciarSesion.setBounds(175, 275, 250, 100);
        add(iniciarSesion);
        
        //Botón registrarse
        Registrarse = new JButton("REGISTRARSE");
        Registrarse.setFont(new Font("Arial", Font.BOLD, 20));
        Registrarse.setBorder(new LineBorder(Color.BLACK, 2));
        Registrarse.setBackground(new Color(241, 39, 39));
        Registrarse.setForeground(Color.BLACK);
        Registrarse.setBounds(175, 475, 250, 100);
        add(Registrarse);
        
        //Imagen fondo
        panelFondo = new PanelImagen();
        panelFondo.setBounds(0, 0, 1000, 750);
        add(panelFondo);
        
        
        //Llamo al método con los dos botones, así uso un solo método para todos los botones
        ratonEncima(iniciarSesion);
        ratonEncima(Registrarse);
        
        
        iniciarSesion.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.inicioSesion);
        	}
        	
        });
        
        Registrarse.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.registrar);
        	}
        	
        });
    }
     	
    private void ratonEncima(JButton boton){
		boton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(241, 39, 39));
	        	boton.setBorder(new LineBorder(Color.BLACK, 2));
	        	boton.setForeground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(Color.BLACK);
	        	boton.setBorder(new LineBorder(Color.RED, 2));
	        	boton.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(241, 39, 39));
	        	boton.setBorder(new LineBorder(Color.BLACK, 2));
	        	boton.setForeground(Color.BLACK);
			}
			 
		 });
	}
}
