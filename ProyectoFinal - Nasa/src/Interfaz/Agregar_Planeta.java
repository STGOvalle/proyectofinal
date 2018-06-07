package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Aplicacion.Validaciones;

public class Agregar_Planeta extends JInternalFrame {
	
	JPanel panel, pContent, pNombre, pDiametro, pEOrganico, pTemperatura, pGravedad, pVel_Esc, pDist_sol, pRotacion, pCant_Sat, pCant_Text, pBtn;
	JLabel lNombre, lDiametro, lEOrganico, lTemperatura, lGravedad, lVel_Esc, lDist_Sol, lRotacion, lCant_Sat;
	JTextField tNombre, tDiametro, tEOrganico, tTemperatura, tGravedad, tVel_Esc, tDist_Sol, tRotacion, tCantidadSat;
	JRadioButton rSat_si, rSat_no;
	JButton btn_Guardar, btn_Limpiar;
	
	
	public Agregar_Planeta() {
		super("Agregar Planeta", true, true, false);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pNombre = new JPanel();
		pDiametro = new JPanel();
		pEOrganico = new JPanel();
		pTemperatura = new JPanel();
		pGravedad = new JPanel();
		pVel_Esc = new JPanel();
		pDist_sol = new JPanel();
		pRotacion = new JPanel();
		pCant_Sat = new JPanel();
		pCant_Text = new JPanel();
		pCant_Text.setAlignmentX(Component.LEFT_ALIGNMENT);
		pBtn = new JPanel();
		
		// Creaciones de Botones
		
		/** Nombre del Planeta **/
		lNombre = new JLabel("Nombre del Planeta: ");
		lNombre.setPreferredSize(new Dimension(130, 20));
		
		
		tNombre = new JTextField(10);
		
		pNombre.add(lNombre);
		pNombre.add(tNombre);
		
		/** Diametro del planeta **/
		lDiametro = new JLabel("Diametro: ");
		lDiametro.setPreferredSize(new Dimension(130, 20));
		
		tDiametro = new JTextField(10);
		
		pDiametro.add(lDiametro);
		pDiametro.add(tDiametro);
		
		/** Elemento Organico **/
		lEOrganico = new JLabel("Elemento Orgánico: ");
		lEOrganico.setPreferredSize(new Dimension(130, 20));
		
		tEOrganico = new JTextField(10);
		
		pEOrganico.add(lEOrganico);
		pEOrganico.add(tEOrganico);
		
		/** Temperatura **/
		lTemperatura = new JLabel("Temperatura: ");
		lTemperatura.setPreferredSize(new Dimension(130, 20));
		
		tTemperatura = new JTextField(10);
		
		pTemperatura.add(lTemperatura);
		pTemperatura.add(tTemperatura);
		
		/** Gravedad **/
		lGravedad = new JLabel("Gravedad: ");
		lGravedad.setPreferredSize(new Dimension(130, 20));
		
		tGravedad = new JTextField(10);

		pGravedad.add(lGravedad);
		pGravedad.add(tGravedad);
		
		/** Velocidad de Escape **/
		lVel_Esc = new JLabel("Velocidad de Escape: ");
		lVel_Esc.setPreferredSize(new Dimension(130, 20));

		tVel_Esc = new JTextField(10);
		
		pVel_Esc.add(lVel_Esc);
		pVel_Esc.add(tVel_Esc);
		
		/** Distancia del Sol **/
		lDist_Sol = new JLabel("Distancia del Sol: ");
		lDist_Sol.setPreferredSize(new Dimension(130, 20));
		
		tDist_Sol = new JTextField(10);
		
		pDist_sol.add(lDist_Sol);
		pDist_sol.add(tDist_Sol);
		
		/** Rotacion **/
		lRotacion = new JLabel("Rotacion: ");
		lRotacion.setPreferredSize(new Dimension(130, 20));
		
		tRotacion = new JTextField(10);
		
		pRotacion.add(lRotacion);
		pRotacion.add(tRotacion);
		
		/** Cantidad de Satelites **/
		lCant_Sat = new JLabel("¿Tiene Satelites?");
		lCant_Sat.setPreferredSize(new Dimension(130, 20));
		
		tCantidadSat = new JTextField(2);
		tCantidadSat.setText("0");
		tCantidadSat.setEnabled(false);
		
		ButtonGroup BtGroup = new ButtonGroup();
		
		rSat_si = new JRadioButton("Si", false);
		
		rSat_no = new JRadioButton("No", false);
		
		rSat_si.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				tCantidadSat.setEnabled(true);
			}
		});
		
		rSat_no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tCantidadSat.setEnabled(false);
			}
		});
		
		BtGroup.add(rSat_si);
		BtGroup.add(rSat_no);
		
		pCant_Sat.add(lCant_Sat);
		pCant_Sat.add(rSat_si);
		pCant_Sat.add(rSat_no);
		pCant_Text.add(tCantidadSat);
		
		/** Boton Guardar **/
		btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(7, 310, 150, 40);
		btn_Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Enviar_Form();
			}
		});
		
		btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setBounds(160, 310, 150, 40);
		btn_Limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Limpiar_Form();
			}
		});
		
		pBtn.add(btn_Guardar);
		pBtn.add(btn_Limpiar);
		
		// Agregar Objetos a Panel
		pContent.add(pNombre);
		pContent.add(pDiametro);
		pContent.add(pEOrganico);
		pContent.add(pTemperatura);
		pContent.add(pGravedad);
		pContent.add(pVel_Esc);
		pContent.add(pCant_Sat);
		pContent.add(pCant_Text);
		pContent.add(pBtn);
		
		panel.add(pContent);
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
		
		pack();
		setLocation(frame_anchura / 6, frame_altura / 6);
	}
	
	public void Enviar_Form() {
		
		Validaciones val = new Validaciones();

		String nombre = tNombre.getText();
		String diametro = tDiametro.getText();
		String elementoOrganico = tEOrganico.getText();
		String temperatura = tTemperatura.getText();
		String gravedad = tGravedad.getText();
		String velescape = tVel_Esc.getText();
		String distsol = tDist_Sol.getText();
		String rotacion = tRotacion.getText();
		String cant_sat = tCantidadSat.getText();
		
		if(val.campoVacio(nombre) == false || val.campoVacio(diametro) == false || val.campoVacio(elementoOrganico) == false || val.campoVacio(temperatura) == false
				|| val.campoVacio(gravedad) == false || val.campoVacio(velescape) == false || val.campoVacio(distsol) == false || val.campoVacio(rotacion) == false || 
				val.campoVacio(cant_sat) == false) {
			JOptionPane.showMessageDialog(null, "No puedes dejar campos vacíos");
		}
	}
	
	public void Limpiar_Form() {
			tNombre.setText("");
			tDiametro.setText("");
			tEOrganico.setText("");
			tTemperatura.setText("");
			tGravedad.setText("");
			tVel_Esc.setText("");
			tDist_Sol.setText("");
			tRotacion.setText("");
			tCantidadSat.setText("");
	}
}
