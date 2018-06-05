package Interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class Principal extends JFrame{
	
	private JDesktopPane DP;
	private JMenuBar barra;
	public JMenu mInicio;
	public JMenuItem iCerrar;
	
	public Principal() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		/** Poner Icono **/
		this.poner_icono();
		
		
		/** Creación del Desktop **/
		DP = new JDesktopPane() {
			ImageIcon icon = new ImageIcon("imagenes/wallpaper-nasa.jpg");
			Image image = icon.getImage();
			
			
			@Override
			protected void paintComponent(Graphics  g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		this.setTitle("NASA CHILE"); /** Setea el titulo **/
		this.setContentPane(DP); /** Setea el Desktop **/
		
		// Creacion de la barra del menu
		barra = new JMenuBar();
		this.setJMenuBar(barra);
		
		// Creacion de los Menu
		mInicio = new JMenu("Inicio");
		
		mInicio.setVisible(false); /** Menu inicia invisible, se habilitará solo cuando se inicie sesion **/
		
		// Creacion de los Items
		/** Pestaña Inicio **/
		iCerrar = new JMenuItem("Cerrar Sesion");
		iCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Logout();
			}
		});
		
		mInicio.add(iCerrar);
		
		//Agregar menu a la barra	
		barra.add(mInicio);
		
		this.abrir_Login();
		
	}
	
	public void dibuja_frame() {
		// Asigna tamaño y posicionamiento
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		setSize(frame_anchura / 2, frame_altura / 2);
		//pack();
		setLocation(frame_anchura / 4, frame_altura / 4);
	}
	
	public static void main(String [] args) {
		
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		Principal P = new Principal();
		P.dibuja_frame();
		P.setVisible(true);
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		Image icono = icon.getImage();
		
		this.setIconImage(icono);
	}
	
	public void abrir_Login() {
		Login L = new Login();
		DP.add(L);
	}
	
	public void Logout() {
		abrir_Login();
		this.mInicio.setVisible(false);
	}
}
