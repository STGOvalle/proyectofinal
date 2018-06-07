package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		super("Agregar Planeta", false, true, false);
		
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
		pContent.add(pDist_sol);
		pContent.add(pRotacion);
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
		} else if(!val.campoVacio(tTemperatura.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Temperatura no puede estar vacio.");
			tTemperatura.requestFocus();
		// Validacion de Campo Gravedad
		} else if(!val.campoVacio(tGravedad.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Gravedad no puede estar vacio.");
			tGravedad.requestFocus();
		// Validacion de Campo Velocidad de Escape
		} else if(!val.campoVacio(tVel_Esc.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Velocidad de Escape no puede estar vacio.");
			tVel_Esc.requestFocus();
		// Validacion de Campo Distancia del Sol
		} else if(!val.campoVacio(tDist_Sol.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Distancia del Sol no puede estar vacio.");
			tDist_Sol.requestFocus();
		// Validacion de Campo Rotacion
		} else if(!val.campoVacio(tRotacion.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Rotacion no puede estar vacio.");
			tRotacion.requestFocus();
		// Validacion de Campo Cantidad de Satelites
		} else if(!val.campoVacio(tCantidadSat.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Cantidad de Satelites no puede estar vacio.");
		} else if(!val.soloNum(tCantidadSat.getText())) {
			JOptionPane.showInternalMessageDialog(p.DP, "El campo Cantidad de Satelites solo debe contener Números.");
		// Si todo está ok el formulario se guarda
		} else {
			JOptionPane.showInternalMessageDialog(p.DP, "El formulario se ha enviado con éxito");
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
