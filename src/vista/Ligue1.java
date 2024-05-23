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

public class Ligue1 extends JPanel{

	private Principal principal;
	
	public PanelImagen panelFondo;

	public JLabel titulo;
	public JLabel logo;
	
	public JLabel lyon;
	public JLabel monaco;
	public JLabel psg;
	public JLabel marsella;
	public JLabel rennes;
	
	public JLabel precio_lyon;
	public JLabel precio_monaco;
	public JLabel precio_psg;
	public JLabel precio_marsella;
	public JLabel precio_rennes;
	
	public JButton boton_lyon;
	public JButton boton_monaco;
	public JButton boton_psg;
	public JButton boton_marsella;
	public JButton boton_rennes;
	
	public JLabel camisetas;
	
	public JButton carrito;
	public JButton volver;
	private Conexion conexion = new Conexion();
	private Sonido sonido = new Sonido();
	
	public Ligue1(Principal principal) {
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
        lyon = new JLabel("OL. Lyon");
        lyon.setFont(new Font("Arial", Font.BOLD, 25));
        lyon.setForeground(Color.BLACK);
        lyon.setBounds(65, 175, 175, 115);
        add(lyon);
        
        monaco = new JLabel("AS Monaco");
        monaco.setFont(new Font("Arial", Font.BOLD, 25));
        monaco.setForeground(Color.BLACK);
        monaco.setBounds(232, 175, 175, 115);
        add(monaco);
        
        psg = new JLabel("PSG");
        psg.setFont(new Font("Arial", Font.BOLD, 25));
        psg.setForeground(Color.BLACK);
        psg.setBounds(455, 175, 225, 115);
        add(psg);
        
        marsella = new JLabel("OL. Marsella");
        marsella.setFont(new Font("Arial", Font.BOLD, 25));
        marsella.setForeground(Color.BLACK);
        marsella.setBounds(595, 175, 175, 115);
        add(marsella);
        
        rennes = new JLabel("Rennes");
        rennes.setFont(new Font("Arial", Font.BOLD, 25));
        rennes.setForeground(Color.BLACK);
        rennes.setBounds(820, 175, 175, 115);
        add(rennes);
        
        //Foto camisetas
        ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas_ligue1.png"));
        camisetas = new JLabel(foto_camisetas);
        camisetas.setBounds(25, 255, 925, 237);
        add(camisetas);
        
        //Precio camisetas
        precio_lyon = new JLabel("95€");
        precio_lyon.setFont(new Font("Arial", Font.BOLD, 25));
        precio_lyon.setForeground(Color.BLACK);
        precio_lyon.setBounds(105, 482, 100, 60);
        add(precio_lyon);
        
        precio_monaco = new JLabel("80€");
        precio_monaco.setFont(new Font("Arial", Font.BOLD, 25));
        precio_monaco.setForeground(Color.BLACK);
        precio_monaco.setBounds(290, 482, 100, 60);
        add(precio_monaco);
        
        precio_psg = new JLabel("120€");
        precio_psg.setFont(new Font("Arial", Font.BOLD, 25));
        precio_psg.setForeground(Color.BLACK);
        precio_psg.setBounds(470, 482, 100, 60);
        add(precio_psg);
        
        precio_marsella = new JLabel("70€");
        precio_marsella.setFont(new Font("Arial", Font.BOLD, 25));
        precio_marsella.setForeground(Color.BLACK);
        precio_marsella.setBounds(660, 482, 100, 60);
        add(precio_marsella);
        
        precio_rennes = new JLabel("60€");
        precio_rennes.setFont(new Font("Arial", Font.BOLD, 25));
        precio_rennes.setForeground(Color.BLACK);
        precio_rennes.setBounds(845, 482, 100, 60);
        add(precio_rennes);
        
        //Botones añadir al carrito
        boton_lyon = new JButton("AÑADIR AL CARRITO");
        boton_lyon.setFont(new Font("Arial", Font.BOLD, 12));
        boton_lyon.setBorder(new LineBorder(Color.BLACK, 2));
        boton_lyon.setBackground(new Color(207, 207, 207));
        boton_lyon.setForeground(Color.BLACK);
        boton_lyon.setBounds(50, 550, 140, 60);
        add(boton_lyon);
        
        boton_monaco = new JButton("AÑADIR AL CARRITO");
        boton_monaco.setFont(new Font("Arial", Font.BOLD, 12));
        boton_monaco.setBorder(new LineBorder(Color.BLACK, 2));
        boton_monaco.setBackground(new Color(207, 207, 207));
        boton_monaco.setForeground(Color.BLACK);
        boton_monaco.setBounds(235, 550, 140, 60);
        add(boton_monaco);
        
        boton_psg = new JButton("AÑADIR AL CARRITO");
        boton_psg.setFont(new Font("Arial", Font.BOLD, 12));
        boton_psg.setBorder(new LineBorder(Color.BLACK, 2));
        boton_psg.setBackground(new Color(207, 207, 207));
        boton_psg.setForeground(Color.BLACK);
        boton_psg.setBounds(420, 550, 140, 60);
        add(boton_psg);
        
        boton_marsella = new JButton("AÑADIR AL CARRITO");
        boton_marsella.setFont(new Font("Arial", Font.BOLD, 12));
        boton_marsella.setBorder(new LineBorder(Color.BLACK, 2));
        boton_marsella.setBackground(new Color(207, 207, 207));
        boton_marsella.setForeground(Color.BLACK);
        boton_marsella.setBounds(605, 550, 140, 60);
        add(boton_marsella);
        
        boton_rennes = new JButton("AÑADIR AL CARRITO");
        boton_rennes.setFont(new Font("Arial", Font.BOLD, 12));
        boton_rennes.setBorder(new LineBorder(Color.BLACK, 2));
        boton_rennes.setBackground(new Color(207, 207, 207));
        boton_rennes.setForeground(Color.BLACK);
        boton_rennes.setBounds(790, 550, 140, 60);
        add(boton_rennes);
        
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
        
        ratonEncima(boton_lyon);
        ratonEncima(boton_monaco);
        ratonEncima(boton_psg);
        ratonEncima(boton_marsella);
        ratonEncima(boton_rennes);
        
        ratonEncima2(carrito);
        ratonEncima2(volver);
        
     // Acción de los botones
     		boton_lyon.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(21); //id producto y cantidad
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_monaco.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(22);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_psg.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(23);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_marsella.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(24);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_rennes.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(25);
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
