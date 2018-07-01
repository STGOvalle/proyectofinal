package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Aplicacion.Controladora;

public class Ficha_Astronomo extends JInternalFrame {
	
	JPanel pContent, pRut, pNombre, pApellido, pFecha_Nacimiento, pEdad, pNacionalidad, pLugar_Estudio, pUltimoTurno, 
	pDatosAstronomo;
	JPanel pTComienzo, pTFinal, pDComienzo, pDFinal;
	
	JLabel lRut, lNombre, lApellido, lFecha_Nacimiento, lEdad, lNacionalidad, lLugar_Estudio;
	JLabel aRut, aNombre, aApellido, aFecha_Nacimiento, aEdad, aNacionalidad, aLugar_Estudio;
	JLabel lTComienzo, lTFinal, lDComienzo, lDFinal;
	JLabel aTComienzo, aTFinal, aDComienzo, aDFinal;
	JLabel datos_astronomos, ultimo_turno;

	public Ficha_Astronomo(String rut) {
		super("Ficha Astronomo", false, true, false);
		
		/** Creacion de paneles **/
		pContent = new JPanel();
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pDatosAstronomo = new JPanel();
		pRut = new JPanel();
		pNombre = new JPanel();
		pApellido = new JPanel();
		pFecha_Nacimiento = new JPanel();
		pEdad = new JPanel();
		pNacionalidad = new JPanel();
		pLugar_Estudio = new JPanel();
		pUltimoTurno = new JPanel();
		
		pTComienzo = new JPanel();
		pTFinal = new JPanel();
		pDComienzo = new JPanel();
		pDFinal = new JPanel();
		
		/** Creacion Labels normales **/
		datos_astronomos = new Plantilla_Bold("Datos del Astronomo");
		lRut = new JLabel("Rut:");
		lRut.setPreferredSize(new Dimension(130, 20));
		lNombre = new JLabel("Nombre:");
		lNombre.setPreferredSize(new Dimension(130, 20));
		lApellido = new JLabel("Apellido");
		lApellido.setPreferredSize(new Dimension(130, 20));
		lFecha_Nacimiento = new JLabel("Fecha de Nacimiento:");
		lFecha_Nacimiento.setPreferredSize(new Dimension(130, 20));
		lEdad = new JLabel("Edad:");
		lEdad.setPreferredSize(new Dimension(130, 20));
		lNacionalidad = new JLabel("Nacionalidad:");
		lNacionalidad.setPreferredSize(new Dimension(130, 20));
		lLugar_Estudio = new JLabel("Lugar de Estudio:");
		lLugar_Estudio.setPreferredSize(new Dimension(130, 20));
		ultimo_turno = new Plantilla_Bold("Ultimo Turno Publicado");
		
		/** Creacion labels turno **/
		lTComienzo = new JLabel("Comienzo Turno:");
		lTComienzo.setPreferredSize(new Dimension(130, 20));
		lTFinal = new JLabel("Final Turno:");
		lTFinal.setPreferredSize(new Dimension(130, 20));
		lDComienzo = new JLabel("Comienzo Descanso:");
		lDComienzo.setPreferredSize(new Dimension(130, 20));
		lDFinal = new JLabel("Final Descanso:");
		lDFinal.setPreferredSize(new Dimension(130, 20));
		
		
		/** Creacion labels datos **/
		aRut = new JLabel();
		aRut.setPreferredSize(new Dimension(100, 20));
		aNombre = new JLabel();
		aNombre.setPreferredSize(new Dimension(100, 20));
		aApellido = new JLabel();
		aApellido.setPreferredSize(new Dimension(100, 20));
		aFecha_Nacimiento = new JLabel();
		aFecha_Nacimiento.setPreferredSize(new Dimension(100, 20));
		aEdad = new JLabel();
		aEdad.setPreferredSize(new Dimension(100, 20));
		aNacionalidad = new JLabel();
		aNacionalidad.setPreferredSize(new Dimension(100, 20));
		aLugar_Estudio = new JLabel();
		aLugar_Estudio.setPreferredSize(new Dimension(100, 20));
		
		/** Creacion Labels datos turnos **/
		aTComienzo = new JLabel();
		aTComienzo.setPreferredSize(new Dimension(100, 20));
		aTFinal = new JLabel();
		aTFinal.setPreferredSize(new Dimension(100, 20));
		aDComienzo = new JLabel();
		aDComienzo.setPreferredSize(new Dimension(100, 20));
		aDFinal = new JLabel();
		aDFinal.setPreferredSize(new Dimension(100, 20));
		
		/** Agregar a respectivos paneles **/
		pDatosAstronomo.add(datos_astronomos);
		pRut.add(lRut);
		pRut.add(aRut);
		pNombre.add(lNombre);
		pNombre.add(aNombre);
		pApellido.add(lApellido);
		pApellido.add(aApellido);
		pFecha_Nacimiento.add(lFecha_Nacimiento);
		pFecha_Nacimiento.add(aFecha_Nacimiento);
		pEdad.add(lEdad);
		pEdad.add(aEdad);
		pNacionalidad.add(lNacionalidad);
		pNacionalidad.add(aNacionalidad);
		pLugar_Estudio.add(lLugar_Estudio);
		pLugar_Estudio.add(aLugar_Estudio);
		pUltimoTurno.add(ultimo_turno);
		pTComienzo.add(lTComienzo);
		pTComienzo.add(aTComienzo);
		pTFinal.add(lTFinal);
		pTFinal.add(aTFinal);
		pDComienzo.add(lDComienzo);
		pDComienzo.add(aDComienzo);
		pDFinal.add(lDFinal);
		pDFinal.add(aDFinal);
		
		pContent.add(pDatosAstronomo);
		pContent.add(pRut);
		pContent.add(pNombre);
		pContent.add(pApellido);
		pContent.add(pFecha_Nacimiento);
		pContent.add(pEdad);
		pContent.add(pNacionalidad);
		pContent.add(pLugar_Estudio);
		pContent.add(pUltimoTurno);
		pContent.add(pTComienzo);
		pContent.add(pTFinal);
		pContent.add(pDComienzo);
		pContent.add(pDFinal);
		
		this.add(pContent, BorderLayout.CENTER);
		this.llenar_labels(rut);
		this.setVisible(true);
		this.pack();
	}

	public void llenar_labels(String rut) {
		Controladora ctrl = new Controladora();
		Object[] data = ctrl.getStronomo(rut);
		Object[] turno = ctrl.getLastTurno(Integer.parseInt(data[7].toString()));
		
		this.aRut.setText(data[0].toString());
		this.aNombre.setText(data[1].toString());
		this.aApellido.setText(data[2].toString());
		this.aFecha_Nacimiento.setText(data[4].toString());
		this.aEdad.setText(data[3].toString());
		this.aNacionalidad.setText(data[5].toString());
		this.aLugar_Estudio.setText(data[6].toString());
		
		if (turno != null) {
			this.aTComienzo.setText(turno[0].toString());
			this.aTFinal.setText(turno[1].toString());
			this.aDComienzo.setText(turno[2].toString());
			this.aDFinal.setText(turno[3].toString());
		}
		
	}
}
