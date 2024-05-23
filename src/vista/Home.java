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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bbdd.Conexion;

public class Home extends JPanel{
	
	private Principal principal;
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JButton laliga;
	public JButton premierleague;
	public JButton seriea;
	public JButton bundesliga;
	public JButton ligue1;
	
	public JLabel camisetas;
	
	public JButton carrito;
	public JButton inicio;
	
	public Home(Principal principal) {
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
        
        //Botones
        ImageIcon boton_laliga = new ImageIcon(getClass().getResource("/imagenes/laliga.png"));
        ImageIcon boton_premier = new ImageIcon(getClass().getResource("/imagenes/premierleague.png"));
        ImageIcon boton_seriea = new ImageIcon(getClass().getResource("/imagenes/seriea.png"));
        ImageIcon boton_bundes = new ImageIcon(getClass().getResource("/imagenes/bundesliga.png"));
        ImageIcon boton_ligue1 = new ImageIcon(getClass().getResource("/imagenes/ligue1.png"));

        laliga = new JButton(boton_laliga);
        premierleague = new JButton(boton_premier);
        seriea = new JButton(boton_seriea);
        bundesliga = new JButton(boton_bundes);
        ligue1 = new JButton(boton_ligue1);
        
        laliga.setBounds(50, 225, 150, 115);
        premierleague.setBounds(235, 225, 150, 115);
        seriea.setBounds(420, 225, 150, 115);
        bundesliga.setBounds(605, 225, 150, 115);
        ligue1.setBounds(790, 225, 150, 115);
        
        laliga.setBorder(new LineBorder(Color.BLACK));
        premierleague.setBorder(new LineBorder(Color.BLACK));
        seriea.setBorder(new LineBorder(Color.BLACK));
        bundesliga.setBorder(new LineBorder(Color.BLACK));
        ligue1.setBorder(new LineBorder(Color.BLACK));
        
        add(laliga);
        add(premierleague);
        add(seriea);
        add(bundesliga);
        add(ligue1);
        
        //Foto camisetas
        ImageIcon foto_camisetas = new ImageIcon(getClass().getResource("/imagenes/camisetas.png"));
        camisetas = new JLabel(foto_camisetas);
        camisetas.setBounds(0, 350, 1000, 275);
        add(camisetas);
        
        //Botón carrito
        carrito = new JButton("CARRITO");
        carrito.setFont(new Font("Arial", Font.PLAIN, 18));
        carrito.setBorder(new LineBorder(Color.BLACK, 2));
        carrito.setBackground(new Color(167, 167, 167));
        carrito.setForeground(Color.BLACK);
        carrito.setBounds(660, 75, 125, 60);
        add(carrito);
        
        //Botón inicio
        inicio = new JButton("INICIO");
        inicio.setFont(new Font("Arial", Font.PLAIN, 18));
        inicio.setBorder(new LineBorder(Color.RED, 2));
        inicio.setBackground(Color.BLACK);
        inicio.setForeground(Color.WHITE);
        inicio.setBounds(815, 75, 125, 60);
        add(inicio);
        
        //Imagen fondo
        panelFondo = new PanelImagen();
        panelFondo.setBounds(0, 0, 1000, 750);
        add(panelFondo);
        
        
        //A todos los botones les pasará lo mismo cuando ponga el ratón encima, así que los meto ya aquí
        ratonEncima(laliga);
        ratonEncima(premierleague);
        ratonEncima(seriea);
        ratonEncima(bundesliga);
        ratonEncima(ligue1);
        
        ratonEncima2(carrito);
        
        ratonEncima3(inicio);
        
        carrito.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        		CarritoFrame carritoFrame = new CarritoFrame();
				carritoFrame.setVisible(true);
        	}
        	
        });
        
        inicio.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.inicio);
        	}
        	
        });
        
        
        laliga.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.laliga);
        	}
        	
        });
            
        premierleague.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.premierleague);
        	}
        	
        });
        
        seriea.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.seriea);
        	}
        	
        });

        bundesliga.addActionListener(new ActionListener() {
	
        	public void actionPerformed(ActionEvent e) {
        		// Cambiar el panel visible
        		principal.cambiarPanel(principal.bundesliga);
        	}
	
        });

        ligue1.addActionListener(new ActionListener() {
	
        	public void actionPerformed(ActionEvent e) {
        		// Cambiar el panel visible
        		principal.cambiarPanel(principal.ligue1);
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
					boton.setBorder(new LineBorder(Color.BLACK));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					boton.setBorder(new LineBorder(Color.RED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					boton.setBorder(new LineBorder(Color.BLACK));
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
	
	private void ratonEncima3(JButton boton){
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
					boton.setBackground(Color.BLACK);
					boton.setBorder(new LineBorder(Color.RED, 2));
					boton.setForeground(Color.WHITE);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					boton.setBackground(Color.RED);
					boton.setBorder(new LineBorder(Color.BLACK, 2));
					boton.setForeground(Color.BLACK);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					boton.setBackground(Color.BLACK);
					boton.setBorder(new LineBorder(Color.RED, 2));
					boton.setForeground(Color.WHITE);
				}
				 
			 });
		 
		}
	
	 
}
