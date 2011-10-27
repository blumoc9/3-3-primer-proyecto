package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.FrmInstrucciones;
import vista.FrmListadoMejorJugador;

public class ControladorIntrucciones implements ActionListener {

	private FrmInstrucciones formularioinstrucciones;
	
	public ControladorIntrucciones(){
		super();
		formularioinstrucciones = new FrmInstrucciones();
		formularioinstrucciones.setVisible(true);
		formularioinstrucciones.setLocationRelativeTo(null);
		formularioinstrucciones.AgregarEscuchadores(this);
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Aceptar")) {
		 formularioinstrucciones.dispose();
		}	
	}

}
