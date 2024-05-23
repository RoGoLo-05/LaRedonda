package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MetodoPagoFrame extends JFrame{

	private MetodoPago JPanelMetodoPago = new MetodoPago(this);
	
	public MetodoPagoFrame() {
    	setSize(1000,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("La Redonda");
        
        add(JPanelMetodoPago);
    
        JPanelMetodoPago.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }
    
	public static void main(String[] args) {
		new Principal();
	}
	
}
