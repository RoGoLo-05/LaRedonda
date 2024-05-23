package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class CompraRealizada extends JPanel{
	
	public PanelImagen panelFondo;
	private Principal principal;
	 
	public JLabel titulo;
	public JLabel logo;
	
	public JLabel subtitulo;
	public JLabel subtitulo2;
	
	public JButton volver;
	
	public CompraRealizada() {
		
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
        subtitulo = new JLabel("¡Compra realizada!");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 40));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setBounds(325, 200, 400, 115);
        add(subtitulo);
        
        subtitulo2 = new JLabel("Gracias por confiar en nosotros");
        subtitulo2.setFont(new Font("Arial", Font.ITALIC, 30));
        subtitulo2.setForeground(Color.BLACK);
        subtitulo2.setBounds(288, 300, 450, 115);
        add(subtitulo2);
        
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
        		Window window = SwingUtilities.getWindowAncestor(CompraRealizada.this);
        		window.dispose();
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
