package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Aplicacion.Validaciones;

public class Agregar_Observacion extends JInternalFrame{
	
	JPanel panel, pContent, pPlanetas, pFecha, pObservacion, PObservacionA, pBtn;
	JLabel lPlanetas, lFecha, lObservacion;
	JComboBox cPlanetas;
	JTextField tFecha;
	JTextArea tObservacion;
	Date fecha;
	JButton btnGuardar, btnLimpiar;
	Validaciones val;
	
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
		cPlanetas.addItem("Mercurio");
		cPlanetas.addItem("Jupiter");
		
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
		
		JScrollPane scroll = new JScrollPane(tObservacion);
		
		pObservacion.add(lObservacion);
		pObservacion.add(scroll);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		/** Botones **/
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enviar_Form();				
			}
			
		});
		
		btnLimpiar = new JButton("Limpiar");
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
		
		
		this.dibuja_frame();
	}
	
	public void Enviar_Form() {
		Principal p = (Principal)getDesktopPane().getTopLevelAncestor();
		
		if(!val.campoVacio(tObservacion.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Observacion no puede estar vacio.");
			tObservacion.requestFocus();
		}
	}
	
	public void Limpiar() {
		tObservacion.setText("");
	}

	public void dibuja_frame() {
		// Asigna tamaño y posicionamiento
				Toolkit tk = Toolkit.getDefaultToolkit();
				Dimension d = tk.getScreenSize();
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		//setSize(frame_anchura, frame_altura);
		pack();
		setVisible(true);
	}
}
