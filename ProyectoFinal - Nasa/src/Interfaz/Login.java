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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Aplicacion.Validaciones;

public class Login extends JInternalFrame {
	
	JPanel panel;
	JLabel lUser, lPass;
	JTextField tUser, tPass;
	JButton btn_Login, btn_Invitado;
	
	public Login() {
		super("Inicio de Sesión");
		
		// Creacion de Paneles
		//jPrincipal = new JPanel();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		// Panel izquierdo
		lUser = new JLabel("Usuario:");
		lUser.setBounds(40, 20, 60, 20);
		lPass = new JLabel("Contraseña:");
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
				Login();
			}
		});
		
		btn_Invitado = new JButton("Invitado");
		btn_Invitado.setBounds(150, 80, 100, 30);
		

		panel.add(lUser);
		panel.add(tUser);
		panel.add(lPass);
		panel.add(tPass);
		panel.add(btn_Login);
		panel.add(btn_Invitado);
		
		
		// Agregar a  Panel principal
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		this.dibuja_frame();
	}

	public void dibuja_frame() {
		// Asigna tamaño y posicionamiento
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		setSize(300,170);
		//pack();
		setLocation(frame_anchura / 6, frame_altura / 6);
	}
	
	public void Login() {
		Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
		
		String user = tUser.getText();
		String pass = tPass.getText();
		
		Validaciones Val = new Validaciones();
		
		if (Val.campoVacio(user) == false || Val.campoVacio(pass) == false) {
			JOptionPane.showMessageDialog(null, "No puedes dejar Campos Vacios");
		} else if (Val.soloString(user) == false) {
			JOptionPane.showMessageDialog(null, "El campo usuario, solo debe contener letras.");
		} else {
			P.mInicio.setVisible(true);
			dispose(); /** Cerrar internal Frame **/
		}
	}
}
