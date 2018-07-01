package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Aplicacion.Controladora;
import Aplicacion.Observacion;
import Aplicacion.Planetas;
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;
import Persistencia.SqlObservacion;
import Persistencia.SqlPlanetas;
import Persistencia.Sqltabla;

import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class Modificar_Observacion extends JInternalFrame {
	
	JPanel pContent, pIzquierdo, pDerecho, pBuscar, pHI, pHF, pOb, pBtn;
	JScrollPane scrollPane;
	
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	
	JButton btn_Buscar;
	JComboBox cBuscar;
	JLabel lHoraI, lHoraF, lObs;
	JTextField tHoraI, tHoraF, tId;
	JTextArea tObservacion;
	JButton btn_guardar;
	
	public Modificar_Observacion() {
		super("Modificar Observacion", false, true, false);
		tId = new JTextField(5);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pIzquierdo = new JPanel();
		pIzquierdo.setLayout(new BoxLayout(pIzquierdo, BoxLayout.Y_AXIS));
		pDerecho = new JPanel();
		pDerecho.setLayout(new BoxLayout(pDerecho, BoxLayout.Y_AXIS));
		
		pBuscar = new JPanel();
		pHI = new JPanel();
		pHF = new JPanel();
		pOb = new JPanel();
		pBtn = new JPanel();
		
		/** Panel Buscar **/
		cBuscar = new JComboBox();
		cBuscar.setPreferredSize(new Dimension(100,20));

		
		btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Planetas pln = (Planetas)cBuscar.getSelectedItem();
				llenar_seleccion(pln.getId());
			}
			
		});	
		btn_Buscar.setEnabled(false);
		this.llenar_combo();
		
		pBuscar.add(cBuscar);
			
		
		
		pBuscar.add(btn_Buscar);
		pIzquierdo.add(pBuscar);
		
		
		/** Creacion de la tabla **/
		cabecera = new String[] {"ID Obs.", "ASTRONOMO"};
		
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // Data Model
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(80, 135));
		table.setEnabled(true);
		
		/* Agrega Cabecera */
		this.agregar_cabecera();
		scrollPane = new JScrollPane(table);
		pIzquierdo.add(scrollPane);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				//btnGuardar.setEnabled(true);
				
				int fila = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(fila, 0).toString());
				Cargar_Label(id);
				btn_guardar.setEnabled(true);
			}
		});
		
		/** Panel derecho **/
		/* Hora Inicio*/
		lHoraI = new JLabel("Hora Inicio");
		lHoraI.setPreferredSize(new Dimension(90, 20));
		tHoraI = new JTextField(15);
		
		
		tHoraI.setEnabled(false);
		
		pHI.add(lHoraI);
		pHI.add(tHoraI);
		
		/* Hora Final */
		lHoraF = new JLabel("Hora Termino");
		lHoraF.setPreferredSize(new Dimension(90, 20));
		tHoraF = new JTextField(15);
		
		tHoraF.setEnabled(false);
		
		pHF.add(lHoraF);
		pHF.add(tHoraF);
		
		/* Observacion */
		lObs = new JLabel("Observación");
		lObs.setPreferredSize(new Dimension(90, 20));
		
		tObservacion = new JTextArea(5, 20);
		tObservacion.setLineWrap(true);
		tObservacion.setWrapStyleWord(true); 
		JScrollPane scroll = new JScrollPane(tObservacion);
		
		pOb.add(lObs);
		pOb.add(scroll);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		/* Botones */
		ImageIcon iSave = new ImageIcon("imagenes/icon_save.png");
		btn_guardar = new Plantilla_JButton(iSave, "Guardar");
		btn_guardar.setEnabled(false);
		btn_guardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();			
			}
			
		});		
		
		pBtn.add(btn_guardar);
		
		
		pDerecho.add(pHI);
		pDerecho.add(pHF);
		pDerecho.add(pOb);
		pDerecho.add(pBtn);
		
		pContent.add(pIzquierdo, BorderLayout.WEST);
		pContent.add(pDerecho);
		this.add(pContent, BorderLayout.WEST);
		
		this.setVisible(true);
		this.pack();
	}
	
	private void agregar_cabecera() {
		for (int column = 0; column < cabecera.length; column++) {
			dtm.addColumn(cabecera[column]);
		}
	}
	
	private void llenar_combo() {
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getPlanetas();
		
		if(data != null) {
			btn_Buscar.setEnabled(true);
			Planetas obj_temp;
			for (int i=0; i<data.size(); i++) {
				obj_temp = (Planetas)data.get(i);
				cBuscar.addItem(new Planetas(obj_temp.getId(), obj_temp.getNombre()));
			}
		}
	}
	
	private void llenar_seleccion(int ID) {
		this.Limpiar_Tabla();
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getObservaciones(ID);
		
		if(data != null) {
			Object[] filas = new Object[cabecera.length];
			Observacion obj_temp;
			for (int i=0; i<data.size(); i++) {
				obj_temp = (Observacion)data.get(i);
				filas[0] = obj_temp.getId();
				filas[1] = obj_temp.getUsuario()+" "+obj_temp.getApeAstronomo();
				
				dtm.addRow(filas);
			}
		}
	}
	
	private void Limpiar_Tabla() {
		for (int i = 0; i<table.getRowCount(); i++) {
			dtm.removeRow(i);
			i-=1;
		}
	}
	
	private void Cargar_Label(int id) {
		Controladora ctrl = new Controladora();
		Object[] data = ctrl.getObservacion(id);
		
		tHoraI.setText(data[0].toString());
		tHoraF.setText(data[1].toString());
		tObservacion.setText(data[2].toString());
		tId.setText(data[3].toString());
	}

	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
	}
	
	private void guardar() {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		Validaciones val = new Validaciones();
		if(!val.campoVacio(tObservacion.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Observacion no puede estar vacio.");
			tObservacion.requestFocus();
		} else {
			Controladora ctrl = new Controladora();
			boolean res = ctrl.modObservacion(new Observacion(Integer.parseInt(this.tId.getText().toString()), this.tObservacion.getText()));
			
			if(!res) {
				JOptionPane.showInternalMessageDialog(p.DP, "Se ha modificado la Observacion con éxito.");
			}
		}
	}

}
