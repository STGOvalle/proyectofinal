package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Aplicacion.Controladora;
import Aplicacion.Observacion;
import Aplicacion.Planetas;
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;
import Persistencia.SqlObservacion;
import Persistencia.SqlPlanetas;
import Persistencia.SqlUsuarios;

public class Agregar_Observacion extends JInternalFrame{
	
	JPanel panel, pContent, pPlanetas, pFecha, pObservacion, PObservacionA, pBtn;
	JLabel lPlanetas, lFecha, lObservacion;
	JComboBox cPlanetas;
	JTextField tFecha;
	JTextArea tObservacion;
	Date fecha;
	JButton btnGuardar, btnLimpiar;
	Validaciones val;
	
	String horaInicio, horaFinal;
	
	public Agregar_Observacion() {
		super("Agregar Observación", false, true, false);
		
		val = new Validaciones();
		// Paneles
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pPlanetas = new JPanel();
		pFecha = new JPanel();
		pObservacion = new JPanel();
		pBtn = new JPanel();
		
		/** Campo Planetas **/
		lPlanetas = new JLabel("Planeta:");
		lPlanetas.setPreferredSize(new Dimension(90, 20));
		
		cPlanetas = new JComboBox();
		cPlanetas.setPreferredSize(new Dimension(225, 20));
		this.llenar_combo();
		
		pPlanetas.add(lPlanetas);
		pPlanetas.add(cPlanetas);
		
		/** Campo Fecha **/
		lFecha = new JLabel("Fecha:");
		lFecha.setPreferredSize(new Dimension(90, 20));
		
		tFecha = new JTextField(20);
		Date fecha = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		tFecha.setText(dateFormat.format(fecha));
		tFecha.setEnabled(false);
		
		
		pFecha.add(lFecha);
		pFecha.add(tFecha);
		
		/** Campo Observacion **/
		
		lObservacion = new JLabel("Observacion:");
		lObservacion.setPreferredSize(new Dimension(90, 20));
		
		tObservacion = new JTextArea(10, 25);
		tObservacion.setLineWrap(true);
		tObservacion.setWrapStyleWord(true); 
		
		
		JScrollPane scroll = new JScrollPane(tObservacion);
		
		pObservacion.add(lObservacion);
		pObservacion.add(scroll);
		//pObservacion.add(tObservacion);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		/** Botones **/
		ImageIcon iSave = new ImageIcon("imagenes/icon_save.png");
		btnGuardar = new Plantilla_JButton(iSave, "Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviar_form();
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
		
		/** Paneles **/
		pContent.add(pPlanetas);
		pContent.add(pFecha);
		pContent.add(pObservacion);
		pContent.add(pBtn);
		
		panel.add(pContent);
		
		add(panel, BorderLayout.CENTER);
		this.horaInicio = this.getHora();
		
		this.dibuja_frame();
		this.poner_icono();
	}
	
	public void Enviar_Form() {
		
	}
	
	public void Limpiar() {
		tObservacion.setText("");
	}

	public void dibuja_frame() {
		pack();
		setVisible(true);
	}
	
	private void llenar_combo() {
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getPlanetas();
		
		Planetas obj_temp;
		for (int i=0; i<data.size(); i++) {
			obj_temp = (Planetas)data.get(i);
			cPlanetas.addItem(new Planetas(obj_temp.getId(), obj_temp.getNombre()));
		}
	}
	
	public String getHora() {
		Date fecha = new Date();
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return dateFormat.format(fecha);
	}
	
	public void enviar_form() {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		
		if(!val.campoVacio(tObservacion.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Observacion no puede estar vacio.");
			tObservacion.requestFocus();
		} else {
			Controladora ctrl = new Controladora();
			
			String horaI = this.horaInicio; // Obtiene hora inicio
			this.horaFinal = this.getHora(); // Obtiene hora final
			Planetas planeta = (Planetas)cPlanetas.getSelectedItem(); // Objeto del planeta
			int plnid = planeta.getId(); // Id del Planeta
			String observacion = tObservacion.getText(); // Observacion
			int idUsuario = Integer.parseInt(SqlUsuarios.usuario[0].toString());
			
			
			boolean res = ctrl.crearObservacion(new Observacion(idUsuario, plnid, horaI, this.horaFinal, observacion));
			
			if(res) {
				JOptionPane.showInternalMessageDialog(p.DP, "La Observacion se ha creado con éxito");
				this.tObservacion.setText("");
			} else {
				JOptionPane.showInternalMessageDialog(p.DP, "Un error ha ocurrido al crear la observación");
			}
		}
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
	}
}
