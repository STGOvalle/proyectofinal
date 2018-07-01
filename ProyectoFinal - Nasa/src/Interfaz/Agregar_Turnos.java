package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Aplicacion.Controladora;
import Aplicacion.Turnos;
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;

public class Agregar_Turnos extends JInternalFrame {
	
	JPanel pPrincipal, pContent, pUsuario, pTComienzo, pTFinal, pDComienzo, pDFinal, pBtn;
	JLabel lUsuario, lTComienzo, lTFinal, lDComienzo, lDFinal;
	JComboBox cAstronomo;
	JTextField tTComienzo, tTFinal, tDComienzo, tDFinal;
	JButton btnGuardar, btnLimpiar;

	public Agregar_Turnos() {
		super("Agregar Turnos", false, true, false);
		
		/**Creacion de Paneles **/
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pUsuario = new JPanel();
		pTComienzo = new JPanel();
		pTFinal = new JPanel();
		pDComienzo = new JPanel();
		pDFinal = new JPanel();
		pBtn = new JPanel();
		
		
		/** Creacion de labels **/
		lUsuario = new JLabel("Astronomo:");
		lUsuario.setPreferredSize(new Dimension(130, 20));
		lTComienzo = new JLabel("Comienzo Turno:");
		lTComienzo.setPreferredSize(new Dimension(130, 20));
		lTFinal = new JLabel("Final Turno:");
		lTFinal.setPreferredSize(new Dimension(130, 20));
		lDComienzo = new JLabel("Inicio Descanso:");
		lDComienzo.setPreferredSize(new Dimension(130, 20));
		lDFinal = new JLabel("Final Descanso:");
		lDFinal.setPreferredSize(new Dimension(130, 20));
		
		/** ComboBox con astronomos **/
		cAstronomo = new JComboBox();
		cAstronomo.setPreferredSize(new Dimension(115, 20));
		
		/** TextFields **/
		tTComienzo = new JTextField(10);
		tTFinal = new JTextField(10);
		tDComienzo = new JTextField(10);
		tDFinal = new JTextField(10);
		
		/** Botones **/

		/** Botones **/
		ImageIcon iSave = new ImageIcon("imagenes/icon_save.png");
		btnGuardar = new Plantilla_JButton(iSave, "Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enviar_Form();
			}
			
		});
		
		ImageIcon iLimpiar = new ImageIcon("imagenes/icon_limpiar.png");
		btnLimpiar = new Plantilla_JButton(iLimpiar, "Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Limpiar();				
			}
			
		});
		
		/** Agrego a paneles **/
		pUsuario.add(lUsuario);
		pUsuario.add(cAstronomo);
		pTComienzo.add(lTComienzo);
		pTComienzo.add(tTComienzo);
		pTFinal.add(lTFinal);
		pTFinal.add(tTFinal);
		pDComienzo.add(lDComienzo);
		pDComienzo.add(tDComienzo);
		pDFinal.add(lDFinal);
		pDFinal.add(tDFinal);
		pBtn.add(btnGuardar);
		pBtn.add(btnLimpiar);
		
		/** Agrego a panel content **/
		pContent.add(pUsuario);
		pContent.add(pTComienzo);
		pContent.add(pTFinal);
		pContent.add(pDComienzo);
		pContent.add(pDFinal);
		pContent.add(pBtn);
		
		/** Agrego panel principal **/
		pPrincipal.add(pContent);
		/** Agrego a layout **/
		add(pPrincipal, BorderLayout.CENTER);
		
		/** Agrega visibilidad **/
		this.setVisible(true);
		this.pack();
		/** Llama metodo de poner icono **/
		this.poner_icono();
		this.llenar_combo();
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
	}
	
	private void llenar_combo() {
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getAstronomos();
		
		Usuarios obj_temp;
		for(int i=0; i<data.size(); i++) {
			obj_temp = (Usuarios)data.get(i);
			cAstronomo.addItem(new Usuarios(obj_temp.getId(), obj_temp.getNombre(), obj_temp.getApellido()));
		}
	}
	
	private void Enviar_Form() {
		Validaciones val = new Validaciones();
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		
		if(!val.campoVacio(this.tTComienzo.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Comienzo Turno no puede estar vacio.");
		} else if (!val.fechaTurno(this.tTComienzo.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Comienzo Turno no es una fecha válida.");
		} else if (!val.campoVacio(this.tTFinal.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Final Turno no puede estar vacio.");
		} else if (!val.fechaTurno(this.tTFinal.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Final Turno no es una fecha válida.");
		} else if (!val.campoVacio(this.tDComienzo.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Comienzo Descanso no puede estar vacio.");
		} else if (!val.fechaTurno(this.tDComienzo.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Comienzo Descanso no es una fecha válida.");
		} else if (!val.campoVacio(this.tDFinal.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Final Descanso no puede estar vacio.");
		} else if (!val.fechaTurno(this.tDFinal.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Final Descanso no es una fecha válida.");
		} else {
			Controladora ctrl = new Controladora();
			
			// Obtengo id del astronomo
			Usuarios usr = (Usuarios)cAstronomo.getSelectedItem();
			
			boolean res = ctrl.crearTurno(new Turnos(
					usr.getId(),
					this.tTComienzo.getText(),
					this.tTFinal.getText(),
					this.tDComienzo.getText(),
					this.tDFinal.getText()
					));
			
			if(res) {
				JOptionPane.showInternalMessageDialog(p.DP, "El turno se ha agregado correctamente.");
			} else {
				JOptionPane.showInternalMessageDialog(p.DP, "Un error ocurrio al intentar crear el turno, vuelve a intentarlo.");
			}
		}
	}
}
