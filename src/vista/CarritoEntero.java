package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bbdd.CogerIdUsuario;
import bbdd.Conexion;

public class CarritoEntero extends JPanel{

	private Conexion conexion = new Conexion();
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JLabel subtitulo;
	
	public JLabel titulo_producto;
	public JLabel titulo_carrito;
	public JLabel titulo_usuario;
	public JLabel titulo_precio_total;
	
	public JButton volver;
	
	public CarritoEntero() {
		
		setLayout(null);
		
		mostrarProductos();
		mostrarCarrito();
		mostrarUsuario();
		
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
        subtitulo = new JLabel("Carrito de la compra");
        subtitulo.setFont(new Font("Arial", Font.BOLD, 30));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setBounds(65, 165, 300, 115);
        add(subtitulo);
        
        //Información productos del usuario que está comprando
        titulo_producto = new JLabel("Información de los productos");
        titulo_producto.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_producto.setForeground(new Color(142, 4, 4));
        titulo_producto.setBounds(100, 240, 350, 115);
        add(titulo_producto);
        
        //Información carrito del usuario que está comprando
        titulo_carrito = new JLabel("Información del carrito");
        titulo_carrito.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_carrito.setForeground(new Color(142, 4, 4));
        titulo_carrito.setBounds(525, 240, 300, 115);
        add(titulo_carrito);
        
        titulo_usuario = new JLabel("Información del usuario");
        titulo_usuario.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_usuario.setForeground(new Color(142, 4, 4));
        titulo_usuario.setBounds(100, 450, 300, 115);
        add(titulo_usuario);
        
        titulo_precio_total = new JLabel("Precio Total: ");
        titulo_precio_total.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_precio_total.setForeground(new Color(142, 4, 4));
        titulo_precio_total.setBounds(600, 575, 300, 115);
        add(titulo_precio_total);
        
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
        
        ratonEncima2(volver);
        
        volver.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        		Window window = SwingUtilities.getWindowAncestor(CarritoEntero.this);
        		window.dispose();
        	}
        	
        });
	}
	
	public void mostrarProductos() {
        Connection conexionnn = conexion.conectar();
        int totalPrecio = 0;
        
        if (conexion != null) {
            try {
                //Datos a consultar
                String consultasSeleccion = "SELECT p.* FROM carrito c JOIN producto p ON c.id_producto = p.id_producto WHERE c.id_usuario = " + CogerIdUsuario.getIdUsuario();
                System.out.println(consultasSeleccion);
                Statement consul = conexionnn.createStatement();
                // Ejecución de la consulta
                if (consul.execute(consultasSeleccion)) {
                	 ResultSet resultset = consul.getResultSet();
                     System.out.println("\nPRODUCTOS EN EL CARRITO");

                     String[] columnNames = {"Id_prod", "Nombre", "Liga", "Precio"};

                     DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); //El segundo parámetro 0 indica que inicialmente no hay filas en el modelo de la tabla.

                     //Ejecutamos una consulta SQL para obtener los productos del carrito y sus precios. Luego, iteramos sobre los resultados de la consulta.
                     while (resultset.next()) {
                         int idProducto = resultset.getInt("id_producto");
                         String nombreProducto = resultset.getString("nombre");
                         String ligaProducto = resultset.getString("liga");
                         int precioProducto = resultset.getInt("precio");
                         
                         //Agregamos cada producto y su precio al modelo de la tabla
                         Object[] row = {idProducto, nombreProducto, ligaProducto, precioProducto};
                         tableModel.addRow(row);

                         totalPrecio += precioProducto;
                     }

                     //Una vez que el modelo de la tabla está lleno de datos, creamos un JTable utilizando este modelo
                     JTable table = new JTable(tableModel);
                     table.setFillsViewportHeight(true);//Configuramos el JTable para que se ajuste al tamaño del contenedor que lo contiene
                     table.setFont(new Font("Arial", Font.PLAIN, 12));//Establecer la fuente para las filas de datos
                 
                     // Establecer la fuente para las filas de encabezado
                     JTableHeader tableHeader = table.getTableHeader();
                     tableHeader.setFont(new Font("Arial", Font.BOLD, 16));
                     tableHeader.setForeground(Color.BLACK);
                     tableHeader.setBackground(new Color(167, 167, 167));
                     
                     //Establecer un renderizador de celdas personalizado
                     table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                         @Override
                         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                             Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                             //Cambiar el color de fondo de las filas salteadamente
                             if (row % 2 == 0) {
                                 c.setBackground(Color.WHITE);
                             } else {
                                 c.setBackground(new Color(240, 240, 240));
                             }

                             return c;
                         }
                     });


                     //Envolver el JTable en un JScrollPane
                     JScrollPane scrollPane = new JScrollPane(table); //Para manejar el desbordamiento del contenido y permitir el desplazamiento, envolvemos el JTable en un JScrollPane:
                     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                     //Añadir el JScrollPane al JFrame. Establecemos las dimensiones y la posición del JScrollPane en el panel Carrito
                     scrollPane.setBounds(100, 325, 400, 150); // Ajusta las dimensiones según sea necesario
                     add(scrollPane);
                     
                     //Mostrar el precio total
                     JLabel precioTotalLabel = new JLabel(totalPrecio + "€");
                     precioTotalLabel.setFont(new Font("Arial", Font.BOLD, 30));
                     precioTotalLabel.setForeground(Color.BLACK);
                     precioTotalLabel.setBounds(760, 615, 300, 35); // Ajusta las dimensiones según sea necesario
                     add(precioTotalLabel);
                     
                     //Refrescar el contenedor
                     revalidate();
                     repaint();

                     System.out.println("\nDatos recuperados correctamente");
                     resultset.close();
                     consul.close();
                } else {
                    System.out.println("\nError al recuperar los datos");
                }
                // Cierre del Statement
                consul.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Cierre de la conexión
                conexion.cerrarConexion(conexionnn);
            }
        }
    }
	
	public void mostrarCarrito() {
        Connection conexionnn = conexion.conectar();
        int totalPrecio = 0;
        
        if (conexion != null) {
            try {
                //Datos a consultar
                String consultasSeleccion = "SELECT c.* FROM carrito c JOIN producto p ON c.id_producto = p.id_producto WHERE c.id_usuario = " + CogerIdUsuario.getIdUsuario();
                System.out.println(consultasSeleccion);
                Statement consul = conexionnn.createStatement();
                // Ejecución de la consulta
                if (consul.execute(consultasSeleccion)) {
                	 ResultSet resultset = consul.getResultSet();
                     System.out.println("\nIDs en el CARRITO");

                     String[] columnNames = {"Id_carrito", "Id_usuario", "Id_producto"};

                     DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); //El segundo parámetro 0 indica que inicialmente no hay filas en el modelo de la tabla.

                     //Ejecutamos una consulta SQL para obtener los productos del carrito y sus precios. Luego, iteramos sobre los resultados de la consulta.
                     while (resultset.next()) {
                         int idCarrito = resultset.getInt("id_carrito");
                         int idUsuario = resultset.getInt("id_usuario");
                         int idProducto = resultset.getInt("id_producto");
                         
                         //Agregamos cada producto y su precio al modelo de la tabla
                         Object[] row = {idCarrito, idUsuario, idProducto};
                         tableModel.addRow(row);
                     }

                     //Una vez que el modelo de la tabla está lleno de datos, creamos un JTable utilizando este modelo
                     JTable table = new JTable(tableModel);
                     table.setFillsViewportHeight(true);//Configuramos el JTable para que se ajuste al tamaño del contenedor que lo contiene
                     table.setFont(new Font("Arial", Font.PLAIN, 12));//Establecer la fuente para las filas de datos
                 
                     // Establecer la fuente para las filas de encabezado
                     JTableHeader tableHeader = table.getTableHeader();
                     tableHeader.setFont(new Font("Arial", Font.BOLD, 16));
                     tableHeader.setForeground(Color.BLACK);
                     tableHeader.setBackground(new Color(167, 167, 167));
                     
                     //Establecer un renderizador de celdas personalizado
                     table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                         @Override
                         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                             Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                             //Cambiar el color de fondo de las filas salteadamente
                             if (row % 2 == 0) {
                                 c.setBackground(Color.WHITE);
                             } else {
                                 c.setBackground(new Color(240, 240, 240));
                             }

                             return c;
                         }
                     });


                     //Envolver el JTable en un JScrollPane
                     JScrollPane scrollPane = new JScrollPane(table); //Para manejar el desbordamiento del contenido y permitir el desplazamiento, envolvemos el JTable en un JScrollPane:
                     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                     //Añadir el JScrollPane al JFrame. Establecemos las dimensiones y la posición del JScrollPane en el panel Carrito
                     scrollPane.setBounds(525, 325, 400, 150); // Ajusta las dimensiones según sea necesario
                     add(scrollPane);
                     
                     //Refrescar el contenedor
                     revalidate();
                     repaint();

                     System.out.println("\nDatos recuperados correctamente");
                     resultset.close();
                     consul.close();
                } else {
                    System.out.println("\nError al recuperar los datos");
                }
                // Cierre del Statement
                consul.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Cierre de la conexión
                conexion.cerrarConexion(conexionnn);
            }
        }
    }
	
	public void mostrarUsuario() {
        Connection conexionnn = conexion.conectar();
        int totalPrecio = 0;
        
        if (conexion != null) {
            try {
                //Datos a consultar
                String consultasSeleccion = "SELECT u.* FROM usuario u WHERE u.id_usuario = " + CogerIdUsuario.getIdUsuario();
                System.out.println(consultasSeleccion);
                Statement consul = conexionnn.createStatement();
                // Ejecución de la consulta
                if (consul.execute(consultasSeleccion)) {
                	 ResultSet resultset = consul.getResultSet();
                     System.out.println("\nUSUARIO");

                     String[] columnNames = {"Id_usuario", "Nombre U", "Contraseña", "Nombre", "Apellidos", "Telefono", "Correo"};

                     DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); //El segundo parámetro 0 indica que inicialmente no hay filas en el modelo de la tabla.

                     //Ejecutamos una consulta SQL para obtener los productos del carrito y sus precios. Luego, iteramos sobre los resultados de la consulta.
                     while (resultset.next()) {
                         int idUsuario = resultset.getInt("id_usuario");
                         String nombreUsuarioUsuario = resultset.getString("nombre_usuario");
                         String contraseñaUsuario = resultset.getString("contraseña_usuario");
                         String nombreUsuario = resultset.getString("nombre");
                         String apellidosUsuario = resultset.getString("apellidos");
                         int telefonoUsuario = resultset.getInt("telefono");
                         String correoUsuario = resultset.getString("correo");
                         
                         //Agregamos cada producto y su precio al modelo de la tabla
                         Object[] row = {idUsuario, nombreUsuarioUsuario, contraseñaUsuario, nombreUsuario, apellidosUsuario, telefonoUsuario, correoUsuario};
                         tableModel.addRow(row);
                     }

                     //Una vez que el modelo de la tabla está lleno de datos, creamos un JTable utilizando este modelo
                     JTable table = new JTable(tableModel);
                     table.setFillsViewportHeight(true);//Configuramos el JTable para que se ajuste al tamaño del contenedor que lo contiene
                     table.setFont(new Font("Arial", Font.PLAIN, 12));//Establecer la fuente para las filas de datos
                 
                     // Establecer la fuente para las filas de encabezado
                     JTableHeader tableHeader = table.getTableHeader();
                     tableHeader.setFont(new Font("Arial", Font.BOLD, 16));
                     tableHeader.setForeground(Color.BLACK);
                     tableHeader.setBackground(new Color(167, 167, 167));
                     
                     //Establecer un renderizador de celdas personalizado
                     table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                         @Override
                         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                             Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                             //Cambiar el color de fondo de las filas salteadamente
                             if (row % 2 == 0) {
                                 c.setBackground(Color.WHITE);
                             } else {
                                 c.setBackground(new Color(240, 240, 240));
                             }

                             return c;
                         }
                     });


                     //Envolver el JTable en un JScrollPane
                     JScrollPane scrollPane = new JScrollPane(table); //Para manejar el desbordamiento del contenido y permitir el desplazamiento, envolvemos el JTable en un JScrollPane:
                     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                     //Añadir el JScrollPane al JFrame. Establecemos las dimensiones y la posición del JScrollPane en el panel Carrito
                     scrollPane.setBounds(100, 535, 700, 40); // Ajusta las dimensiones según sea necesario
                     add(scrollPane);
                     
                     //Refrescar el contenedor
                     revalidate();
                     repaint();

                     System.out.println("\nDatos recuperados correctamente");
                     resultset.close();
                     consul.close();
                } else {
                    System.out.println("\nError al recuperar los datos");
                }
                // Cierre del Statement
                consul.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Cierre de la conexión
                conexion.cerrarConexion(conexionnn);
            }
        }
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
