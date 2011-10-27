package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import vista.FrmHome;



public class ControladorHome implements ActionListener{

	private FrmHome formulariohome;
	public ControladorHome(){
		super();
		formulariohome = new FrmHome();
		formulariohome.setVisible(true);
		formulariohome.setLocationRelativeTo(null);
		formulariohome.Agregarescuchador(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Jugar")) {
			new ControladorNuevaPartida();
		}		
		else if (actionCommand.equals("Registrar Jugador")) {
			new ControladorRegistrarJugador();
		}
		else if (actionCommand.equals("Intrucciones de Juego")) {
			new ControladorIntrucciones();
		}
		else if(actionCommand.equals("Listado Mejor Jugador")){
			new ControladorLista();
		}
		
	}

}
