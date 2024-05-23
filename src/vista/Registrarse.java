package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;

import bbdd.Conexion;

public class Registrarse extends JPanel{
	
	private Principal principal;
	private Correo correoMensaje;

	public PanelImagen panelFondo;
	
	public JLabel titulo;
	
	public JPanel cuadrado;
	
	public JLabel textoRegistro;
	
	public JLabel usuario;
	public JTextField textUsuario;
	
	public JLabel nombre;
	public JTextField textNombre;
	
	public JLabel apellidos;
	public JTextField textApellidos;
	
	public JLabel telefono;
	public JTextField textTelefono;
	
	public JLabel correo;
	public JTextField textCorreo;
	
	public JLabel contrasenia;
	public JTextField textContrasenia;
	
	public JLabel textoRegistro2;
	
	public JButton crearCuenta;
	public JButton yaCuenta;
	
	public Registrarse(Principal principal) {
		this.principal = principal;
		this.correoMensaje = new Correo();
		
        setLayout(null);
    	
		//Título
    	titulo = new JLabel("La Redonda");
        titulo.setFont(new Font("Arial", Font.BOLD, 70));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(275, 75, 450, 60);
        add(titulo);
        
        
        //Texto formulario
        textoRegistro = new JLabel("Introduce tus datos personales");
        textoRegistro.setFont(new Font("Arial", Font.ITALIC, 25));
        textoRegistro.setForeground(new Color(140, 7, 7));
        textoRegistro.setBounds(165, 215, 500, 25);
        add(textoRegistro);
        
        //Nombre
        nombre = new JLabel("Nombre:");
        nombre.setFont(new Font("Arial", Font.BOLD, 20));
        nombre.setForeground(Color.BLACK);
        nombre.setBounds(175, 260, 250, 20);
        add(nombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(500, 260, 300, 20);
        add(textNombre);
                
        //Apellidos
        apellidos = new JLabel("Apellidos:");
        apellidos.setFont(new Font("Arial", Font.BOLD, 20));
        apellidos.setForeground(Color.BLACK);
        apellidos.setBounds(175, 300, 250, 20);
        add(apellidos);
        
        textApellidos = new JTextField();
        textApellidos.setBounds(500, 300, 300, 20);
        add(textApellidos);
        
        //Teléfono
        telefono = new JLabel("Teléfono:");
        telefono.setFont(new Font("Arial", Font.BOLD, 20));
        telefono.setForeground(Color.BLACK);
        telefono.setBounds(175, 340, 250, 20);
        add(telefono);
        
        textTelefono = new JTextField();
        textTelefono.setBounds(500, 340, 300, 20);
        add(textTelefono);
        
        //Correo electrónico
        correo = new JLabel("Correo electrónico:");
        correo.setFont(new Font("Arial", Font.BOLD, 20));
        correo.setForeground(Color.BLACK);
        correo.setBounds(175, 380, 250, 20);
        add(correo);
        
        textCorreo = new JTextField();
        textCorreo.setBounds(500, 380, 300, 20);
        add(textCorreo);
        
        //Texto 2 formulario
        textoRegistro2 = new JLabel("Crea tu usuario y contraseña");
        textoRegistro2.setFont(new Font("Arial", Font.ITALIC, 25));
        textoRegistro2.setForeground(new Color(140, 7, 7));
        textoRegistro2.setBounds(165, 425, 500, 25);
        add(textoRegistro2);
        
        //Usuario
        usuario = new JLabel("Nombre usuario:");
        usuario.setFont(new Font("Arial", Font.BOLD, 20));
        usuario.setForeground(Color.BLACK);
        usuario.setBounds(175, 470, 250, 20);
        add(usuario);
        
        textUsuario = new JTextField();
        textUsuario.setBounds(500, 470, 300, 20);
        add(textUsuario);
        
        //Contraseña
        contrasenia = new JLabel("Contraseña usuario:");
        contrasenia.setFont(new Font("Arial", Font.BOLD, 20));
        contrasenia.setForeground(Color.BLACK);
        contrasenia.setBounds(175, 510, 250, 20);
        add(contrasenia);
        
        textContrasenia = new JTextField();
        textContrasenia.setBounds(500, 510, 300, 20);
        add(textContrasenia);
        
        
        //Botón inicioSesión;
        crearCuenta = new JButton("Crear cuenta");
        crearCuenta.setFont(new Font("Arial", Font.BOLD, 18));
        crearCuenta.setBorder(new LineBorder(Color.BLACK));
        crearCuenta.setBackground(new Color(241, 39, 39));
        crearCuenta.setForeground(Color.BLACK);
        crearCuenta.setBounds(600, 580, 200, 65);
        add(crearCuenta);
        
        //Botón de ya tener cuenta
        yaCuenta = new JButton("Ya tengo cuenta");
        yaCuenta.setFont(new Font("Arial", Font.BOLD, 13));
        yaCuenta.setBorder(new LineBorder(Color.BLACK));
        yaCuenta.setBackground(new Color(220, 96, 96));
        yaCuenta.setForeground(Color.BLACK);
        yaCuenta.setBounds(200, 590, 150, 40);
        add(yaCuenta);
        
        
        //Cuadrado
        cuadrado = new JPanel();
        cuadrado.setBackground(new Color(255, 255, 255, 175));
        cuadrado.setBorder(new LineBorder(Color.BLACK));
        cuadrado.setBounds(150, 200, 700, 350);
        add(cuadrado);
        
        
        //Imagen fondo
        panelFondo = new PanelImagen();
        panelFondo.setBounds(0, 0, 1000, 750);
        add(panelFondo);
        
        
        ratonEncima();
        
        
        yaCuenta.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    principal.cambiarPanel(principal.inicioSesion);
        	    textNombre.setText("");
		    	textApellidos.setText("");
		    	textTelefono.setText("");
		        textCorreo.setText("");
		        textUsuario.setText("");
		    	textContrasenia.setText("");
        	}
        	
        });
        
        crearCuenta.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        		// Conexión a la base de datos y consulta SQL para agregar un usuario
     		   String Nombre = textNombre.getText();
     		   String Apellidos = textApellidos.getText();
     		   String TelefonoTexto = textTelefono.getText();
     		   String Correo = textCorreo.getText();
     		   String Nombre_Usuario = textUsuario.getText();
     		   String Contraseña_Usuario = textContrasenia.getText();
     		   
     		   
     		   //Verifico si estos campos están vacíos
     		   if (textNombre.getText().isEmpty() || textApellidos.getText().isEmpty() || textTelefono.getText().isEmpty() || textCorreo.getText().isEmpty() || textUsuario.getText().isEmpty() || textContrasenia.getText().isEmpty()) {
     		       JOptionPane.showMessageDialog(null, "Hay campos vacíos. Todos los campos son obligatorios");
     		       return; // Detiene la ejecución si faltan campos por llenar
     		   }
     		   
     		   
     		   // Verificar si el nombre contiene espacios al principio y al final. Así puedes poner nombres compuestos, pero no espacios vacíos sin nada más
     		   if (Nombre.startsWith(" ") || Nombre.endsWith(" ")) {
     		       JOptionPane.showMessageDialog(null, "El nombre no puede empezar ni terminar con espacios.");
     		       return;
     		   }
     		   // Verifica si contiene caracteres distintos a letras y espacios entre palabras
     		   if (!Nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) { //El + indica que la expresión regular coincide con una o más ocurrencias de los caracteres especificados entre corchetes. Esto garantiza que el nombre tenga al menos un carácter válido. Sin el +, la expresión regular permitiría cadenas vacías.
     			   JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios");
     		        return; // Detiene la ejecución si el nombre tiene números o caracteres especiales
     		   }
     		   
     		   
     		   // Verificar si los apellidos contienen espacios
     		   if (Apellidos.startsWith(" ") || Apellidos.endsWith(" ")) {
     		       JOptionPane.showMessageDialog(null, "Los apellidos no pueden empezar ni terminar con espacios.");
     		       return;
     		   }
     		   // Verifica si contiene caracteres distintos a letras y espacios entre palabras
     		   if (!Apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) { //El + indica que la expresión regular coincide con una o más ocurrencias de los caracteres especificados entre corchetes. Esto garantiza que el nombre tenga al menos un carácter válido. Sin el +, la expresión regular permitiría cadenas vacías.
     			   JOptionPane.showMessageDialog(null, "Los apellidos solo pueden contener letras y espacios");
     		       return; // Detiene la ejecución si el nombre tiene números o caracteres especiales
     		   }
     		   
     		   
     		   // Verificar si hay espacios en el número de teléfono
     		   if (TelefonoTexto.contains(" ")) { 
     			   JOptionPane.showMessageDialog(null, "El número de teléfono no puede contener espacios.");
     			   return; 
     		   } 		   
     		   // Verificar si el número de teléfono contiene solo dígitos
     		   if (!esNumero(TelefonoTexto)) {
     		       JOptionPane.showMessageDialog(null, "El número de teléfono no debe ser muy largo y solo puede contener números.");
     		       return;
     		   }
     		    
     		   int Telefono = Integer.parseInt(TelefonoTexto);
     		   
     		   
     		   // Verificar si el correo electrónico contiene espacios
     		   if (Correo.contains(" ")) {
     		       JOptionPane.showMessageDialog(null, "El correo electrónico no puede contener espacios.");
     		       return;
     		   }		    
     		   // Verificar si el correo electrónico contiene un "@" y caracteres después de él
     		   if (!validarCorreo(Correo)) {
     		       JOptionPane.showMessageDialog(null, "El formato del correo electrónico es incorrecto.");
     		       return;
     		   }
     		  
     		   
     		   // Verificar si el nombre de usuario contiene espacios
     		   if (Nombre_Usuario.contains(" ")) {
     		       JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener espacios.");
     		       return;
     		   }
     		   // Verifica si contiene caracteres distintos a letras y espacios entre palabras
     		   if (!Nombre_Usuario.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9]+$")) { //El $ al final de la expresión regular asegura que la cadena no contenga ningún otro carácter después de la última letra o número.
     			   JOptionPane.showMessageDialog(null, "El nombre de usuario solo puede contener letras y numeros");
     		       return;
     		   }
     		   
     		   
     		   // Verificar si la contraseña contiene espacios
     		   if (Contraseña_Usuario.contains(" ")) {
     		       JOptionPane.showMessageDialog(null, "La contraseña no puede contener espacios.");
     		       return;
     		   }
     		    
     		    
     		   try {
     			  Conexion conexion = new Conexion();
     			  boolean registrado = conexion.insertDataRegistrarse(Nombre_Usuario, Contraseña_Usuario, Nombre, Apellidos, Telefono, Correo);

     		      if (registrado) { //Si se ha registrado correctamente pues cambia de panel, si no (osea si hay algún dato donde has puesto algo que no se puede) pues no te deja.
     		    	  conexion.getDataRegistrarse();
     		    	  principal.cambiarPanel(principal.inicioSesion);
     		    	  textNombre.setText("");
     		    	  textApellidos.setText("");
     		    	  textTelefono.setText("");
     		    	  textCorreo.setText("");
     		    	  textUsuario.setText("");
     		    	  textContrasenia.setText("");
     		    	  
     		    	 // Enviar correo de bienvenida
     	             correoMensaje.enviarCorreo(Correo, Nombre, Apellidos, Telefono, Nombre_Usuario, Contraseña_Usuario);
     		      }
     			 
     		   } catch (SQLException ex) {
     		      JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
     		   }

        	}
     	
        	private boolean esNumero(String telefono) {
        		try {
        			Integer.parseInt(telefono);
        			return true;
        		} catch (NumberFormatException e) {
        			return false;
        		}
        	}
     	
        	private boolean validarCorreo(String correo) {     	    
        	    int arrobaIndex = correo.indexOf('@'); //Busca la posición del primer símbolo "@" en la cadena correo y la almacena en la variable arrobaIndex.
        	    return arrobaIndex != -1 && //Verifica que se haya encontrado al menos un símbolo "@" .
        	    	   arrobaIndex == correo.lastIndexOf('@') && //Verifica que solo haya un símbolo "@" 
        	           arrobaIndex < correo.lastIndexOf('.') && //Verifica que el último símbolo "@" esté antes del último "." 
        	           correo.lastIndexOf('.') != correo.length() - 1 && //Verifica que el último "." no sea el último carácter de la cadena, es decir, hay algo después del punto, el dominio.
        	           correo.matches("^[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_.-]+)$"); //Ni DIOS es capaz de depurar todavía más esto.
        	    	  /*Esta expresión regular cumple con tus requisitos de:
						Permitir solo letras, números, guiones y puntos.
						No permitir dos puntos seguidos.
						Asegurar que haya texto entre el @ y el . (por ejemplo, @gmail.).
						*/
        	}
         	
        });
        	    
	}
        	
        	
	
	private void ratonEncima(){
		crearCuenta.addMouseListener(new MouseListener() {
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
					crearCuenta.setBackground(new Color(241, 39, 39));
					crearCuenta.setBorder(new LineBorder(Color.BLACK));
					crearCuenta.setForeground(Color.BLACK);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					crearCuenta.setBackground(Color.BLACK);
					crearCuenta.setBorder(new LineBorder(Color.RED));
					crearCuenta.setForeground(Color.WHITE);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					crearCuenta.setBackground(new Color(241, 39, 39));
					crearCuenta.setBorder(new LineBorder(Color.BLACK));
					crearCuenta.setForeground(Color.BLACK);
				}
				 
			 });
		 
		yaCuenta.addMouseListener(new MouseListener() {
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
					yaCuenta.setBackground(new Color(220, 96, 96));
					yaCuenta.setBorder(new LineBorder(Color.BLACK));
					yaCuenta.setForeground(Color.BLACK);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					yaCuenta.setBackground(new Color(45, 45, 45));
					yaCuenta.setBorder(new LineBorder(Color.RED));
					yaCuenta.setForeground(Color.WHITE);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					yaCuenta.setBackground(new Color(220, 96, 96));
					yaCuenta.setBorder(new LineBorder(Color.BLACK));
					yaCuenta.setForeground(Color.BLACK);
				}
				 
			 });
		}
	
}
