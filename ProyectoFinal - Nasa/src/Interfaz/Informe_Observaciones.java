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

public class Informe_Observaciones extends JInternalFrame {
	
	JPanel pContent, pIzquierdo, pDerecho, pBuscar, pHI, pHF, pOb, pBtn, pFI, pFF;
	JScrollPane scrollPane;
	
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	
	JButton btn_Buscar;
	JLabel lHoraI, lHoraF, lObs, lFI, lFF;
	JTextField tHoraI, tHoraF, tId, tFI, tFF;
	JTextArea tObservacion;
	
	public Informe_Observaciones() {
		super("Observaciones", false, true, false);
		tId = new JTextField(5);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pIzquierdo = new JPanel();
		pIzquierdo.setLayout(new BoxLayout(pIzquierdo, BoxLayout.Y_AXIS));
		pDerecho = new JPanel();
		pDerecho.setLayout(new BoxLayout(pDerecho, BoxLayout.Y_AXIS));
		
		pBuscar = new JPanel();
		pBuscar.setLayout(new BoxLayout(pBuscar, BoxLayout.Y_AXIS));
		pFI = new JPanel();
		pFF = new JPanel();
		pHI = new JPanel();
		pHF = new JPanel();
		pOb = new JPanel();
		pBtn = new JPanel();
		
		/** Panel Buscar **/
		lFI = new JLabel("Fecha Inicio:");
		lFI.setPreferredSize(new Dimension(100, 20));
		
		tFI = new JTextField(7);
		lFF = new JLabel("Fecha Final:");
		lFF.setPreferredSize(new Dimension(100, 20));
		tFF = new JTextField(7);

		
		btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				llenar_seleccion();
			}
			
		});	
			
		
		pFI.add(lFI);
		pFI.add(tFI);
		pFF.add(lFF);
		pFF.add(tFF);
		
		pBuscar.add(pFI);
		pBuscar.add(pFF);
		pBuscar.add(btn_Buscar);
		pIzquierdo.add(pBuscar);
		
		
		/** Creacion de la tabla **/
		cabecera = new String[] {"ID Obs.", "PLANETA", "ASTRONOMO"};
		
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // Data Model
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 135));
		table.setEnabled(true);
		
		/* Agrega Cabecera */
		this.agregar_cabecera();
		scrollPane = new JScrollPane(table);
		pIzquierdo.add(scrollPane);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
				int fila = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(fila, 0).toString());
				Cargar_Label(id);
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
		tObservacion.setEditable(false);
		tObservacion.setLineWrap(true);
		tObservacion.setWrapStyleWord(true); 
		JScrollPane scroll = new JScrollPane(tObservacion);
		
		pOb.add(lObs);
		pOb.add(scroll);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		
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
	
	private void llenar_seleccion() {
		this.Limpiar_Tabla();
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		Validaciones val = new Validaciones();
		if(!val.campoVacio(this.tFI.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha Inicio no puede quedar vacio.");
		} else if(!val.fechaTurno(this.tFI.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha Inicio no es una fecha válida.");
		} else if(!val.campoVacio(this.tFF.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha Final no puede quedar vacio.");
		} else if(!val.fechaTurno(this.tFF.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Fecha Final no es una fecha válida.");
		} else {
			Controladora ctrl = new Controladora();
			ArrayList data = ctrl.getObservacionFecha(this.tFI.getText(), this.tFF.getText());
			
			Object[] filas = new Object[cabecera.length];
			Observacion obj_temp;
			for (int i=0; i<data.size(); i++) {
				obj_temp = (Observacion)data.get(i);
				filas[0] = obj_temp.getId();
				filas[1] = obj_temp.getPlaneta();
				filas[2] = obj_temp.getUsuario()+" "+obj_temp.getApeAstronomo();
				
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

}
