package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import Aplicacion.Usuarios;
import Aplicacion.Validaciones;
import Persistencia.SqlUsuarios;
import Persistencia.Sqltabla;
import Persistencia.conexion;

public class Modificar_Astronomo extends JInternalFrame{
	
	JPanel pContent, pIzquierda, pDerecha, pNombre, pApellido, pRut, pEdad, pFNacimiento, pNacionalidad, pCarrera, pBtn;
	JScrollPane scrollPane;
	
	JLabel lNombre, lApe, lRut, lEdad, lFNa, lNa, lCarr;
	JTextField tNombre, tApe, tRut, tEdad, tFNa, tNa, tCarr;
	JButton btnGuardar, btnLimpiar;
	
	DefaultTableModel dtm;
	JTable table;
	String [] cabecera;
	
	Validaciones val;
	
	public Modificar_Astronomo() {
		super("Modificar Astronomo", false, true, false);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pContent.setLayout(new BorderLayout());
		pIzquierda = new JPanel();
		pDerecha = new JPanel();
		pDerecha.setLayout(new BoxLayout(pDerecha, BoxLayout.Y_AXIS));
		
		/** Creacion Paneles datos **/
		pNombre = new JPanel();
		pApellido = new JPanel();
		pRut = new JPanel();
		pEdad = new JPanel();
		pFNacimiento = new JPanel();
		pNacionalidad = new JPanel();
		pCarrera = new JPanel();
		pBtn = new JPanel();
		
		/** Creacion de la tabla **/
		cabecera = new String[] {"RUT", "NOMBRE", "APELLIDO"};
		
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // Data Model
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setEnabled(true);
		
		/* Agrega Cabecera */
		this.agregar_cabecera();
		
		scrollPane = new JScrollPane(table);
		this.llenar_datos();
		/* Evento de tabla */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				btnGuardar.setEnabled(true);
				
				int fila = table.getSelectedRow();
				String rut = table.getValueAt(fila, 0).toString();
				Cargar_Label(rut);
			}
		});
		pIzquierda.add(scrollPane);
		
		
		/** formulario **/
		/** Campo RUT **/
		lRut = new JLabel("RUT:");
		lRut.setPreferredSize(new Dimension(130,20));
		
		tRut = new JTextField(20);
		tRut.setEnabled(false);
		
		pRut.add(lRut);
		pRut.add(tRut);
		
		/** Campo Nombre **/
		lNombre = new JLabel("Nombre:");
		lNombre.setPreferredSize(new Dimension(130, 20));
		
		tNombre = new JTextField(20);
		tNombre.setEnabled(false);
		
		pNombre.add(lNombre);
		pNombre.add(tNombre);
		
		/** Campo Apellido **/
		lApe = new JLabel("Apellidos:");
		lApe.setPreferredSize(new Dimension(130, 20));
		
		tApe = new JTextField(20);
		tApe.setEnabled(false);
		
		pApellido.add(lApe);
		pApellido.add(tApe);
		
		/** Campo Edad **/
		lEdad = new JLabel("Edad:");
		lEdad.setPreferredSize(new Dimension(130, 20));
		
		tEdad = new JTextField(20);
		tEdad.setEnabled(false);
		
		pEdad.add(lEdad);
		pEdad.add(tEdad);
		
		/** Campo Fecha Nacimiento **/
		lFNa = new JLabel("Fecha de Nacimiento:");
		lFNa.setPreferredSize(new Dimension(130, 20));
		
		tFNa = new JTextField(20);
		tFNa.setEnabled(false);
		
		pFNacimiento.add(lFNa);
		pFNacimiento.add(tFNa);
		
		
		/** Campo Nacionalidad **/
		lNa = new JLabel("Nacionalidad:");
		lNa.setPreferredSize(new Dimension(130, 20));
		
		tNa = new JTextField(20);
		tNa.setEnabled(false);
		
		pNacionalidad.add(lNa);
		pNacionalidad.add(tNa);
		
		/** Campo Carrera **/
		lCarr = new JLabel("Lugar de Estudio:");
		lCarr.setPreferredSize(new Dimension(130, 20));
		
		tCarr = new JTextField(20);
		tCarr.setEnabled(false);
		
		pCarrera.add(lCarr);
		pCarrera.add(tCarr);
		
		/** Botones **/
		ImageIcon iSave = new ImageIcon("imagenes/icon_save.png");
		btnGuardar = new Plantilla_JButton(iSave, "Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();			
			}
			
		});		
		
		pBtn.add(btnGuardar);
		
		/** Agregar contenido a panel derecho **/
		pDerecha.add(pRut);
		pDerecha.add(pNombre);
		pDerecha.add(pApellido);
		pDerecha.add(pEdad);
		pDerecha.add(pFNacimiento);
		pDerecha.add(pNacionalidad);
		pDerecha.add(pCarrera);
		pDerecha.add(pBtn);
		
		pContent.add(pIzquierda, BorderLayout.WEST);
		pContent.add(pDerecha);
		
		/** Agregar Panel principal al layout **/
		this.add(pContent, BorderLayout.WEST);
		
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
		ArrayList data = ctrl.getAstronomos();
		
		Object[] filas = new Object[cabecera.length];
		Usuarios obj_temp;
		for (int i=0; i<data.size(); i++) {
			obj_temp = (Usuarios)data.get(i);
			filas[0] = obj_temp.getRut();
			filas[1] = obj_temp.getNombre();
			filas[2] = obj_temp.getApellido();
			
			dtm.addRow(filas);
		}
	}
	
	private void Limpiar_Tabla() {
		for (int i = 0; i<table.getRowCount(); i++) {
			dtm.removeRow(i);
			i-=1;
		}
	}
	
	private void Cargar_Label(String rut) {
		Controladora ctrl = new Controladora();
		Object[] data = ctrl.getStronomo(rut);
		
		tRut.setText(data[0].toString());
		tNombre.setText(data[1].toString());
		tApe.setText(data[2].toString());
		tEdad.setText(data[3].toString());
		tFNa.setText(data[4].toString());
		tNa.setText(data[5].toString());
		tCarr.setText(data[6].toString());
		
		tRut.setEnabled(true);
		tNombre.setEnabled(true);
		tApe.setEnabled(true);
		tEdad.setEnabled(true);
		tFNa.setEnabled(true);
		tNa.setEnabled(true);
		tCarr.setEnabled(true);
	}
	
	private void guardar() {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		val = new Validaciones();
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
		} else {
			Controladora ctrl = new Controladora();
			Usuarios usr = new Usuarios();
			
			usr.setRut(tRut.getText());
			usr.setNombre(tNombre.getText());
			usr.setApellido(tApe.getText());
			usr.setEdad(Integer.parseInt(tEdad.getText()));
			usr.setFecha_nac(tFNa.getText());
			usr.setNacionalidad(tNa.getText());
			usr.setEstudio_carrera(tCarr.getText());
			
			boolean res = ctrl.modAstronomo(usr);
		
			if(!res) {
				JOptionPane.showInternalMessageDialog(p.DP, "Se ha modificado el usuario con éxito.");
				this.Limpiar_Tabla();
				this.llenar_datos();
			}
		}
	}
	
	public void poner_icono() {
		ImageIcon icon = new ImageIcon("imagenes/nasa-ico.png");
		this.setFrameIcon(icon);
	}

}
