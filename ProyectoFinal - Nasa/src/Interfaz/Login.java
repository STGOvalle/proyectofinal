package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class Login extends JInternalFrame {
	
	JPanel jPrincipal, jPanelIzq, jPanelDer, jUser, jPass;
	JLabel lUser, lPass;
	JTextField tUser, tPass;
	JButton btn_Login, btn_Invitado;
	
	public Login() {
		super("Inicio de caca");
		
		// Creacion de Paneles
		//jPrincipal = new JPanel();
		
		jPanelIzq = new JPanel();
		jPanelIzq.setLayout(null);
		
		/** Paneles Izquierdos **/
		//jUser = new JPanel();
		//jPass = new JPanel();
		
		jPanelDer = new JPanel();
		
		// Panel izquierdo
		lUser = new JLabel("Usuario:");
		lUser.setBounds(40, 20, 60, 20);
		lPass = new JLabel("Contrase�a:");
		lPass.setBounds(40, 50, 80, 20);
		tUser = new JTextField();
		tUser.setBounds(150, 20, 100, 20);
		tPass = new JTextField();
		tPass.setBounds(150, 50, 100, 20);
		
		btn_Login = new JButton("Iniciar");
		btn_Login.setBounds(40, 80, 100, 30);
		
		btn_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
				P.mInicio.setVisible(true);
				dispose(); /** Cerrar internal Frame **/
			}
		});
		
		btn_Invitado = new JButton("Invitado");
		btn_Invitado.setBounds(150, 80, 100, 30);
		

		jPanelIzq.add(lUser);
		jPanelIzq.add(tUser);
		jPanelIzq.add(lPass);
		jPanelIzq.add(tPass);
		jPanelIzq.add(btn_Login);
		jPanelIzq.add(btn_Invitado);
		
		
		// Agregar a  Panel principal
		
		
		add(jPanelIzq, BorderLayout.CENTER);
		setVisible(true);
		this.dibuja_frame();
	}

	public void dibuja_frame() {
		// Asigna tama�o y posicionamiento
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		setSize(300,170);
		//pack();
		setLocation(frame_anchura / 6, frame_altura / 6);
	}
}
