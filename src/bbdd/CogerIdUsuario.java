package bbdd;

public class CogerIdUsuario {
	
		private static int idUsuario = -1; // Valor por defecto
	
		public CogerIdUsuario() {
    	
		}
		
	    public static void setIdUsuario(int idUsuario) {
	    	CogerIdUsuario.idUsuario = idUsuario;
	    }

	    public static int getIdUsuario() {
	        return idUsuario;
	    }
	    
	    
	
}
