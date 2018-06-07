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
	
	JPanel panel, pContent, pUser, pPass, pBtn;
	JLabel lUser, lPass;
	JTextField tUser, tPass;
	JButton btn_Login, btn_Invitado;
	
	public Login() {
		super("Inicio de Sesión");
		
		// Creacion de paneles
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pUser = new JPanel(); /** Panel contenido usuario **/
		pPass = new JPanel(); /** Panel contenido password **/
		pBtn = new JPanel(); /** Panel Botones **/
		
		// Creacion de Label y TextField
		// Usuario
		lUser = new JLabel("Usuario:");
		lUser.setPreferredSize(new Dimension(80, 20));
		
		tUser = new JTextField(20);
		
		pUser.add(lUser);
		pUser.add(tUser);
		
		// Password
		lPass = new JLabel("Contraseña:");
		lPass.setPreferredSize(new Dimension(80, 20));
		
		tPass = new JTextField(20);
		
		pPass.add(lPass);
		pPass.add(tPass);
		
		// Botones
		btn_Login = new JButton("Iniciar");
		btn_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		
		btn_Invitado = new JButton("Invitado");
		
		pBtn.add(btn_Login);
		pBtn.add(btn_Invitado);
		
		// Agregar paneles a panel contenido
		pContent.add(pUser);
		pContent.add(pPass);
		pContent.add(pBtn);
		
		
		// Agregar a  Panel principal
		panel.add(pContent);
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
		
		pack();
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
