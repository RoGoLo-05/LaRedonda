package vista;

import javax.swing.JFrame;

public class CompraRealizadaFrame extends JFrame{

private CompraRealizada compraRealizada = new CompraRealizada();
	
    public CompraRealizadaFrame() {
    	setSize(1000,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("La Redonda");
        
        add(compraRealizada);
    
        compraRealizada.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Principal();
	}
	
}
