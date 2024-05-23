package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import bbdd.CogerIdUsuario;
import bbdd.Conexion;

public class MetodoPago extends JPanel{
	
	//private Conexion conexion = new Conexion();
	
	public PanelImagen panelFondo;
	private MetodoPagoFrame metodoPagoFrame;

	public JLabel titulo;
	public JLabel logo;
	
	public JLabel subtitulo;
	
	public JPanel cuadrado;
	
	public JLabel metodo;
	public JTextField textMetodo;
	public JComboBox<String> comboMetodo;
	
	public JLabel saldo;
	public JTextField textSaldo;
	
	public JButton pagar;
	
	public JButton volver;
	
	public MetodoPago(MetodoPagoFrame metodoPagoFrame) {
		this.metodoPagoFrame = metodoPagoFrame;
		
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
        
        //Subtitulo
        subtitulo = new JLabel("Añade un método de pago");
        subtitulo.setFont(new Font("Arial", Font.BOLD, 30));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setBounds(65, 165, 400, 115);
        add(subtitulo);
        
        //Método
        metodo = new JLabel("Método de pago");
        metodo.setFont(new Font("Arial", Font.BOLD, 25));
        metodo.setForeground(Color.BLACK);
        metodo.setBounds(175, 325, 250, 30);
        add(metodo);
        
        comboMetodo = new JComboBox<>();
        comboMetodo.addItem("Tarjeta");
        comboMetodo.addItem("Criptomonedas");
        comboMetodo.addItem("PayPal");
        comboMetodo.setBounds(175, 365, 250, 30);
        add(comboMetodo);
        
        //Saldo
        saldo = new JLabel("Saldo");
        saldo.setFont(new Font("Arial", Font.BOLD, 25));
        saldo.setForeground(Color.BLACK);
        saldo.setBounds(175, 425, 250, 30);
        add(saldo);
        
        textSaldo = new JTextField();
        textSaldo.setBounds(175, 465, 250, 30);
        add(textSaldo);
        
        //Cuadrado
        cuadrado = new JPanel();
        cuadrado.setBackground(new Color(255, 255, 255, 175));
        cuadrado.setBorder(new LineBorder(Color.BLACK));
        cuadrado.setBounds(150, 300, 300, 225);
        add(cuadrado);
        
        //Botón pagar
        pagar = new JButton("Pagar");
        pagar.setFont(new Font("Arial", Font.BOLD, 17));
        pagar.setBorder(new LineBorder(Color.BLACK, 2));
        pagar.setBackground(new Color(207, 207, 207));
        pagar.setForeground(Color.BLACK);
        pagar.setBounds(625, 550, 140, 60);
        add(pagar);
        
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
        
        ratonEncima(pagar);
        
        ratonEncima2(volver);
        
        pagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String metodoSeleccionado = (String) comboMetodo.getSelectedItem();
                String saldoIntroducidoStr = textSaldo.getText();

                try {
                    int saldoIntroducido = Integer.parseInt(saldoIntroducidoStr);
                    int idUsuario = CogerIdUsuario.getIdUsuario();
                    int totalCarrito = calcularCostoTotalCarrito(idUsuario);

                    if (saldoIntroducido >= totalCarrito) {
                        if (guardarMetodoPago(metodoSeleccionado, saldoIntroducidoStr)) {
                            vaciarCarrito(idUsuario);
                            JOptionPane.showMessageDialog(null, "Pago realizado con " + metodoSeleccionado + " por un saldo de " + saldoIntroducidoStr);
                            
                            CompraRealizadaFrame compraRealizadaFrame = new CompraRealizadaFrame();
                            compraRealizadaFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al realizar el pago. Por favor, inténtelo de nuevo.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente. El total del carrito es " + totalCarrito + "€ y su saldo es " + saldoIntroducido + "€.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduzca un saldo válido.");
                }
            }
        });
        
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Window window = SwingUtilities.getWindowAncestor(MetodoPago.this);
        		window.dispose();
            }
        });
	}
	
	private int calcularCostoTotalCarrito(int idUsuario) {
	    Connection conexionnn = Conexion.conectar();
	    int totalPrecio = 0;
	    if (conexionnn != null) {
	        try {
	            String consultaTotal = "SELECT SUM(p.precio) AS total_precio FROM carrito c JOIN producto p ON c.id_producto = p.id_producto WHERE c.id_usuario = ?";
	            PreparedStatement stmt = conexionnn.prepareStatement(consultaTotal);
	            stmt.setInt(1, idUsuario);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                totalPrecio = rs.getInt("total_precio");
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            Conexion.cerrarConexion(conexionnn);
	        }
	    }
	    return totalPrecio;
	}
	
	private boolean guardarMetodoPago(String metodo, String saldo) {
		Connection conexionnn = Conexion.conectar();
		if (conexionnn != null) {
			try {
				String insertSQL = "INSERT INTO formaPago (metodo, saldo, id_usuario) VALUES (?, ?, ?)";
				PreparedStatement stmt = conexionnn.prepareStatement(insertSQL);
				stmt.setString(1, metodo);
				stmt.setInt(2, Integer.parseInt(saldo));
				stmt.setInt(3, CogerIdUsuario.getIdUsuario());
				
				int rowsInserted = stmt.executeUpdate();
				stmt.close();
				return rowsInserted > 0; //Devuelve true si al menos una fila fue insertada
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Conexion.cerrarConexion(conexionnn);
			}
		}
		return false;
	}
	
	private void vaciarCarrito(int idUsuario) {
        Connection conexionnn = Conexion.conectar();
        if (conexionnn != null) {
            try {
                String deleteSQL = "DELETE FROM carrito WHERE id_usuario = ?";
                PreparedStatement stmt = conexionnn.prepareStatement(deleteSQL);
                stmt.setInt(1, idUsuario);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexion.cerrarConexion(conexionnn);
            }
        }
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
