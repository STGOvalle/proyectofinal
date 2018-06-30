package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Aplicacion.Controladora;
import Aplicacion.Planetas;
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;
import Persistencia.Sqltabla;

public class Modificar_Planetas extends JInternalFrame {
	JPanel pContent, pIzquierda, pDerecha, pNombre, pDiametro, pEOrganico, pTemp, pGrav, pVel, pDist, pRotacion, pSat, pBtn;
	JLabel lNombre, lDiametro, lEOrganico, lTemp, lGrav, lVel, lDist, lRotacion, lSat;
	JTextField tNombre, tDiametro, tEOrganico, tTemp, tGrav, tVel, tDist, tRotacion, tSat, tId;
	JButton btnGuardar;
	JScrollPane scrollPane;
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	
	public Modificar_Planetas() {
		super("Modificar Planetas", false, true, false);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pContent.setLayout(new BorderLayout());
		pIzquierda = new JPanel();
		pDerecha = new JPanel();
		pDerecha.setLayout(new BoxLayout(pDerecha, BoxLayout.Y_AXIS));
		
		pNombre = new JPanel();
		pDiametro = new JPanel();
		pEOrganico = new JPanel();
		pTemp = new JPanel();
		pGrav = new JPanel();
		pVel = new JPanel();
		pDist = new JPanel();
		pRotacion = new JPanel();
		pSat = new JPanel();
		pBtn = new JPanel();
		
		/** Creacion de la tabla **/
		cabecera = new String[] {"ID #", "NOMBRE"};
		
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // Data Model
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setEnabled(true);
		
		this.agregar_cabecera(); // Agrega la Cabecera
		
		scrollPane = new JScrollPane(table);
		
		this.llenar_datos(); // Llama los datos
		
		/* Evento de tabla */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				btnGuardar.setEnabled(true);
				
				int fila = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(fila, 0).toString());
				cargar_fields(id);
			}
		});
		pIzquierda.add(scrollPane);
		
		/** Creacion de labels **/
		lNombre = new JLabel("Nombre:");
		lNombre.setPreferredSize(new Dimension(130, 20));
		lDiametro = new JLabel("Diametro:");
		lDiametro.setPreferredSize(new Dimension(130, 20));
		lEOrganico = new JLabel("Elemento Organico:");
		lEOrganico.setPreferredSize(new Dimension(130, 20));
		lTemp = new JLabel("Temperatura:");
		lTemp.setPreferredSize(new Dimension(130, 20));
		lGrav = new JLabel("Gravedad:");
		lGrav.setPreferredSize(new Dimension(130, 20));
		lVel = new JLabel("Velocidad de Escape:");
		lVel.setPreferredSize(new Dimension(130, 20));
		lDist = new JLabel("Distancia del sol:");
		lDist.setPreferredSize(new Dimension(130, 20));
		lRotacion = new JLabel("Rotacion:");
		lRotacion.setPreferredSize(new Dimension(130, 20));
		lSat = new JLabel("Satelites:");
		lSat.setPreferredSize(new Dimension(130, 20));
		
		/** Creacion de Textfield **/
		tNombre = new JTextField(15);
		tNombre.setEnabled(false);
		tDiametro = new JTextField(15);
		tDiametro.setEnabled(false);
		tEOrganico = new JTextField(15);
		tEOrganico.setEnabled(false);
		tTemp = new JTextField(15);
		tTemp.setEnabled(false);
		tGrav = new JTextField(15);
		tGrav.setEnabled(false);
		tVel = new JTextField(15);
		tVel.setEnabled(false);
		tDist = new JTextField(15);
		tDist.setEnabled(false);
		tRotacion = new JTextField(15);
		tRotacion.setEnabled(false);
		tSat = new JTextField(15);
		tSat.setEnabled(false);
		tId = new JTextField(15); // Campo que no se muestra, almacena la ID
		
		/** Creacion de boton **/
		ImageIcon iSave = new ImageIcon("imagenes/icon_save.png");
		btnGuardar = new Plantilla_JButton(iSave, "Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Guardar();			
			}
			
		});
		
		/** Asignacion a paneles **/
		pNombre.add(lNombre);
		pNombre.add(tNombre);
		pDiametro.add(lDiametro);
		pDiametro.add(tDiametro);
		pEOrganico.add(lEOrganico);
		pEOrganico.add(tEOrganico);
		pTemp.add(lTemp);
		pTemp.add(tTemp);
		pGrav.add(lGrav);
		pGrav.add(tGrav);
		pVel.add(lVel);
		pVel.add(tVel);
		pDist.add(lDist);
		pDist.add(tDist);
		pRotacion.add(lRotacion);
		pRotacion.add(tRotacion);
		pSat.add(lSat);
		pSat.add(tSat);
		pBtn.add(btnGuardar);
		
		/** Asignacion a panel derecho **/
		pDerecha.add(pNombre);
		pDerecha.add(pDiametro);
		pDerecha.add(pEOrganico);
		pDerecha.add(pTemp);
		pDerecha.add(pGrav);
		pDerecha.add(pVel);
		pDerecha.add(pRotacion);
		pDerecha.add(pSat);
		pDerecha.add(pBtn);
		
		/** Agregar Panel principal al layout **/
		pContent.add(pIzquierda, BorderLayout.WEST);
		pContent.add(pDerecha);
		this.add(pContent, BorderLayout.WEST);
		
		this.poner_icono();
		this.setVisible(true);
		this.pack();
	}
	
	private void agregar_cabecera() {
		for (int column = 0; column < cabecera.length; column++) {
			dtm.addColumn(cabecera[column]);
		}
	}
	
	private void llenar_datos() {
		Controladora ctrl = new Controladora();
		ArrayList data = ctrl.getPlanetas();
		
		Object[] filas = new Object[cabecera.length];
		Planetas obj_temp;
		for (int i=0; i<data.size(); i++) {
			obj_temp = (Planetas)data.get(i);
			filas[0] = obj_temp.getId();
			filas[1] = obj_temp.getNombre();
			
			dtm.addRow(filas);
		}
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
	}
	
	public void cargar_fields(int ID) {
		Controladora ctrl = new Controladora();
		Object[] data = ctrl.getPlaneta(ID);
		
		/** Lleno los fields **/
		tNombre.setText(data[0].toString());
		tDiametro.setText(data[1].toString());
		tEOrganico.setText(data[2].toString());
		tTemp.setText(data[3].toString());
		tGrav.setText(data[4].toString());
		tVel.setText(data[5].toString());
		tDist.setText(data[6].toString());
		tRotacion.setText(data[7].toString());
		tSat.setText(data[8].toString());
		tId.setText(data[9].toString());
		
		/** Habilito campos para ser editados **/
		tNombre.setEnabled(true);
		tDiametro.setEnabled(true);
		tEOrganico.setEnabled(true);
		tTemp.setEnabled(true);
		tGrav.setEnabled(true);
		tVel.setEnabled(true);
		tDist.setEnabled(true);
		tRotacion.setEnabled(true);
		tSat.setEnabled(true);
	}
	
	public void Guardar() {
Validaciones val = new Validaciones();
		
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		
		// Validacion de Campo Nombre
		if(!val.campoVacio(tNombre.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nombre no puede estar vacio.");
			tNombre.requestFocus();
		} else if (!val.soloString(tNombre.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Nombre solo debe contener letras.");
			tNombre.requestFocus();
		// Validacion de Campo Diametro
		} else if(!val.campoVacio(tDiametro.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Diametro no puede estar vacio.");
			tDiametro.requestFocus();
		} else if(!val.soloNum(tDiametro.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "En el campo Diametro solo deben ser numeros.");
			tDiametro.requestFocus();
		// Validacion de Campo Elemento Organico
		} else if(!val.campoVacio(tEOrganico.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Elemento Organico no puede estar vacio.");
			tEOrganico.requestFocus();
		} else if(!val.soloString(tEOrganico.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Elemento Organico solo debe contener letras.");
			tEOrganico.requestFocus();
		// Validacion de Campo Temperatura
		} else if(!val.campoVacio(tTemp.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Temperatura no puede estar vacio.");
			tTemp.requestFocus();
		} else if(!val.soloNum(tTemp.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Temperatura solo deben ser numeros.");
			tTemp.requestFocus();
		// Validacion de Campo Gravedad
		} else if(!val.campoVacio(tGrav.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Gravedad no puede estar vacio.");
			tGrav.requestFocus();
		} else if(!val.esDoble(tGrav.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Gravedad solo debe contener numeros decimales.");
			tGrav.requestFocus();
		// Validacion de Campo Velocidad de Escape
		} else if(!val.campoVacio(tVel.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Velocidad de Escape no puede estar vacio.");
			tVel.requestFocus();
		} else if(!val.esDoble(tVel.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Velocidad de Escape solo debe contener numeros decimales.");
			tVel.requestFocus();
		// Validacion de Campo Distancia del Sol
		} else if(!val.campoVacio(tDist.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Distancia del Sol no puede estar vacio.");
			tDist.requestFocus();
		} else if(!val.soloNum(tDist.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Distancia del Sol solo deben ser numeros.");
			tDist.requestFocus();
		// Validacion de Campo Rotacion
		} else if(!val.campoVacio(tRotacion.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Rotacion no puede estar vacio.");
			tRotacion.requestFocus();
		// Validacion de Campo Cantidad de Satelites
		} else if(!val.campoVacio(tSat.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Cantidad de Satelites no puede estar vacio.");
		} else if(!val.soloNum(tSat.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Cantidad de Satelites solo debe contener Números.");
		// Si todo está ok el formulario se guarda
		} else {
			Controladora ctrl = new Controladora();
			boolean res = ctrl.modPlaneta(new Planetas(Integer.parseInt(tId.getText().toString()),
					tNombre.getText(),
					Integer.parseInt(tDiametro.getText().toString()),
					tEOrganico.getText(),
					Integer.parseInt(tTemp.getText().toString()),
					Double.parseDouble(tGrav.getText().toString()),
					Double.parseDouble(tVel.getText().toString()),
					Integer.parseInt(tDist.getText().toString()),
					tRotacion.getText(),
					Integer.parseInt(tSat.getText().toString())));
			
			if(res) {
				JOptionPane.showInternalMessageDialog(p.DP, "El planeta se modifico con éxito");
			} else {
				JOptionPane.showInternalMessageDialog(p.DP, "Ocurrio un error al intentar modificar, vuelve a intentarlo.");
			}
		}
	}
}
