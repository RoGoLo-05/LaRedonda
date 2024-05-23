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

public class LaLiga extends JPanel{

	private Principal principal;

	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;

	public JLabel madrid;
	public JLabel barcelona;
	public JLabel atletico;
	public JLabel sevilla;
	public JLabel betis;

	public JLabel precio_madrid;
	public JLabel precio_barcelona;
	public JLabel precio_atletico;
	public JLabel precio_sevilla;
	public JLabel precio_betis;

	public JButton boton_madrid;
	public JButton boton_barcelona;
	public JButton boton_atletico;
	public JButton boton_sevilla;
	public JButton boton_betis;

	public JLabel camisetas;

	public JButton carrito;
	public JButton volver;
	private Conexion conexion = new Conexion();
	
	private Sonido sonido = new Sonido();
	
	
	public LaLiga(Principal principal) {
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
		madrid = new JLabel("Real Madrid");
		madrid.setFont(new Font("Arial", Font.BOLD, 25));
		madrid.setForeground(Color.BLACK);
		madrid.setBounds(50, 175, 175, 115);
		add(madrid);

		barcelona = new JLabel("FC Barcelona");
		barcelona.setFont(new Font("Arial", Font.BOLD, 25));
		barcelona.setForeground(Color.BLACK);
		barcelona.setBounds(220, 175, 175, 115);
		add(barcelona);

		atletico = new JLabel("Atlético de M.");
		atletico.setFont(new Font("Arial", Font.BOLD, 25));
		atletico.setForeground(Color.BLACK);
		atletico.setBounds(407, 175, 225, 115);
		add(atletico);

		sevilla = new JLabel("Sevilla FC");
		sevilla.setFont(new Font("Arial", Font.BOLD, 25));
		sevilla.setForeground(Color.BLACK);
		sevilla.setBounds(617, 175, 175, 115);
		add(sevilla);

		betis = new JLabel("Real Betis");
		betis.setFont(new Font("Arial", Font.BOLD, 25));
		betis.setForeground(Color.BLACK);
		betis.setBounds(805, 175, 175, 115);
		add(betis);

		//Foto camisetas
		ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas_laliga.png"));
		camisetas = new JLabel(foto_camisetas);
		camisetas.setBounds(30, 250, 925, 230);
		add(camisetas);

		//Precio camisetas
		precio_madrid = new JLabel("120€");
		precio_madrid.setFont(new Font("Arial", Font.BOLD, 25));
		precio_madrid.setForeground(Color.BLACK);
		precio_madrid.setBounds(95, 475, 100, 60);
		add(precio_madrid);

		precio_barcelona = new JLabel("115€");
		precio_barcelona.setFont(new Font("Arial", Font.BOLD, 25));
		precio_barcelona.setForeground(Color.BLACK);
		precio_barcelona.setBounds(275, 475, 100, 60);
		add(precio_barcelona);

		precio_atletico = new JLabel("80€");
		precio_atletico.setFont(new Font("Arial", Font.BOLD, 25));
		precio_atletico.setForeground(Color.BLACK);
		precio_atletico.setBounds(465, 475, 100, 60);
		add(precio_atletico);

		precio_sevilla = new JLabel("95€");
		precio_sevilla.setFont(new Font("Arial", Font.BOLD, 25));
		precio_sevilla.setForeground(Color.BLACK);
		precio_sevilla.setBounds(650, 475, 100, 60);
		add(precio_sevilla);

		precio_betis = new JLabel("95€");
		precio_betis.setFont(new Font("Arial", Font.BOLD, 25));
		precio_betis.setForeground(Color.BLACK);
		precio_betis.setBounds(835, 475, 100, 60);
		add(precio_betis);


		//Botones añadir al carrito
		boton_madrid = new JButton("AÑADIR AL CARRITO");
		boton_madrid.setFont(new Font("Arial", Font.BOLD, 12));
		boton_madrid.setBorder(new LineBorder(Color.BLACK, 2));
		boton_madrid.setBackground(new Color(207, 207, 207));
		boton_madrid.setForeground(Color.BLACK);
		boton_madrid.setBounds(50, 550, 140, 60);
		add(boton_madrid);

		boton_barcelona = new JButton("AÑADIR AL CARRITO");
		boton_barcelona.setFont(new Font("Arial", Font.BOLD, 12));
		boton_barcelona.setBorder(new LineBorder(Color.BLACK, 2));
		boton_barcelona.setBackground(new Color(207, 207, 207));
		boton_barcelona.setForeground(Color.BLACK);
		boton_barcelona.setBounds(235, 550, 140, 60);
		add(boton_barcelona);

		boton_atletico = new JButton("AÑADIR AL CARRITO");
		boton_atletico.setFont(new Font("Arial", Font.BOLD, 12));
		boton_atletico.setBorder(new LineBorder(Color.BLACK, 2));
		boton_atletico.setBackground(new Color(207, 207, 207));
		boton_atletico.setForeground(Color.BLACK);
		boton_atletico.setBounds(420, 550, 140, 60);
		add(boton_atletico);

		boton_sevilla = new JButton("AÑADIR AL CARRITO");
		boton_sevilla.setFont(new Font("Arial", Font.BOLD, 12));
		boton_sevilla.setBorder(new LineBorder(Color.BLACK, 2));
		boton_sevilla.setBackground(new Color(207, 207, 207));
		boton_sevilla.setForeground(Color.BLACK);
		boton_sevilla.setBounds(605, 550, 140, 60);
		add(boton_sevilla);

		boton_betis = new JButton("AÑADIR AL CARRITO");
		boton_betis.setFont(new Font("Arial", Font.BOLD, 12));
		boton_betis.setBorder(new LineBorder(Color.BLACK, 2));
		boton_betis.setBackground(new Color(207, 207, 207));
		boton_betis.setForeground(Color.BLACK);
		boton_betis.setBounds(790, 550, 140, 60);
		add(boton_betis);

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

		ratonEncima(boton_madrid);
		ratonEncima(boton_barcelona);
		ratonEncima(boton_atletico);
		ratonEncima(boton_sevilla);
		ratonEncima(boton_betis);

		ratonEncima2(carrito);
		ratonEncima2(volver);

		// Acción de los botones
		boton_madrid.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	sonido.sonidoCompra();
		            conexion.aniadirCarrito(1); // id producto
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});

		boton_barcelona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sonido.sonidoCompra();
					conexion.aniadirCarrito(2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		boton_atletico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sonido.sonidoCompra();
					conexion.aniadirCarrito(3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		boton_sevilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sonido.sonidoCompra();
					conexion.aniadirCarrito(4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		boton_betis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sonido.sonidoCompra();
					conexion.aniadirCarrito(5);
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
