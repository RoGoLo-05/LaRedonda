package vista;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import bbdd.Conexion;


public class Principal extends JFrame{
	
    Inicio inicio = new Inicio(this);
    IniciarSesion inicioSesion = new IniciarSesion(this); 
    Registrarse registrar = new Registrarse(this);
    Home home = new Home(this);
    LaLiga laliga = new LaLiga(this);
    PremierLeague premierleague = new PremierLeague(this);
    SerieA seriea = new SerieA(this);
    Bundesliga bundesliga = new Bundesliga(this);
    Ligue1 ligue1 = new Ligue1(this);
	Clip clip;
    
    public Principal() {
    	
    	 try {
             File audioFile = new File("src/musica/HimnoFondo.wav");
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
             clip = AudioSystem.getClip();
             clip.open(audioStream);
             clip.loop(Clip.LOOP_CONTINUOUSLY);
         } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
             e.printStackTrace();
         }
    	
    	
    	setSize(1000,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("La Redonda");
        
        add(inicio);
    
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }
    
    public void cambiarPanel(JPanel panel) {
        getContentPane().removeAll(); // Eliminar todos los componentes actuales
        add(panel); // Agregar el nuevo panel
        revalidate(); // Refrescar el contenedor
        repaint(); // Redibujar el contenedor
    }

	
	public static void main(String[] args) {
		new Principal();
	}

}


