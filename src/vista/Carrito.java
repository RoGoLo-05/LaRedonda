package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import bbdd.CogerIdUsuario;
import bbdd.Conexion;

public class Carrito extends JPanel{
	
	private Conexion conexion = new Conexion();
	
	public PanelImagen panelFondo;
	
	public JLabel titulo;
	public JLabel logo;
	
	public JLabel subtitulo;
	
	public JLabel titulo_informacion;
	public JLabel titulo_precio_total;
	
	public JButton mostrarInfo;
	public JButton pagar;
	
	public JButton volver;
	
	
	private JLabel precioTotalLabel;
    private int totalPrecio;
    
	
	public Carrito() {
		
		setLayout(null);
		
		this.totalPrecio = 0;
		mostrarProductosCarrito();
		
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
        
        //Información
        titulo_informacion = new JLabel("Información");
        titulo_informacion.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_informacion.setForeground(new Color(142, 4, 4));
        titulo_informacion.setBounds(100, 240, 300, 115);
        add(titulo_informacion);
        
        titulo_precio_total = new JLabel("Precio Total");
        titulo_precio_total.setFont(new Font("Arial", Font.BOLD, 25));
        titulo_precio_total.setForeground(new Color(142, 4, 4));
        titulo_precio_total.setBounds(625, 240, 300, 115);
        add(titulo_precio_total);
        
        
        mostrarInfo = new JButton("Mostrar info");
        mostrarInfo.setFont(new Font("Arial", Font.BOLD, 17));
        mostrarInfo.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarInfo.setBackground(new Color(207, 207, 207));
        mostrarInfo.setForeground(Color.BLACK);
        mostrarInfo.setBounds(625, 450, 140, 60);
        add(mostrarInfo);
        
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
        
        ratonEncima(mostrarInfo);
        ratonEncima(pagar);
        
        ratonEncima2(volver);
        
        
        
        mostrarInfo.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        		CarritoEnteroFrame carritoEnteroFrame = new CarritoEnteroFrame();
        		carritoEnteroFrame.setVisible(true);
        	}
        	
        });
        
        pagar.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        	    MetodoPagoFrame metodoPagoFrame = new MetodoPagoFrame();
        	    metodoPagoFrame.setVisible(true);
        	}
        	
        });
        
        volver.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        	    // Cambiar el panel visible
        		Window window = SwingUtilities.getWindowAncestor(Carrito.this);
        		window.dispose();
        		
        	    
        	}
        	
        });
        
	}
	
	public void recargarCarrito() {
        // Limpia el contenido del panel
        this.removeAll();
        // Vuelve a cargar los datos del carrito
        
        // Refresca el panel
        this.revalidate();
        this.repaint();
    }
	
	public void mostrarProductosCarrito() {
        Connection conexionnn = conexion.conectar();
        totalPrecio = 0;

        if (conexionnn != null) {
            try {
                String consultasSeleccion = "SELECT c.id_carrito, p.nombre, p.precio FROM carrito c JOIN producto p ON c.id_producto = p.id_producto WHERE c.id_usuario = " + CogerIdUsuario.getIdUsuario();
                System.out.println(consultasSeleccion);
                Statement consul = conexionnn.createStatement();

                if (consul.execute(consultasSeleccion)) {
                    ResultSet resultset = consul.getResultSet();
                    System.out.println("\nPRODUCTOS EN EL CARRITO");

                    String[] columnNames = {"ID Carrito", "Camiseta", "Precio", "Acciones"};
                    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column == 3;
                        }
                    };

                    while (resultset.next()) {
                        int idCarrito = resultset.getInt("id_carrito");
                        String nombreProducto = resultset.getString("nombre");
                        int precioProducto = resultset.getInt("precio");

                        tableModel.addRow(new Object[]{idCarrito, nombreProducto, precioProducto + "€", "ELIMINAR"});
                        totalPrecio += precioProducto;
                    }

                    JTable table = new JTable(tableModel);
                    table.setRowHeight(25);
                    table.setFillsViewportHeight(true);
                    table.setFont(new Font("Arial", Font.PLAIN, 14));

                    JTableHeader tableHeader = table.getTableHeader();
                    tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30)); //Ajustar la altura del encabezado de la tabla
                    tableHeader.setFont(new Font("Arial", Font.BOLD, 18));
                    tableHeader.setForeground(Color.BLACK);
                    tableHeader.setBackground(new Color(167, 167, 167));

                    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                        @Override
                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                            return c;
                        }
                    });

                    // Añadir el renderizador y el editor del botón
                    table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
                    table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), tableModel, table));

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setBounds(100, 325, 500, 300);
                    add(scrollPane);

                    precioTotalLabel = new JLabel(totalPrecio + "€");
                    precioTotalLabel.setFont(new Font("Arial", Font.BOLD, 40));
                    precioTotalLabel.setForeground(Color.BLACK);
                    precioTotalLabel.setBounds(625, 330, 300, 35);
                    add(precioTotalLabel);

                    revalidate();
                    repaint();

                    System.out.println("\nDatos recuperados correctamente");
                    resultset.close();
                    consul.close();
                } else {
                    System.out.println("\nError al recuperar los datos");
                }
                consul.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarConexion(conexionnn);
            }
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setBackground(new Color(241, 39, 39));
            setFont(new Font("Arial", Font.BOLD, 14));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
    	private String label;
        private boolean isPushed;
        private int currentRow;
        private DefaultTableModel tableModel;
        private JTable table;
        private JButton button;

        public ButtonEditor(JCheckBox checkBox, DefaultTableModel tableModel, JTable table) {
            super(checkBox);
            this.tableModel = tableModel;
            this.table = table;
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(Color.RED); // Color de fondo del botón
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    eliminarProducto(currentRow);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            currentRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        private void eliminarProducto(int row) {
            int idCarrito = (int) tableModel.getValueAt(row, 0); // Obtén el ID del carrito desde la tabla
            Connection conexionnn = conexion.conectar();
            if (conexionnn != null) {
                try {
                	String eliminarSQL = "DELETE FROM carrito WHERE id_carrito = " + idCarrito;
                    Statement eliminarStmt = conexionnn.createStatement();
                    eliminarStmt.executeUpdate(eliminarSQL);
                    int precio = Integer.parseInt(tableModel.getValueAt(row, 2).toString().replace("€", ""));
                    totalPrecio -= precio;
                    tableModel.removeRow(row);
                    precioTotalLabel.setText(totalPrecio + "€");
                    eliminarStmt.close();
                    table.revalidate();
                    table.repaint();
                    System.out.println("Producto eliminado correctamente");
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conexion.cerrarConexion(conexionnn);
                }
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
