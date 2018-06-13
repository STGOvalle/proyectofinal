package Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Plantilla_JButton extends JButton {
	
	public Plantilla_JButton(ImageIcon iconobtn, String txt) {
		int alto = 32;
		int ancho=32;
		ImageIcon iconoEscala = new ImageIcon(iconobtn.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
		this.setIcon(iconoEscala);
		this.setText(txt);
		this.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		this.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
	}
}