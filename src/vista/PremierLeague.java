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

public class PremierLeague extends JPanel{

	private Principal principal;
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JLabel united;
	public JLabel city;
	public JLabel arsenal;
	public JLabel liverpool;
	public JLabel villa;
	
	public JLabel precio_united;
	public JLabel precio_city;
	public JLabel precio_arsenal;
	public JLabel precio_liverpool;
	public JLabel precio_villa;
	
	public JButton boton_united;
	public JButton boton_city;
	public JButton boton_arsenal;
	public JButton boton_liverpool;
	public JButton boton_villa;
	
	public JLabel camisetas;
	
	public JButton carrito;
	public JButton volver;
	private Conexion conexion = new Conexion();
	private Sonido sonido = new Sonido();

	public PremierLeague(Principal principal) {
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
        united = new JLabel("Man. United");
        united.setFont(new Font("Arial", Font.BOLD, 25));
        united.setForeground(Color.BLACK);
        united.setBounds(50, 175, 175, 115);
        add(united);
        
        city = new JLabel("Man. City");
        city.setFont(new Font("Arial", Font.BOLD, 25));
        city.setForeground(Color.BLACK);
        city.setBounds(245, 175, 175, 115);
        add(city);
        
        arsenal = new JLabel("Arsenal");
        arsenal.setFont(new Font("Arial", Font.BOLD, 25));
        arsenal.setForeground(Color.BLACK);
        arsenal.setBounds(438, 175, 225, 115);
        add(arsenal);
        
        liverpool = new JLabel("Liverpool");
        liverpool.setFont(new Font("Arial", Font.BOLD, 25));
        liverpool.setForeground(Color.BLACK);
        liverpool.setBounds(617, 175, 175, 115);
        add(liverpool);
        
        villa = new JLabel("Aston Villa");
        villa.setFont(new Font("Arial", Font.BOLD, 25));
        villa.setForeground(Color.BLACK);
        villa.setBounds(805, 175, 175, 115);
        add(villa);
        
        //Foto camisetas
        ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas_premierleague.png"));
        camisetas = new JLabel(foto_camisetas);
        camisetas.setBounds(30, 260, 925, 218);
        add(camisetas);
        
        //Precio camisetas
        precio_united = new JLabel("95€");
        precio_united.setFont(new Font("Arial", Font.BOLD, 25));
        precio_united.setForeground(Color.BLACK);
        precio_united.setBounds(95, 475, 100, 60);
        add(precio_united);
        
        precio_city = new JLabel("85€");
        precio_city.setFont(new Font("Arial", Font.BOLD, 25));
        precio_city.setForeground(Color.BLACK);
        precio_city.setBounds(275, 475, 100, 60);
        add(precio_city);
        
        precio_arsenal = new JLabel("90€");
        precio_arsenal.setFont(new Font("Arial", Font.BOLD, 25));
        precio_arsenal.setForeground(Color.BLACK);
        precio_arsenal.setBounds(465, 475, 100, 60);
        add(precio_arsenal);
        
        precio_liverpool = new JLabel("80€");
        precio_liverpool.setFont(new Font("Arial", Font.BOLD, 25));
        precio_liverpool.setForeground(Color.BLACK);
        precio_liverpool.setBounds(650, 475, 100, 60);
        add(precio_liverpool);
        
        precio_villa = new JLabel("70€");
        precio_villa.setFont(new Font("Arial", Font.BOLD, 25));
        precio_villa.setForeground(Color.BLACK);
        precio_villa.setBounds(835, 475, 100, 60);
        add(precio_villa);
        
        //Botones añadir al carrito
        boton_united = new JButton("AÑADIR AL CARRITO");
        boton_united.setFont(new Font("Arial", Font.BOLD, 12));
        boton_united.setBorder(new LineBorder(Color.BLACK, 2));
        boton_united.setBackground(new Color(207, 207, 207));
        boton_united.setForeground(Color.BLACK);
        boton_united.setBounds(50, 550, 140, 60);
        add(boton_united);
        
        boton_city = new JButton("AÑADIR AL CARRITO");
        boton_city.setFont(new Font("Arial", Font.BOLD, 12));
        boton_city.setBorder(new LineBorder(Color.BLACK, 2));
        boton_city.setBackground(new Color(207, 207, 207));
        boton_city.setForeground(Color.BLACK);
        boton_city.setBounds(235, 550, 140, 60);
        add(boton_city);
        
        boton_arsenal = new JButton("AÑADIR AL CARRITO");
        boton_arsenal.setFont(new Font("Arial", Font.BOLD, 12));
        boton_arsenal.setBorder(new LineBorder(Color.BLACK, 2));
        boton_arsenal.setBackground(new Color(207, 207, 207));
        boton_arsenal.setForeground(Color.BLACK);
        boton_arsenal.setBounds(420, 550, 140, 60);
        add(boton_arsenal);
        
        boton_liverpool = new JButton("AÑADIR AL CARRITO");
        boton_liverpool.setFont(new Font("Arial", Font.BOLD, 12));
        boton_liverpool.setBorder(new LineBorder(Color.BLACK, 2));
        boton_liverpool.setBackground(new Color(207, 207, 207));
        boton_liverpool.setForeground(Color.BLACK);
        boton_liverpool.setBounds(605, 550, 140, 60);
        add(boton_liverpool);
        
        boton_villa = new JButton("AÑADIR AL CARRITO");
        boton_villa.setFont(new Font("Arial", Font.BOLD, 12));
        boton_villa.setBorder(new LineBorder(Color.BLACK, 2));
        boton_villa.setBackground(new Color(207, 207, 207));
        boton_villa.setForeground(Color.BLACK);
        boton_villa.setBounds(790, 550, 140, 60);
        add(boton_villa);
        
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
        
        ratonEncima(boton_united);
        ratonEncima(boton_city);
        ratonEncima(boton_arsenal);
        ratonEncima(boton_liverpool);
        ratonEncima(boton_villa);
        
        ratonEncima2(carrito);
        ratonEncima2(volver);
        
     // Acción de los botones
     		boton_united.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(6); //id producto y cantidad
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_city.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(7);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_arsenal.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(8);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_liverpool.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(9);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_villa.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(10);
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
