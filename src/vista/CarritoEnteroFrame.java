package vista;

import javax.swing.JFrame;

public class CarritoEnteroFrame extends JFrame{
	
	private CarritoEntero JPanelCarritoEntero = new CarritoEntero();
	
    public CarritoEnteroFrame() {
    	setSize(1000,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("La Redonda");
        
        add(JPanelCarritoEntero);
    
        JPanelCarritoEntero.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Principal();
	}

}
