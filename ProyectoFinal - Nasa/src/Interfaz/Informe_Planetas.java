package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicacion.Controladora;
import Aplicacion.Planetas;
import Aplicacion.Usuarios;

public class Informe_Planetas extends JInternalFrame{
	JPanel pContent;
	JScrollPane scrollPane;
	
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	
	public Informe_Planetas() {
		super("Informe Planetas", false, true, false);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		
		/** Creacion Tabla **/
		cabecera = new String[] {
				"#",
				"NOMBRE",
				"DIAMETRO",
				"ELEMENTO ORGANICO",
				"TEMPERATURA",
				"GRAVEDAD",
				"VELOCIDAD ESCAPE",
				"DISTANCIA DEL SOL",
				"ROTACION",
				"SATELITES"
		};
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // Data Model
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(800, 135));
		table.setEnabled(true);
		
		this.agregar_cabecera(); // Agrego cabecera
		scrollPane = new JScrollPane(table);
		
		this.llenar_tabla();
		
		pContent.add(scrollPane);
	
		this.add(pContent, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	private void agregar_cabecera() {
		for (int column = 0; column < cabecera.length; column++) {
			dtm.addColumn(cabecera[column]);
		}
	}
	
	private void llenar_tabla() {
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getPlanetasM();
		
		Object[] filas = new Object[cabecera.length];
		Planetas obj_temp;
		for (int i=0; i<data.size(); i++) {
			obj_temp = (Planetas)data.get(i);
			filas[0] = obj_temp.getId();
			filas[1] = obj_temp.getNombre();
			filas[2] = obj_temp.getDiametro_p();
			filas[3] = obj_temp.getElem_org();
			filas[4] = obj_temp.getTemperatura();
			filas[5] = obj_temp.getGravedad();
			filas[6] = obj_temp.getVel_Esc();
			filas[7] = obj_temp.getDist_Sol();
			filas[8] = obj_temp.getRotacion();
			filas[9] = obj_temp.getCant_satelites();
			dtm.addRow(filas);
		}
	}
}
