package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Dificultad;
import modelo.Jugador;

import org.hibernate.criterion.Restrictions;

import dao.imp.Base_DatosDAO;

import vista.FrmNuevaPartida;

public class ControladorNuevaPartida implements ActionListener{

	private FrmNuevaPartida formularionuevapartida;
	
	public ControladorNuevaPartida(){
		super();
		formularionuevapartida = new FrmNuevaPartida();
		formularionuevapartida.setVisible(true);
		formularionuevapartida.setLocationRelativeTo(null);
		formularionuevapartida.AgregarEscuchadores(this);
		CargarCombo();
	}
	
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
		formularionuevapartida.getTxtidjugador().setText("");
		formularionuevapartida.getCmbdificultad().setSelectedItem("Facil");
	}

	private void Aceptar() {
		Base_DatosDAO  conexion = new Base_DatosDAO();
		if(formularionuevapartida.getTxtidjugador().getText().equals("")|| formularionuevapartida.getCmbdificultad().getSelectedItem().equals("")){
			formularionuevapartida.getMensaje().showMessageDialog(null, "Debe llenar todos los Campos", "MasterMind/Nueva Partida", formularionuevapartida.getMensaje().WARNING_MESSAGE);
			LimpiarPantalla();
		}else{
			List<Jugador> jugadores = conexion.findByProperty(Jugador.class, Restrictions.eq("id", formularionuevapartida.getTxtidjugador().getText()));
			if(jugadores.size()==0){
				formularionuevapartida.getMensaje().showMessageDialog(null, "El Jugador no esta Inscrito", "MasterMind/Nueva Partida", formularionuevapartida.getMensaje().WARNING_MESSAGE);
				LimpiarPantalla();
			}else{
				formularionuevapartida.getMensaje().showMessageDialog(null, "¡Juega MasterMind UCLA DCYT!","MasterMind/Nueva Partida",formularionuevapartida.getMensaje().INFORMATION_MESSAGE);
				Dificultad dificultad = (Dificultad)conexion.findByProperty(Dificultad.class, Restrictions.eq("nombre",formularionuevapartida.getCmbdificultad().getSelectedItem())).get(0);
				new ControladorPartida(dificultad,jugadores.get(0));
				formularionuevapartida.dispose();
			}
		}
	}
	private void CargarCombo(){
		Base_DatosDAO  conexion = new Base_DatosDAO();
		List<Dificultad> dificultades = conexion.findByProperty(Dificultad.class,Restrictions.eq("estatus", 'a'));
		for(int i=0;i<dificultades.size();i++){
			formularionuevapartida.getCmbdificultad().addItem(dificultades.get(i).getNombre());
		}
	}

}
