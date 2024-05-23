package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import bbdd.CogerIdUsuario;
import bbdd.Conexion;

public class IniciarSesion extends JPanel{

	private Principal principal;
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JPanel cuadrado;
	
	public JLabel usuario;
	public JTextField textUsuario;
	
	public JLabel correo;
	public JTextField textCorreo;
	
	public JLabel contrasenia;
	public JPasswordField textContrasenia;
	
	public JButton iniciarSesion;
	public JButton noCuenta;
	
	public IniciarSesion(Principal principal) {
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
        
        
        //Usuario
        usuario = new JLabel("Usuario");
        usuario.setFont(new Font("Arial", Font.BOLD, 25));
        usuario.setForeground(Color.BLACK);
        usuario.setBounds(175, 225, 250, 20);
        add(usuario);
        
        textUsuario = new JTextField();
        textUsuario.setBounds(175, 260, 250, 30);
        add(textUsuario);
                
        //Correo electrónico
        correo = new JLabel("Correo electrónico");
        correo.setFont(new Font("Arial", Font.BOLD, 25));
        correo.setForeground(Color.BLACK);
        correo.setBounds(175, 325, 250, 20);
        add(correo);
        
        textCorreo = new JTextField();
        textCorreo.setBounds(175, 360, 250, 30);
        add(textCorreo);
        
        //Contraseña
        contrasenia = new JLabel("Contraseña");
        contrasenia.setFont(new Font("Arial", Font.BOLD, 25));
        contrasenia.setForeground(Color.BLACK);
        contrasenia.setBounds(175, 425, 250, 20);
        add(contrasenia);
        
        textContrasenia = new JPasswordField();
        textContrasenia.setBounds(175, 460, 250, 30);
        add(textContrasenia);
        
        
        //Botón inicioSesión;
        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 18));
        iniciarSesion.setBorder(new LineBorder(Color.BLACK));
        iniciarSesion.setBackground(new Color(241, 39, 39));
        iniciarSesion.setForeground(Color.BLACK);
        iniciarSesion.setBounds(200, 540, 200, 65);
        add(iniciarSesion);
        
        //Botón de ya tener cuenta
        noCuenta = new JButton("No tengo cuenta");
        noCuenta.setFont(new Font("Arial", Font.BOLD, 13));
        noCuenta.setBorder(new LineBorder(Color.BLACK));
        noCuenta.setBackground(new Color(220, 96, 96));
        noCuenta.setForeground(Color.BLACK);
        noCuenta.setBounds(225, 625, 150, 40);
        add(noCuenta);
        
        
        //Cuadrado
        cuadrado = new JPanel();
        cuadrado.setBackground(new Color(255, 255, 255, 175));
        cuadrado.setBorder(new LineBorder(Color.BLACK));
        cuadrado.setBounds(150, 200, 300, 315);
        add(cuadrado);
        
        
        //Imagen fondo
        panelFondo = new PanelImagen();
        panelFondo.setBounds(0, 0, 1000, 750);
        add(panelFondo);
        
        
        //No le meto los botones dentro como parámetros porque en este caso cada botón se pondrá los colores distintos cuando pase el ratón por encima. Así que lo configuro individualmente en el método
        ratonEncima();
        
        
        noCuenta.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.registrar);
        	    textUsuario.setText("");
                textCorreo.setText("");
		    	textContrasenia.setText("");
        	}
        	
        });
        
        iniciarSesion.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        		// Verificar si el usuario existe
                String usuario = textUsuario.getText();
                String correo = textCorreo.getText();
                String contrasenia = new String(textContrasenia.getPassword());

                try {
                    Conexion conexion = new Conexion();
                    boolean usuarioExiste = conexion.verificarUsuario(usuario, correo, contrasenia);
                    

                    if (usuarioExiste) {
                    	int idUsuario = Conexion.guardarIdUsuario(usuario);
                    	CogerIdUsuario.setIdUsuario(idUsuario);
                        // Cambiar el panel visible
                        principal.cambiarPanel(principal.home);
                        textUsuario.setText("");
                        textCorreo.setText("");
       		    	    textContrasenia.setText("");
       		    	    
       		    	    //En cuanto inicias sesión y te lleva al inicio, te muestro por consola todos los productos
       	        	    try {
       	      			  Conexion conexion2 = new Conexion();
       	      			  conexion2.getDataProducto();		 
       	        	    } catch (SQLException ex) {
       	      		      JOptionPane.showMessageDialog(null, "Error al mostrar el producto.");
       	        	    }
       		    	    
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado. Verifica tus credenciales.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
                }
                
                
        	}
        	
        });
	}
	
	 private void ratonEncima(){
		 iniciarSesion.addMouseListener(new MouseListener() {
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
					iniciarSesion.setBackground(new Color(241, 39, 39));
					iniciarSesion.setBorder(new LineBorder(Color.BLACK));
					iniciarSesion.setForeground(Color.BLACK);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					iniciarSesion.setBackground(Color.BLACK);
					iniciarSesion.setBorder(new LineBorder(Color.RED));
					iniciarSesion.setForeground(Color.WHITE);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					iniciarSesion.setBackground(new Color(241, 39, 39));
					iniciarSesion.setBorder(new LineBorder(Color.BLACK));
					iniciarSesion.setForeground(Color.BLACK);
				}
				 
			 });
		 
		 noCuenta.addMouseListener(new MouseListener() {
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
					noCuenta.setBackground(new Color(220, 96, 96));
					noCuenta.setBorder(new LineBorder(Color.BLACK));
		            noCuenta.setForeground(Color.BLACK);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					noCuenta.setBackground(new Color(45, 45, 45));
					noCuenta.setBorder(new LineBorder(Color.RED));
					noCuenta.setForeground(Color.WHITE);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					noCuenta.setBackground(new Color(220, 96, 96));
					noCuenta.setBorder(new LineBorder(Color.BLACK));
		            noCuenta.setForeground(Color.BLACK);
				}
				 
			 });
		}
		
}
