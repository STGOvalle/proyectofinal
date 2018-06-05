package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Agregar_Planeta extends JInternalFrame {
	
	JPanel panel;
	JLabel lNombre, lDiametro, lEOrganico, lTemperatura, lGravedad, lVel_Esc, lDist_Sol, lRotacion, lCant_Sat;
	JTextField tNombre, tDiametro, tEOrganico, tTemperatura, tGravedad, tVel_Esc, tDist_Sol, tRotacion, tCant_Sat, tCantidadSat;
	JRadioButton rSat_si, rSat_no;
	JButton btn_Guardar, btn_Limpiar;
	
	public Agregar_Planeta() {
		super("Agregar Planeta", true);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		// Creaciones de Botones
		
		/** Nombre del Planeta **/
		lNombre = new JLabel("Nombre del Planeta: ");
		lNombre.setBounds(5, 10, 150, 20);
		
		tNombre = new JTextField();
		tNombre.setBounds(130, 10, 170, 20);
		
		/** Diametro del planeta **/
		lDiametro = new JLabel("Diametro: ");
		lDiametro.setBounds(5, 40, 150, 20);
		
		tDiametro = new JTextField();
		tDiametro.setBounds(130, 40, 170, 20);
		
		/** Elemento Organico **/
		lEOrganico = new JLabel("Elemento Orgánico: ");
		lEOrganico.setBounds(5, 70, 150, 20);
		
		tEOrganico = new JTextField();
		tEOrganico.setBounds(130, 70, 170, 20);
		
		/** Temperatura **/
		lTemperatura = new JLabel("Temperatura: ");
		lTemperatura.setBounds(5, 100, 150, 20);
		
		tTemperatura = new JTextField();
		tTemperatura.setBounds(130, 100, 170, 20);
		
		/** Gravedad **/
		lGravedad = new JLabel("Gravedad: ");
		lGravedad.setBounds(5, 130, 150, 20);
		
		tGravedad = new JTextField();
		tGravedad.setBounds(130, 130, 170, 20);
		
		/** Velocidad de Escape **/
		lVel_Esc = new JLabel("Velocidad de Escape: ");
		lVel_Esc.setBounds(5, 160, 150, 20);
		
		tVel_Esc = new JTextField();
		tVel_Esc.setBounds(130, 160, 170, 20);
		
		/** Distancia del Sol **/
		lDist_Sol = new JLabel("Distancia del Sol: ");
		lDist_Sol.setBounds(5, 190, 150, 20);
		
		tDist_Sol = new JTextField();
		tDist_Sol.setBounds(130, 190, 170, 20);
		
		/** Rotacion **/
		lRotacion = new JLabel("Rotacion: ");
		lRotacion.setBounds(5, 220, 150, 20);
		
		tRotacion = new JTextField();
		tRotacion.setBounds(130, 220, 170, 20);
		
		/** Cantidad de Satelites **/
		lCant_Sat = new JLabel("¿Tiene Satelites?");
		lCant_Sat.setBounds(5, 250, 150, 20);
		
		tCantidadSat = new JTextField();
		tCantidadSat.setBounds(170, 250, 130, 20);
		tCantidadSat.setVisible(false);
		
		ButtonGroup BtGroup = new ButtonGroup();
		
		rSat_si = new JRadioButton("Si", false);
		rSat_si.setBounds(130, 250, 150, 20);
		
		rSat_no = new JRadioButton("No", false);
		rSat_no.setBounds(130, 280, 150, 20);
		
		rSat_si.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				tCantidadSat.setVisible(true);
			}
		});
		
		rSat_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tCantidadSat.setVisible(false);
			}
		});
		
		BtGroup.add(rSat_si);
		BtGroup.add(rSat_no);
		
		/** Boton Guardar **/
		btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(7, 310, 150, 40);
		
		btn_Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enviar_Form();
			}
		});
		
		
		btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setBounds(160, 310, 150, 40);
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar_Form();
			}
		});
		
		// Agregar Objetos a Panel
		panel.add(lNombre);
		panel.add(tNombre);
		panel.add(lDiametro);
		panel.add(tDiametro);
		panel.add(lEOrganico);
		panel.add(tEOrganico);
		panel.add(lTemperatura);
		panel.add(tTemperatura);
		panel.add(lGravedad);
		panel.add(tGravedad);
		panel.add(lVel_Esc);
		panel.add(tVel_Esc);
		panel.add(lDist_Sol);
		panel.add(tDist_Sol);
		panel.add(lRotacion);
		panel.add(tRotacion);
		panel.add(lCant_Sat);
		panel.add(tCantidadSat);
		panel.add(rSat_si);
		panel.add(rSat_no);
		panel.add(btn_Guardar);
		panel.add(btn_Limpiar);
		
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		this.dibuja_frame();
	}

	public void dibuja_frame() {
		// Asigna tamaño y posicionamiento
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		setSize(330,400);
		//pack();
		setLocation(frame_anchura / 6, frame_altura / 6);
	}
	
	public void Enviar_Form() {
		
	}
	
	public void Limpiar_Form() {
		this.tNombre.setText("");
		this.tDiametro.setText("");
		this.tEOrganico.setText("");
		this.tTemperatura.setText("");
		this.tGravedad.setText("");
		this.tVel_Esc.setText("");
		this.tDist_Sol.setText("");
		this.tRotacion.setText("");
		this.tCant_Sat.setText("");
		this.tCantidadSat.setText("");
	}
}
