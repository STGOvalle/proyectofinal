package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Aplicacion.Controladora;
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;

public class Agregar_Astronomo extends JInternalFrame {
	
	JPanel panel, pContent, pNombre, pApellido, pRut, pEdad, pFNacimiento, pNacionalidad, pCarrera, pPass, pBtn;
	JLabel lNombre, lApe, lRut, lEdad, lFNa, lNa, lCarr, lPass;
	JTextField tNombre, tApe, tRut, tEdad, tFNa, tNa, tCarr, tPass;
	JButton btnGuardar, btnLimpiar;
	
	Validaciones val;
	
	public Agregar_Astronomo(){
		super("Agregar Astrónomo", false, true, false);
		val = new Validaciones();
		// Paneles
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pNombre = new JPanel();
		pApellido = new JPanel();
		pRut = new JPanel();
		pEdad = new JPanel();
		pFNacimiento = new JPanel();
		pNacionalidad = new JPanel();
		pCarrera = new JPanel();
		pPass = new JPanel();
		pBtn = new JPanel();
		
		/** Campo RUT **/
		lRut = new JLabel("RUT:");
		lRut.setPreferredSize(new Dimension(130,20));
		
		tRut = new JTextField(20);
		
		pRut.add(lRut);
		pRut.add(tRut);
		
		/** Campo Nombre **/
		lNombre = new JLabel("Nombre:");
		lNombre.setPreferredSize(new Dimension(130, 20));
		
		tNombre = new JTextField(20);
		
		pNombre.add(lNombre);
		pNombre.add(tNombre);
		
		/** Campo Apellido **/
		lApe = new JLabel("Apellidos:");
		lApe.setPreferredSize(new Dimension(130, 20));
		
		tApe = new JTextField(20);
		
		pApellido.add(lApe);
		pApellido.add(tApe);
		
		/** Campo Edad **/
		lEdad = new JLabel("Edad:");
		lEdad.setPreferredSize(new Dimension(130, 20));
		
		tEdad = new JTextField(20);
		
		pEdad.add(lEdad);
		pEdad.add(tEdad);
		
		/** Campo Fecha Nacimiento **/
		lFNa = new JLabel("Fecha de Nacimiento:");
		lFNa.setPreferredSize(new Dimension(130, 20));
		
		tFNa = new JTextField(20);
		
		pFNacimiento.add(lFNa);
		pFNacimiento.add(tFNa);
		
		
		/** Campo Nacionalidad **/
		lNa = new JLabel("Nacionalidad:");
		lNa.setPreferredSize(new Dimension(130, 20));
		
		tNa = new JTextField(20);
		
		pNacionalidad.add(lNa);
		pNacionalidad.add(tNa);
		
		/** Campo Carrera **/
		lCarr = new JLabel("Lugar de Estudio:");
		lCarr.setPreferredSize(new Dimension(130, 20));
		
		tCarr = new JTextField(20);
		
		pCarrera.add(lCarr);
		pCarrera.add(tCarr);
		
		/** Campo Password **/
		lPass = new JLabel("Contraseña:");
		lPass.setPreferredSize(new Dimension(130, 20));
		
		tPass = new JTextField(20);
		
		pPass.add(lPass);
		pPass.add(tPass);
		
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
				Limpiar();				
			}
			
		});
		
		pBtn.add(btnGuardar);
		pBtn.add(btnLimpiar);
		
		
		/** Panel contenido **/
		pContent.add(pRut);
		pContent.add(pNombre);
		pContent.add(pApellido);
		pContent.add(pEdad);
		pContent.add(pFNacimiento);
		pContent.add(pNacionalidad);
		pContent.add(pCarrera);
		pContent.add(pPass);
		pContent.add(pBtn);
		
		/** Panel Principal **/
		panel.add(pContent);
		
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}
	
	public void Enviar_Form() {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		
		// Campo Rut
		if(!val.campoVacio(tRut.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Rut no puede estar vacio.");
			tRut.requestFocus();
		} else if(!val.Rut(tRut.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El RUT es inválido.");
		// Campo Nombre
		} else if(!val.campoVacio(tNombre.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nombre no puede estar vacio.");
			tNombre.requestFocus();
		} else if(!val.soloString(tNombre.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nombre solo debe contener letras.");
			tNombre.requestFocus();
		// Campo apellido
		} else if(!val.campoVacio(tApe.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Apellidos no puede estar vacio.");
			tApe.requestFocus();
		} else if(!val.soloString(tApe.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Apellidos solo debe contener letras.");
			tApe.requestFocus();
		// Campo Edad
		} else if(!val.campoVacio(tEdad.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Edad no puede estar vacio.");
			tEdad.requestFocus();
		} else if(!val.soloNum(tEdad.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Edad solo debe contener Numeros");
			tEdad.requestFocus();
		// Campo Fecha Nacimiento
		} else if(!val.campoVacio(tFNa.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha no puede estar vacio.");
			tFNa.requestFocus();
		} else if(!val.fecha(tFNa.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha es inválido, el formato es: DD/MM/YYYY");
			tFNa.requestFocus();
		// Campo Nacionalidad
		} else if(!val.campoVacio(tNa.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nacionalidad no puede estar vacio.");
			tNa.requestFocus();
		} else if(!val.soloString(tNa.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nacionalidad solo debe contener letras.");
			tNa.requestFocus();
		// Campo lugar de estudios
		} else if(!val.campoVacio(tCarr.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Lugar de Estudios no puede estar vacio.");
			tCarr.requestFocus();
		} else if(!val.soloString(tCarr.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Lugar de Estudios solo debe contener letras.");
			tCarr.requestFocus();
		// Campo Password
		} else if(!val.campoVacio(tPass.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Contraseña no puede estar vacio.");
		} else {
			Controladora ctrl = new Controladora();
			boolean res = ctrl.crearAstronomo(new Usuarios(
					tRut.getText(),
					tNombre.getText(),
					tApe.getText(),
					tFNa.getText(),
					Integer.parseInt(tEdad.getText().toString()),
					tNa.getText(),
					tCarr.getText(),
					tPass.getText()
					));
			
			if (res) {
				JOptionPane.showInternalMessageDialog(p.DP, "Se ha creado el astronomo con éxito.");
			} else {
				JOptionPane.showInternalMessageDialog(p.DP, "Un error ha ocurrido mientras se crea el usuario, vuelve a intentarlo.");
			}
			
		}
	}
	
	public void Limpiar() {
		tNombre.setText(""); 
		tApe.setText("");
		tRut.setText("");
		tEdad.setText("");
		tFNa.setText("");
		tNa.setText("");
		tCarr.setText("");
	}
}
