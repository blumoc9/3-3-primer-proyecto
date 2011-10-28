package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Dificultad;
import modelo.Partida;

import org.hibernate.criterion.Restrictions;

import dao.imp.Base_DatosDAO;

import vista.FrmListadoMejorJugador;
import vista.FrmNuevaPartida;

public class ControladorLista implements ActionListener{

	private FrmListadoMejorJugador formulariolista;
	
	public ControladorLista(){
		super();
		formulariolista = new FrmListadoMejorJugador();
		formulariolista.setVisible(true);
		formulariolista.setLocationRelativeTo(null);
		formulariolista.AgregarEscuchadores(this);
		CargarCombo();
	}
	
	public void Cargar_Tabla(){
		formulariolista.getTbjugadores().LimpiarTabla();
		Base_DatosDAO conexion = new Base_DatosDAO();
		Dificultad dificultad = (Dificultad)conexion.findByProperty(Dificultad.class, Restrictions.eq("nombre", this.formulariolista.getCmbdificultad().getSelectedItem())).get(0);
		List<Partida> partidas = conexion.findBySQLQuery("select * from partida where dificultad='"+dificultad.getId()+"' order by tiempo ASC", "partidas", Partida.class);
		for (int i=0;i<partidas.size();i++){
			String[] nuevafila = {partidas.get(i).getJugador().getId(),String.valueOf(partidas.get(i).getTiempo()),String.valueOf(partidas.get(i).getIntentos().size()),partidas.get(i).getFecha().toString()};
			this.formulariolista.getTbjugadores().AgregarFila(nuevafila);
		}
	}
	
	private void CargarCombo(){
		Base_DatosDAO  conexion = new Base_DatosDAO();
		List<Dificultad> dificultades = conexion.findByProperty(Dificultad.class,Restrictions.eq("estatus", 'a'));
		for(int i=0;i<dificultades.size();i++){
			formulariolista.getCmbdificultad().addItem(dificultades.get(i).getNombre());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actioncomand = e.getActionCommand();
		if (actioncomand.equals("comboBoxChanged")){
			Cargar_Tabla();
		}
	}
}
