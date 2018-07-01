package Interfaz;

import java.awt.Font;

import javax.swing.JLabel;

public class Plantilla_Bold extends JLabel{
	
	public Plantilla_Bold (String txt) {
		this.setText(txt);
		this.setFont(new Font("Verdana", Font.BOLD, 14));
	}

}
