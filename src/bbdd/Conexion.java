package bbdd;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.LaLiga;
/*
import vista.ResultSet;
import vista.SQLException;
import vista.Statement;
*/
public class Conexion {

		//driver JDBC
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		//dirección de la BBDD MySQL
		private static final String URL = "jdbc:mysql://localhost:3306/LaRedonda";
		//usuario y contraseña de acceso a la BD
		private static final String USUARIO = "root";
		private static final String PASSWORD = "";
	
		public static Connection conectar() {
			Connection conexion = null;

			try {
				Class.forName(DRIVER);
				conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				System.out.println("\nConexión OK\n");

			} catch (ClassNotFoundException e) {
				System.out.println("\nError al cargar el controlador\n");
				e.printStackTrace();

			} catch (SQLException e) {
				System.out.println("\nError en la conexión\n");
				e.printStackTrace();
			}

			return conexion;
		}
		
		public static void cerrarConexion(Connection conection){
			try {
				//Cierre de la conexión
				conection.close();
			} catch (SQLException e) {
				System.err.println("\nSe ha producido un error al cerrar la conexión");
				
			}
		}

		
		
//Registrarse
		
		//Con este método guardo en la base de datos los datos de los usuarios que se registran.
		public boolean insertDataRegistrarse(String nombre_usuario, String contraseña_usuario, String nombre, String apellidos, int telefono, String correo) throws SQLException {
		    Connection conexion = conectar();
		    boolean registrado = false;
		    
		    try {
		        // Verificar si el usuario ya existe
		        String consultaVerificar = "SELECT * FROM usuario WHERE nombre_usuario = ? OR correo = ?";
		        PreparedStatement statementVerificar = conexion.prepareStatement(consultaVerificar);
		        statementVerificar.setString(1, nombre_usuario);
		        statementVerificar.setString(2, correo);
		        ResultSet rs = statementVerificar.executeQuery();
		        
		        if (rs.next()) {
		            JOptionPane.showMessageDialog(null, "El nombre de usuario o el correo electrónico ya están en uso");
		        } else {
		            // Datos a insertar
		            String consultasInserccion = "INSERT INTO usuario (nombre_usuario, contraseña_usuario, nombre, apellidos, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)";
		            PreparedStatement statementInserccion = conexion.prepareStatement(consultasInserccion);
		            statementInserccion.setString(1, nombre_usuario);
		            statementInserccion.setString(2, contraseña_usuario);
		            statementInserccion.setString(3, nombre);
		            statementInserccion.setString(4, apellidos);
		            statementInserccion.setInt(5, telefono);
		            statementInserccion.setString(6, correo);

		            // Ejecución de la consulta
		            int filasAfectadas = statementInserccion.executeUpdate();
		            if (filasAfectadas > 0) {
		                System.out.println("Datos insertados correctamente");
		                JOptionPane.showMessageDialog(null, "Usuario añadido con éxito.");
		                registrado = true;
		            } else {
		                System.out.println("No se han insertado datos");
		            }
		            
		            // Cierre del PreparedStatement
		            statementInserccion.close();
		        }
		                
		        // Cierre del ResultSet y del PreparedStatement
		        rs.close();
		        statementVerificar.close();
		    } finally {
		        // Cierre de la conexión
		        cerrarConexion(conexion);
		    }
		    
		    return registrado;
		}
		
		
		public void getDataRegistrarse() throws SQLException{
			Connection conexion = conectar();

			if(conexion!=null) {
				try {
					//Datos a consultar
					String consultasSeleccion = "SELECT * FROM usuario";
					System.out.println(consultasSeleccion);
					Statement consul = conexion.createStatement();
					//Ejecución de la consulta
						if(consul.execute(consultasSeleccion)) {
							ResultSet resultset = consul.getResultSet();
							System.out.println("\nUSUARIOS");
							while(resultset.next()) {
								int idUsuario = resultset.getInt("id_usuario");
		                        String nombreUsuario = resultset.getString("nombre_usuario");
		                        String contrasenaUsuario = resultset.getString("contraseña_usuario");
		                        String nombre = resultset.getString("nombre");
		                        String apellidos = resultset.getString("apellidos");
		                        int telefono = resultset.getInt("telefono");
		                        String correo = resultset.getString("correo");
		                        
		                        System.out.println("ID Usuario: " + idUsuario + ", Nombre Usuario: " + nombreUsuario + ", Contraseña Usuario: " + contrasenaUsuario + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Teléfono: " + telefono + ", Correo: " + correo);
							}					
							System.out.println("\nDatos recuperados correctamente");
						} else {
							System.out.println("\nError al recuperar los datos");
						}
					//Cierre del Statement
						consul.close();
					
				}finally {
					//Cierre de la conexión
					cerrarConexion(conexion);
				}
			}
		}
		
		

//Verificación usuario
		
		public boolean verificarUsuario(String usuario, String correo, String contrasenia) throws SQLException {
	        Connection conexion = conectar();
	        boolean usuarioExiste = false;

	        try {
	            String consulta = "SELECT * FROM usuario WHERE nombre_usuario = ? AND correo = ? AND contraseña_usuario = ?";
	            PreparedStatement statement = conexion.prepareStatement(consulta);
	            statement.setString(1, usuario);
	            statement.setString(2, correo);
	            statement.setString(3, contrasenia);

	            ResultSet resultado = statement.executeQuery();
	            usuarioExiste = resultado.next();
	        } finally {
	            cerrarConexion(conexion);
	        }

	        return usuarioExiste;
	    }
		

		
//Producto
		
		public void getDataProducto() throws SQLException{
			Connection conexion = conectar();

			if(conexion!=null) {
				try {
					//Datos a consultar
					String consultasSeleccion = "SELECT * FROM producto";
					System.out.println(consultasSeleccion);
					Statement consul = conexion.createStatement();
					//Ejecución de la consulta
						if(consul.execute(consultasSeleccion)) {
							ResultSet resultset = consul.getResultSet();
							System.out.println("\nPRODUCTOS");
							while(resultset.next()) {
								// Imprimir los datos directamente
		                        int idProducto = resultset.getInt("id_producto");
		                        String nombre = resultset.getString("nombre");
		                        String liga = resultset.getString("liga");
		                        int precio = resultset.getInt("precio");

		                        System.out.println("ID Producto: " + idProducto + ", Nombre: " + nombre + ", Liga: " + liga + ", Precio: " + precio);					
							}					
							System.out.println("\nDatos recuperados correctamente");
						} else {
							System.out.println("\nError al recuperar los datos");
						}
					//Cierre del Statement
						consul.close();
					
				}finally {
					//Cierre de la conexión
					cerrarConexion(conexion);
				}
			}
		}
		
		
		
//Carrito
		
		public void aniadirCarrito(int IDProducto) throws SQLException {
		    Connection conexion = conectar();

		    if (conexion != null) {
		        try {
		            // Obtener el ID del usuario
		            int IDUsuario = CogerIdUsuario.getIdUsuario();

		            // Consulta para insertar el producto en el carrito
		            String consulta = "INSERT INTO carrito (id_usuario, id_producto) VALUES (?, ?)";
		            PreparedStatement statement = conexion.prepareStatement(consulta);
		            statement.setInt(1, IDUsuario);
		            statement.setInt(2, IDProducto);

		            // Ejecutar la consulta
		            statement.executeUpdate();
		            System.out.println("Producto añadido al carrito correctamente");
		            getDataCarrito();

		        } finally {
		            // Cerrar la conexión
		            cerrarConexion(conexion);
		        }
		    }
		}
		
		public static int guardarIdUsuario(String nombreUsuario) {
	        System.out.println("Usuario activo: " + nombreUsuario);
	        Connection conexion = conectar();
	        int idUsuario = -1; // Valor por defecto en caso de error

	        if (conexion!= null) {
	            try {
	                String consulta = "SELECT id_usuario FROM usuario WHERE nombre_usuario =?";
	                PreparedStatement statement = conexion.prepareStatement(consulta);
	                statement.setString(1, nombreUsuario);

	                ResultSet resultSet = statement.executeQuery();
	                if (resultSet.next()) {
	                    idUsuario = resultSet.getInt("id_usuario");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                cerrarConexion(conexion);
	            }
	        }

	        return idUsuario;
	    }
		
		
		public void getDataCarrito() throws SQLException{
			Connection conexion = conectar();

			if(conexion!=null) {
				try {
					//Datos a consultar
					String consultasSeleccion = "SELECT * FROM carrito WHERE id_usuario = " + CogerIdUsuario.getIdUsuario();
					System.out.println(consultasSeleccion);
					Statement consul = conexion.createStatement();
					//Ejecución de la consulta
						if(consul.execute(consultasSeleccion)) {
							ResultSet resultset = consul.getResultSet();
							System.out.println("\nCARRITO");
							while(resultset.next()) {
								int idCarrito = resultset.getInt("id_carrito");
		                        int idUsuario = resultset.getInt("id_usuario");
		                        int idProducto = resultset.getInt("id_producto");

		                        System.out.println("ID Carrito: " + idCarrito + ", ID Usuario: " + idUsuario + ", ID Producto: " + idProducto);	
							}					
							System.out.println("\nDatos recuperados correctamente");
						} else {
							System.out.println("\nError al recuperar los datos");
						}
					//Cierre del Statement
						consul.close();
					
				}finally {
					//Cierre de la conexión
					cerrarConexion(conexion);
				}
			}
		}
		
		
		
		
		
//Forma de pago
		
		public void getDataFormaPago() throws SQLException {
	        Connection conexion = conectar();

	        if (conexion != null) {
	            try {
	                // Datos a consultar
	                String consultasSeleccion = "SELECT * FROM formaPago";
	                System.out.println(consultasSeleccion);
	                Statement consul = conexion.createStatement();
	                // Ejecución de la consulta
	                if (consul.execute(consultasSeleccion)) {
	                    ResultSet resultset = consul.getResultSet();
	                    System.out.println("\nFORMA DE PAGO");
	                    while (resultset.next()) {
	                        // Obtener los datos y mostrarlos en una sola línea
	                        int idFormaPago = resultset.getInt("id_formaPago");
	                        String metodo = resultset.getString("metodo");
	                        int saldo = resultset.getInt("saldo");
	                        int idUsuario = resultset.getInt("id_usuario");
	                        System.out.println("ID Forma de Pago: " + idFormaPago + ", Método: " + metodo + ", Saldo: " + saldo + ", ID Usuario: " + idUsuario);
	                    }
	                    System.out.println("\nDatos recuperados correctamente");
	                } else {
	                    System.out.println("\nError al recuperar los datos");
	                }
	                // Cierre del Statement
	                consul.close();

	            } finally {
	                // Cierre de la conexión
	                cerrarConexion(conexion);
	            }
	        }
		}
}
