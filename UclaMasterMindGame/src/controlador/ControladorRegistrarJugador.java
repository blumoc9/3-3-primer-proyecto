package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import modelo.Jugador;

import dao.imp.Base_DatosDAO;

import vista.FrmHome;
import vista.FrmRegistrarJugador;

public class ControladorRegistrarJugador implements ActionListener{

	private FrmRegistrarJugador formulariojugador;
	public ControladorRegistrarJugador(){
		super();
		formulariojugador = new FrmRegistrarJugador();
		formulariojugador.setVisible(true);
		formulariojugador.setLocationRelativeTo(null);
		formulariojugador.AgregarEscuchadores(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Aceptar")) {
			Aceptar();
		}		
		else if (actionCommand.equals("Cancelar")) {
			LimpiarPantalla();
		}	
	}
	private void LimpiarPantalla() {
		formulariojugador.getTxtid().setText("");
		formulariojugador.getTxtnombre().setText("");
	}
	private void Aceptar() {
		if(formulariojugador.getTxtid().getText().equals("")||formulariojugador.getTxtnombre().getText().equals("")){
			formulariojugador.getMensaje().showMessageDialog(null, "Debe llenar todos los Campos", "MasterMind/Registrar Jugador", formulariojugador.getMensaje().WARNING_MESSAGE);
			LimpiarPantalla();
		}else{
			Base_DatosDAO  conexion = new Base_DatosDAO();
			List<Jugador> jugadores = conexion.findByProperty(Jugador.class, Restrictions.eq("id", formulariojugador.getTxtid().getText()));
			if(jugadores.size()== 0){
				Jugador jugador = new Jugador(formulariojugador.getTxtid().getText(),formulariojugador.getTxtnombre().getText());
				conexion.save(jugador);
				formulariojugador.getMensaje().showMessageDialog(null, "Jugador Registrado Exitosamente!","MasterMind/Registrar Jugador",formulariojugador.getMensaje().INFORMATION_MESSAGE); LimpiarPantalla();
			}else{
				formulariojugador.getMensaje().showMessageDialog(null, "Jugador ya Existe!","MasterMind/Registrar Jugador",formulariojugador.getMensaje().WARNING_MESSAGE); 
				LimpiarPantalla();
			}

		}
	
	}
}
