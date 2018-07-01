package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicacion.Controladora;
import Aplicacion.Observacion;
import Aplicacion.Usuarios;

public class Informe_Astronomo extends JInternalFrame{
	JPanel pContent, pTabla, pBtn;
	JButton btnVer;
	JScrollPane scrollPane;
	
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	public Informe_Astronomo() {
		super("Informe Astronomo", false, true, false);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pTabla = new JPanel();
		pBtn = new JPanel();
		
		/** Creacion Tabla **/
		cabecera = new String[] {"#", "RUT", "NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "EDAD", "NACIONALIDAD", "LUGAR DE ESTUDIO"};
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
		
		/** Boton ver **/
		ImageIcon iVer = new ImageIcon("imagenes/icon_ver.png");
		btnVer = new Plantilla_JButton(iVer, "Ver Ficha");
		btnVer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();
				String rut = table.getValueAt(fila, 1).toString();
				
				abrir_ficha(rut);
			}
			
		});	
		
		pTabla.add(scrollPane);
		pBtn.add(btnVer);
		
		pContent.add(pTabla);
		pContent.add(pBtn);
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
		ArrayList data = ctrl.getAstronomos();
		
		Object[] filas = new Object[cabecera.length];
		Usuarios obj_temp;
		for (int i=0; i<data.size(); i++) {
			obj_temp = (Usuarios)data.get(i);
			filas[0] = obj_temp.getId();
			filas[1] = obj_temp.getRut();
			filas[2] = obj_temp.getNombre();
			filas[3] = obj_temp.getApellido();
			filas[4] = obj_temp.getFecha_nac();
			filas[5] = obj_temp.getEdad();
			filas[6] = obj_temp.getNacionalidad();
			filas[7] = obj_temp.getEstudio_carrera();
			dtm.addRow(filas);
		}
	}

	private void abrir_ficha(String rut) {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		Ficha_Astronomo AG = new Ficha_Astronomo(rut);
		Dimension desktopSize = p.DP.getSize();
		Dimension FrameSize = AG.getSize();
		AG.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height - FrameSize.height)/2);
		p.DP.add(AG);	
		p.DP.moveToFront(AG);
	}
}
