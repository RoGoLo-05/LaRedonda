package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bbdd.Conexion;
import sonido.Sonido;

public class SerieA extends JPanel{

	private Principal principal;
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JLabel milan;
	public JLabel inter;
	public JLabel juventus;
	public JLabel roma;
	public JLabel fiorentina;
	
	public JLabel precio_milan;
	public JLabel precio_inter;
	public JLabel precio_juventus;
	public JLabel precio_roma;
	public JLabel precio_fiorentina;
	
	public JButton boton_milan;
	public JButton boton_inter;
	public JButton boton_juventus;
	public JButton boton_roma;
	public JButton boton_fiorentina;
	
	public JLabel camisetas;
	
	public JButton carrito;
	public JButton volver;
	private Conexion conexion = new Conexion();
	private Sonido sonido = new Sonido();

	public SerieA(Principal principal) {
		this.principal = principal;
		
		setLayout(null);
		
		//Título
    	titulo = new JLabel("La Redonda");
        titulo.setFont(new Font("Arial", Font.BOLD, 70));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(200, 75, 450, 60);
        add(titulo);
        
        //Imagen
        ImageIcon logo_imagen = new ImageIcon(getClass().getResource("/imagenes/logo_pequeño.jpg"));
        logo = new JLabel(logo_imagen);
        logo.setBounds(40, 40, 125, 125);
        add(logo);
        
        //Equipos
        milan = new JLabel("AC Milan");
        milan.setFont(new Font("Arial", Font.BOLD, 25));
        milan.setForeground(Color.BLACK);
        milan.setBounds(65, 175, 175, 115);
        add(milan);
        
        inter = new JLabel("Inter de Milan");
        inter.setFont(new Font("Arial", Font.BOLD, 25));
        inter.setForeground(Color.BLACK);
        inter.setBounds(228, 175, 175, 115);
        add(inter);
        
        juventus = new JLabel("Juventus");
        juventus.setFont(new Font("Arial", Font.BOLD, 25));
        juventus.setForeground(Color.BLACK);
        juventus.setBounds(432, 175, 225, 115);
        add(juventus);
        
        roma = new JLabel("AS Roma");
        roma.setFont(new Font("Arial", Font.BOLD, 25));
        roma.setForeground(Color.BLACK);
        roma.setBounds(612, 175, 175, 115);
        add(roma);
        
        fiorentina = new JLabel("Fiorentina");
        fiorentina.setFont(new Font("Arial", Font.BOLD, 25));
        fiorentina.setForeground(Color.BLACK);
        fiorentina.setBounds(797, 175, 175, 115);
        add(fiorentina);
        
        //Foto camisetas
        ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas_seriea.png"));
        camisetas = new JLabel(foto_camisetas);
        camisetas.setBounds(35, 250, 925, 237);
        add(camisetas);
        
        //Precio camisetas
        precio_milan = new JLabel("100€");
        precio_milan.setFont(new Font("Arial", Font.BOLD, 25));
        precio_milan.setForeground(Color.BLACK);
        precio_milan.setBounds(95, 475, 100, 60);
        add(precio_milan);
        
        precio_inter = new JLabel("90€");
        precio_inter.setFont(new Font("Arial", Font.BOLD, 25));
        precio_inter.setForeground(Color.BLACK);
        precio_inter.setBounds(280, 475, 100, 60);
        add(precio_inter);
        
        precio_juventus = new JLabel("110€");
        precio_juventus.setFont(new Font("Arial", Font.BOLD, 25));
        precio_juventus.setForeground(Color.BLACK);
        precio_juventus.setBounds(460, 475, 100, 60);
        add(precio_juventus);
        
        precio_roma = new JLabel("80€");
        precio_roma.setFont(new Font("Arial", Font.BOLD, 25));
        precio_roma.setForeground(Color.BLACK);
        precio_roma.setBounds(650, 475, 100, 60);
        add(precio_roma);
        
        precio_fiorentina = new JLabel("95€");
        precio_fiorentina.setFont(new Font("Arial", Font.BOLD, 25));
        precio_fiorentina.setForeground(Color.BLACK);
        precio_fiorentina.setBounds(835, 475, 100, 60);
        add(precio_fiorentina);
        
        //Botones añadir al carrito
        boton_milan = new JButton("AÑADIR AL CARRITO");
        boton_milan.setFont(new Font("Arial", Font.BOLD, 12));
        boton_milan.setBorder(new LineBorder(Color.BLACK, 2));
        boton_milan.setBackground(new Color(207, 207, 207));
        boton_milan.setForeground(Color.BLACK);
        boton_milan.setBounds(50, 550, 140, 60);
        add(boton_milan);
        
        boton_inter = new JButton("AÑADIR AL CARRITO");
        boton_inter.setFont(new Font("Arial", Font.BOLD, 12));
        boton_inter.setBorder(new LineBorder(Color.BLACK, 2));
        boton_inter.setBackground(new Color(207, 207, 207));
        boton_inter.setForeground(Color.BLACK);
        boton_inter.setBounds(235, 550, 140, 60);
        add(boton_inter);
        
        boton_juventus = new JButton("AÑADIR AL CARRITO");
        boton_juventus.setFont(new Font("Arial", Font.BOLD, 12));
        boton_juventus.setBorder(new LineBorder(Color.BLACK, 2));
        boton_juventus.setBackground(new Color(207, 207, 207));
        boton_juventus.setForeground(Color.BLACK);
        boton_juventus.setBounds(420, 550, 140, 60);
        add(boton_juventus);
        
        boton_roma = new JButton("AÑADIR AL CARRITO");
        boton_roma.setFont(new Font("Arial", Font.BOLD, 12));
        boton_roma.setBorder(new LineBorder(Color.BLACK, 2));
        boton_roma.setBackground(new Color(207, 207, 207));
        boton_roma.setForeground(Color.BLACK);
        boton_roma.setBounds(605, 550, 140, 60);
        add(boton_roma);
        
        boton_fiorentina = new JButton("AÑADIR AL CARRITO");
        boton_fiorentina.setFont(new Font("Arial", Font.BOLD, 12));
        boton_fiorentina.setBorder(new LineBorder(Color.BLACK, 2));
        boton_fiorentina.setBackground(new Color(207, 207, 207));
        boton_fiorentina.setForeground(Color.BLACK);
        boton_fiorentina.setBounds(790, 550, 140, 60);
        add(boton_fiorentina);
        
        //Botón carrito
        carrito = new JButton("CARRITO");
        carrito.setFont(new Font("Arial", Font.PLAIN, 18));
        carrito.setBorder(new LineBorder(Color.BLACK, 2));
        carrito.setBackground(new Color(167, 167, 167));
        carrito.setForeground(Color.BLACK);
        carrito.setBounds(660, 75, 125, 60);
        add(carrito);
        
        //Botón volver
        volver = new JButton("VOLVER");
        volver.setFont(new Font("Arial", Font.PLAIN, 18));
        volver.setBorder(new LineBorder(Color.BLACK, 2));
        volver.setBackground(new Color(167, 167, 167));
        volver.setForeground(Color.BLACK);
        volver.setBounds(815, 75, 125, 60);
        add(volver);
		
		//Imagen fondo
        panelFondo = new PanelImagen();
        panelFondo.setBounds(0, 0, 1000, 750);
        add(panelFondo);
	 
        ratonEncima(boton_milan);
        ratonEncima(boton_inter);
        ratonEncima(boton_juventus);
        ratonEncima(boton_roma);
        ratonEncima(boton_fiorentina);
        
        ratonEncima2(carrito);
        ratonEncima2(volver);
        
     // Acción de los botones
     		boton_milan.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(11); //id producto y cantidad
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_inter.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(12);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_juventus.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(13);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_roma.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(14);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_fiorentina.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(15);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});
        
        carrito.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        		CarritoFrame carritoFrame = new CarritoFrame();
				carritoFrame.setVisible(true);
        	}
        	
        });
        
        volver.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.home);
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
				boton.setBackground(new Color(207, 207, 207));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(241, 39, 39));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(207, 207, 207));
			}
			 
		 });
	}
	
	private void ratonEncima2(JButton boton){
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
				boton.setBackground(new Color(167, 167, 167));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(220, 96, 96));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				boton.setBackground(new Color(167, 167, 167));
			}
			 
		 });
	}

}
