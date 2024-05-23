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

public class Bundesliga extends JPanel{

	private Principal principal;
	
	public PanelImagen panelFondo;

	public JLabel titulo;
	public JLabel logo;
	
	public JLabel bayern;
	public JLabel dortmund;
	public JLabel leverkusen;
	public JLabel leipzig;
	public JLabel frankfurt;
	
	public JLabel precio_bayern;
	public JLabel precio_dortmund;
	public JLabel precio_leverkusen;
	public JLabel precio_leipzig;
	public JLabel precio_frankfurt;
	
	public JButton boton_bayern;
	public JButton boton_dortmund;
	public JButton boton_leverkusen;
	public JButton boton_leipzig;
	public JButton boton_frankfurt;
	
	public JLabel camisetas;
	
	public JButton carrito;
	public JButton volver;
	private Conexion conexion = new Conexion();
	private Sonido sonido = new Sonido();
	
	public Bundesliga(Principal principal) {
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
        bayern = new JLabel("FC Bayern");
        bayern.setFont(new Font("Arial", Font.BOLD, 25));
        bayern.setForeground(Color.BLACK);
        bayern.setBounds(65, 175, 175, 115);
        add(bayern);
        
        dortmund = new JLabel("B. Dortmund");
        dortmund.setFont(new Font("Arial", Font.BOLD, 25));
        dortmund.setForeground(Color.BLACK);
        dortmund.setBounds(232, 175, 175, 115);
        add(dortmund);
        
        leverkusen = new JLabel("B. Leverkusen");
        leverkusen.setFont(new Font("Arial", Font.BOLD, 25));
        leverkusen.setForeground(Color.BLACK);
        leverkusen.setBounds(410, 175, 225, 115);
        add(leverkusen);
        
        leipzig = new JLabel("RB Leipzig");
        leipzig.setFont(new Font("Arial", Font.BOLD, 25));
        leipzig.setForeground(Color.BLACK);
        leipzig.setBounds(612, 175, 175, 115);
        add(leipzig);
        
        frankfurt = new JLabel("E. Frankfurt");
        frankfurt.setFont(new Font("Arial", Font.BOLD, 25));
        frankfurt.setForeground(Color.BLACK);
        frankfurt.setBounds(797, 175, 175, 115);
        add(frankfurt);
        
        //Foto camisetas
        ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas_bundesliga.png"));
        camisetas = new JLabel(foto_camisetas);
        camisetas.setBounds(35, 260, 925, 219);
        add(camisetas);
        
        //Precio camisetas
        precio_bayern = new JLabel("95€");
        precio_bayern.setFont(new Font("Arial", Font.BOLD, 25));
        precio_bayern.setForeground(Color.BLACK);
        precio_bayern.setBounds(105, 480, 100, 60);
        add(precio_bayern);
        
        precio_dortmund = new JLabel("85€");
        precio_dortmund.setFont(new Font("Arial", Font.BOLD, 25));
        precio_dortmund.setForeground(Color.BLACK);
        precio_dortmund.setBounds(290, 480, 100, 60);
        add(precio_dortmund);
        
        precio_leverkusen = new JLabel("75€");
        precio_leverkusen.setFont(new Font("Arial", Font.BOLD, 25));
        precio_leverkusen.setForeground(Color.BLACK);
        precio_leverkusen.setBounds(470, 480, 100, 60);
        add(precio_leverkusen);
        
        precio_leipzig = new JLabel("70€");
        precio_leipzig.setFont(new Font("Arial", Font.BOLD, 25));
        precio_leipzig.setForeground(Color.BLACK);
        precio_leipzig.setBounds(660, 480, 100, 60);
        add(precio_leipzig);
        
        precio_frankfurt = new JLabel("65€");
        precio_frankfurt.setFont(new Font("Arial", Font.BOLD, 25));
        precio_frankfurt.setForeground(Color.BLACK);
        precio_frankfurt.setBounds(845, 480, 100, 60);
        add(precio_frankfurt);
        
        //Botones añadir al carrito
        boton_bayern = new JButton("AÑADIR AL CARRITO");
        boton_bayern.setFont(new Font("Arial", Font.BOLD, 12));
        boton_bayern.setBorder(new LineBorder(Color.BLACK, 2));
        boton_bayern.setBackground(new Color(207, 207, 207));
        boton_bayern.setForeground(Color.BLACK);
        boton_bayern.setBounds(50, 550, 140, 60);
        add(boton_bayern);
        
        boton_dortmund = new JButton("AÑADIR AL CARRITO");
        boton_dortmund.setFont(new Font("Arial", Font.BOLD, 12));
        boton_dortmund.setBorder(new LineBorder(Color.BLACK, 2));
        boton_dortmund.setBackground(new Color(207, 207, 207));
        boton_dortmund.setForeground(Color.BLACK);
        boton_dortmund.setBounds(235, 550, 140, 60);
        add(boton_dortmund);
        
        boton_leverkusen = new JButton("AÑADIR AL CARRITO");
        boton_leverkusen.setFont(new Font("Arial", Font.BOLD, 12));
        boton_leverkusen.setBorder(new LineBorder(Color.BLACK, 2));
        boton_leverkusen.setBackground(new Color(207, 207, 207));
        boton_leverkusen.setForeground(Color.BLACK);
        boton_leverkusen.setBounds(420, 550, 140, 60);
        add(boton_leverkusen);
        
        boton_leipzig = new JButton("AÑADIR AL CARRITO");
        boton_leipzig.setFont(new Font("Arial", Font.BOLD, 12));
        boton_leipzig.setBorder(new LineBorder(Color.BLACK, 2));
        boton_leipzig.setBackground(new Color(207, 207, 207));
        boton_leipzig.setForeground(Color.BLACK);
        boton_leipzig.setBounds(605, 550, 140, 60);
        add(boton_leipzig);
        
        boton_frankfurt = new JButton("AÑADIR AL CARRITO");
        boton_frankfurt.setFont(new Font("Arial", Font.BOLD, 12));
        boton_frankfurt.setBorder(new LineBorder(Color.BLACK, 2));
        boton_frankfurt.setBackground(new Color(207, 207, 207));
        boton_frankfurt.setForeground(Color.BLACK);
        boton_frankfurt.setBounds(790, 550, 140, 60);
        add(boton_frankfurt);
        
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
        
        ratonEncima(boton_bayern);
        ratonEncima(boton_dortmund);
        ratonEncima(boton_leverkusen);
        ratonEncima(boton_leipzig);
        ratonEncima(boton_frankfurt);
        
        ratonEncima2(carrito);
        ratonEncima2(volver);
        
     // Acción de los botones
     		boton_bayern.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(16); //id producto y cantidad
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_dortmund.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(17);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_leverkusen.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(18);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_leipzig.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(19);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     			}
     		});

     		boton_frankfurt.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				try {
     					sonido.sonidoCompra();
     					conexion.aniadirCarrito(20);
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
