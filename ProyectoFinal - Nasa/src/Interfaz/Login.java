package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Aplicacion.Usuarios;
import Aplicacion.Validaciones;
import Interfaz.Plantilla_JButton;
import Persistencia.SqlUsuarios;
import Persistencia.conexion;

public class Login extends JInternalFrame {
	
	JPanel panel, pContent, pUser, pPass, pBtn, pLogo;
	JLabel lUser, lPass, lLogo;
	JTextField tUser, tPass;
	JButton btn_Login, btn_Invitado;
	
	public Login() {
		super("Inicio de Sesión");
		
		// Creacion de paneles
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pLogo = new JPanel();
		pUser = new JPanel(); /** Panel contenido usuario **/
		pPass = new JPanel(); /** Panel contenido password **/
		pBtn = new JPanel(); /** Panel Botones **/
		
		
		// Creacion Panel de Logo
		lLogo = new JLabel();
		ImageIcon iLogo = new ImageIcon("imagenes/logo_analista.png");
		int alto = 179;
		int ancho = 245;
		ImageIcon logo = new ImageIcon(iLogo.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
		lLogo.setIcon(logo);
		pLogo.add(lLogo);
		
		// Creacion de Label y TextField
		// Usuario
		lUser = new JLabel("Usuario:");
		lUser.setPreferredSize(new Dimension(80, 20));
		
		tUser = new JTextField(15);
		
		pUser.add(lUser);
		pUser.add(tUser);
		
		// Password
		lPass = new JLabel("Contraseña:");
		lPass.setPreferredSize(new Dimension(80, 20));
		
		tPass = new JTextField(15);
		
		pPass.add(lPass);
		pPass.add(tPass);
		
		// Botones
		ImageIcon iconobtn = new ImageIcon("imagenes/icon_login.png");
		btn_Login = new Plantilla_JButton(iconobtn, "Iniciar Sesión");
		btn_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		
		ImageIcon iconobtn2 = new ImageIcon("imagenes/icon_invitado.png");
		btn_Invitado = new Plantilla_JButton(iconobtn2, "Invitado");
		btn_Invitado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
				
				P.mInfo.setVisible(true);
				P.mInicio.setVisible(true);
				dispose();
			}
		});
		
		pBtn.add(btn_Login);
		pBtn.add(btn_Invitado);
		
		// Agregar paneles a panel contenido
		pContent.add(pLogo);
		pContent.add(pUser);
		pContent.add(pPass);
		pContent.add(pBtn);
		
		
		// Agregar a  Panel principal
		panel.add(pContent);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		//this.dibuja_frame();
		pack();
		this.poner_icono();
		

	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
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
				SqlUsuarios modSql = new SqlUsuarios();
				Usuarios mod = new Usuarios();
				
				mod.setUsername(user);
				mod.setPassword(pass);
				
				if (modSql.login(mod)) {
					if (mod.getTipoUser() == 1) {
						P.mInicio.setVisible(true);
						P.mAdmin.setVisible(true);
						P.mRegistros.setVisible(true);
						P.mInfo.setVisible(true);
						this.dispose();
					} else if(mod.getTipoUser() == 2) {
						P.mInicio.setVisible(true);
						P.mRegistros.setVisible(true);
						P.mInfo.setVisible(true);
						this.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usuario y/o contraseña Incorrecto");
				}
		}
	}
}
