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

import Aplicacion.Usuarios;
import Persistencia.SqlUsuarios;

public class Principal extends JFrame{
	
	public JDesktopPane DP;
	private JMenuBar barra;
	public JMenu mInicio, mRegistros, mAdmin, mInfo;
	public JMenuItem iCerrar, iAgregarP, iAgregarOb, iAgregarAs, iModPlaneta, iModAs, iModOb;
	
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
		mRegistros = new JMenu("Registros");
		mAdmin = new JMenu("Administración");
		mInfo = new JMenu("Informes");
		
		mInicio.setVisible(false); /** Menu inicia invisible, se habilitará solo cuando se inicie sesion **/
		mRegistros.setVisible(false); /** Menu Planetas invisible, se habilitará solo cuando se inicie sesion **/
		mAdmin.setVisible(false); /** Menu administración invisible, se habilitara solo cuando se inicie sesion **/
		mInfo.setVisible(false); /** Menu informes invisible, se habiliatara solo cuando se inicie sesion **/
		
		// Creacion de los Items
		/** Pestaña Inicio **/
		ImageIcon iCerraI = new ImageIcon("imagenes/icon_logout.png");
		iCerrar = new Plantilla_MenuItem(iCerraI, "Cerrar Sesión");
		iCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Logout();
			}
		});
		
		mInicio.add(iCerrar);
		
		/** Pestaña Registros **/
		ImageIcon iAdd = new ImageIcon("imagenes/icon_add.png");
		iAgregarP = new Plantilla_MenuItem(iAdd, "Agregar Planeta");
		iAgregarP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_agPlaneta();
			}
			
		});
		
		iAgregarOb = new Plantilla_MenuItem(iAdd, "Agregar Observacion");
		iAgregarOb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_agObservacion();
			}
			
		});
		
		mRegistros.add(iAgregarP);
		mRegistros.add(iAgregarOb);
		
		/** Pestaña Administración **/
		iAgregarAs = new Plantilla_MenuItem(iAdd, "Agregar Astronomo");
		iAgregarAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_agAstronomo();
			}
			
		});
		
		ImageIcon iMod = new ImageIcon("imagenes/icon_mod.png");
		iModAs = new Plantilla_MenuItem(iMod, "Modificar Astronomo");	
		iModAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_modAstronomo();
			}
			
		});
		iModOb = new Plantilla_MenuItem(iMod, "Modificar Observacion");
		iModOb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_modObservacion();
			}
			
		});
		iModPlaneta = new Plantilla_MenuItem(iMod, "Modificar Planeta");
		iModPlaneta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrir_modPlaneta();
			}
			
		});
		
		mAdmin.add(iAgregarAs);
		mAdmin.addSeparator();
		mAdmin.add(iModAs);
		mAdmin.add(iModOb);
		mAdmin.add(iModPlaneta);
		
		//Agregar menu a la barra	
		barra.add(mInicio);
		barra.add(mRegistros);
		barra.add(mAdmin);
		barra.add(mInfo);
		this.dibuja_frame();
		this.setVisible(true);
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
	
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		Image icono = icon.getImage();
		
		this.setIconImage(icono);
	}
	
	public void abrir_Login() {
		//Login L = new Login();
		Login L = new Login();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = L.getSize();
		L.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(L);
		
	}
	
	public void abrir_agPlaneta() {
		Agregar_Planeta AG = new Agregar_Planeta();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
	}
	
	public void abrir_agObservacion() {
		Agregar_Observacion AG = new Agregar_Observacion();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
	}
	
	public void abrir_agAstronomo() {
		Agregar_Astronomo AG = new Agregar_Astronomo();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
		
	}
	
	public void abrir_modAstronomo() {
		Modificar_Astronomo AG = new Modificar_Astronomo();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
		
	}
	
	public void abrir_modObservacion() {
		Modificar_Observacion AG = new Modificar_Observacion();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
		
	}
	
	public void abrir_modPlaneta() {
		Modificar_Planetas AG = new Modificar_Planetas();
		Dimension desktopSize = DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		DP.add(AG);
	}
	
	public void Logout() {
		abrir_Login();
		this.mInicio.setVisible(false);
		this.mAdmin.setVisible(false);
		this.mInfo.setVisible(false);
		this.mRegistros.setVisible(false);

	}
}
