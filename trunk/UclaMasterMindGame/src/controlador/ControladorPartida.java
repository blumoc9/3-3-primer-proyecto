package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.hibernate.criterion.Restrictions;

import dao.imp.Base_DatosDAO;

import bean.GenerarCombinaciones;
import bean.Cronometro;

import modelo.Dificultad;
import modelo.Intento;
import modelo.Jugador;
import modelo.Partida;
import vista.FrmPartida;


public class ControladorPartida {
	private FrmPartida frmpartida;
	private Dificultad dificultad;
	private Jugador jugador;
	private Vector<JPanel> colores_paleta;
	private Vector<JCheckBox> checkboxes_paleta;
	private Vector<JPanel> combinacion;
	private Vector<Color> combinacion_solucion;
	private Vector<Vector<JPanel>> intentos_realizados;
	private Vector<Vector<Color>> colores_intentos;
	final static int COLOR_VACIO = -1118482;
	private int margen_y_intentos = 10;
	private int margen_x_intentos = 10;
	
	public ControladorPartida(Dificultad dificultad, Jugador jugador) {
		super();
		this.dificultad = dificultad;
		this.jugador = jugador;
		this.checkboxes_paleta = new Vector<JCheckBox>();
		this.colores_paleta = new Vector<JPanel>();
		this.combinacion = new Vector<JPanel>();
		this.intentos_realizados = new Vector<Vector<JPanel>>();
		this.colores_intentos = new Vector<Vector<Color>>();
		this.frmpartida = new FrmPartida();
		this.frmpartida.setVisible(true);
		this.frmpartida.setLocationRelativeTo(null);
		this.frmpartida.getLbljugador2().setText(this.jugador.getId()+" -- "+this.jugador.getNombre());
		Crear_Campo_Juego();
	}

	private void Cargar_Combinacion_Solucion() {
		this.combinacion_solucion= new GenerarCombinaciones().Generar_Combinancion(this.dificultad.getTamano_combinacion(), getPaletaColores()); 
		int margen_x_color=0,margen_y_color=0;
		int ancho=frmpartida.getPncombinacionrespuesta().getWidth()/this.dificultad.getTamano_combinacion(),alto=frmpartida.getPncombinacionrespuesta().getHeight();
		for (int i=0;i<this.dificultad.getTamano_combinacion();i++){
			JPanel color = new JPanel();
			frmpartida.getPncombinacionrespuesta().add(color);
			color.setBackground(combinacion_solucion.get(i));
			color.setBounds(margen_x_color, margen_y_color, ancho, alto);
			margen_x_color+=ancho;
			this.combinacion.add(color);
		}
		//this.frmpartida.getPncombinacionrespuesta().setVisible(true);
	}

	private Vector<Color> getPaletaColores() {
		Vector<Color> paleta = new Vector<Color>();
		for (int i=0;i<colores_paleta.size();i++){
			paleta.add(colores_paleta.get(i).getBackground());
		}
		return paleta;
	}

	private void Agregar_Esuchadores() {
		Escuchador_ClickBtProbar();
	}

	private void Escuchador_ClickBtProbar() {
		this.frmpartida.getBtprobar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Probar_Combinacion();
			}
		});
	}

	private void Preparar_Campo_Combinacion(JPanel panel_combinacion) {
		int margen_x_color=0,margen_y_color=0;
		int ancho=panel_combinacion.getWidth()/this.dificultad.getTamano_combinacion(),alto=panel_combinacion.getHeight();
		for (int i=0;i<this.dificultad.getTamano_combinacion();i++){
			JPanel color = new JPanel();
			panel_combinacion.add(color);
			color.setBackground(null);
			color.setBounds(margen_x_color, margen_y_color, ancho, alto);
			margen_x_color+=ancho;
			this.combinacion.add(color);
		}
	}

	private void Crear_Campo_Juego() {
		int margen_x_color=8,margen_y_color=7,margen_entre_color=10;
		int margen_x_checkbox=106,margen_y_checkbox=8,margen_entre_checkbox=10;
		int ancho_color=80,alto_color=17;
		int ancho_checkbox=14,alto_checkbox=17;
		for (int i=0;i<this.dificultad.getNumero_colores();i++){
			JPanel color = new JPanel();
			color.setBackground(Generar_Color());
			this.frmpartida.getPnpaletacolor().add(color);
			color.setBounds(margen_x_color,margen_y_color,ancho_color,alto_color);
			final JCheckBox checkbox_color = new JCheckBox();
			this.frmpartida.getPnpaletacolor().add(checkbox_color);
			checkbox_color.setBounds(margen_x_checkbox, margen_y_checkbox, ancho_checkbox, alto_checkbox);
			this.colores_paleta.add(color);
			this.checkboxes_paleta.add(checkbox_color);
			checkbox_color.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Click_Checbox(checkbox_color);
				}
			});
			margen_y_checkbox+=alto_checkbox+margen_entre_checkbox;
			margen_y_color+=alto_color+margen_entre_color;
		}
		Preparar_Campo_Combinacion(this.frmpartida.getPncombinacion());
		Cargar_Combinacion_Solucion();
		Agregar_Esuchadores();
		this.frmpartida.getCrtiempo().IniciarCronometro(1000);
		Transformar_Combinacion(this.combinacion_solucion);
	}

	private Color Generar_Color() {
		int R= (int) (255*Math.random());
		int G= (int) (255*Math.random());
		int B= (int) (255*Math.random());
		Color color = new Color(R, G, B);
		for (int i=0;i<this.colores_paleta.size();i++){
			if (this.colores_paleta.get(i).getBackground().getRGB()==color.getRGB()){
				Generar_Color();
			}
		}
		return color;
	}
	
	private void Click_Checbox(JCheckBox checkbox_color) {
		if (checkbox_color.isSelected()){
			Agregar_Color_Combinacion(checkbox_color);
		}else{
			Remover_Color_Combinacion(checkbox_color);
		}
		int cont=0;
		for (int i=0;i<checkboxes_paleta.size();i++){
			if (checkboxes_paleta.get(i).isSelected()){
				cont++;
			}
		}
		if (dificultad.getTamano_combinacion()==cont){
			frmpartida.getBtprobar().setEnabled(true);
		}else{
			frmpartida.getBtprobar().setEnabled(false);
		}
	}

	private void Remover_Color_Combinacion(JCheckBox checkbox_color) {
		int pos=-1;
		for (int i=0;i<this.checkboxes_paleta.size();i++){
			if (this.checkboxes_paleta.get(i).equals(checkbox_color)){
				pos = i;
				i=checkboxes_paleta.size();
			}
		}
		Despintar_Casilla(colores_paleta.get(pos).getBackground());
	}

	private void Despintar_Casilla(Color color_a_remover) {
		for (int i=0;i<combinacion.size();i++){
			if (this.combinacion.get(i).getBackground().getRGB()==color_a_remover.getRGB()){
				this.combinacion.get(i).setBackground(null);
				i=combinacion.size();
			}
		}
	}

	private void Agregar_Color_Combinacion(JCheckBox checkbox_color) {
		if (!Combinacion_Llena()){
			int pos=-1;
			for (int i=0;i<this.checkboxes_paleta.size();i++){
				if (this.checkboxes_paleta.get(i).equals(checkbox_color)){
					pos = i;
					i=checkboxes_paleta.size();
				}
			}
			Pintar_Casilla_Combinacion(this.colores_paleta.get(pos).getBackground());
		}else{
			this.frmpartida.getMensaje().showMessageDialog(null, "La Combinacion esta Llena", "MasterMind", frmpartida.getMensaje().WARNING_MESSAGE);
			checkbox_color.setSelected(false);
		}
	}

	private void Pintar_Casilla_Combinacion(Color background) {
		for (int i=0;i<this.combinacion.size();i++){
			if (this.combinacion.get(i).getBackground().getRGB()==COLOR_VACIO){
				combinacion.get(i).setBackground(background);
				i=combinacion.size();
			}
		}
	}

	private boolean Combinacion_Llena() {
		boolean llena=true;
		for (int i=0;i<this.combinacion.size();i++){
			if (this.combinacion.get(i).getBackground().getRGB()==COLOR_VACIO){
				i=combinacion.size();
				llena = false;
			}
		}
		return llena;
	}
	
	private void Probar_Combinacion() {
		Cargar_Intento();
		System.out.println(this.dificultad.getNumero_intentos());
		System.out.println(this.intentos_realizados.size());
		if (this.dificultad.getNumero_intentos()>this.intentos_realizados.size()){
			System.out.println(Cantidad_Colores_Posicion_Correcto()+"=="+this.dificultad.getTamano_combinacion());
			if (Cantidad_Colores_Posicion_Correcto()==this.dificultad.getTamano_combinacion()){
				this.frmpartida.getCrtiempo().PararCronometro();
				for (int i=0;i<this.checkboxes_paleta.size();i++){
					this.checkboxes_paleta.get(i).setEnabled(false);
				}
				this.frmpartida.getPncombinacionrespuesta().setVisible(true);
				this.frmpartida.getBtprobar().setEnabled(false);
				Guardar_Partida();
				if (this.frmpartida.getMensaje().showConfirmDialog(this.frmpartida, "Felicidades has Ganado. ¿Desea Jugar Nuevamente?", "MasterMind", this.frmpartida.getMensaje().YES_NO_OPTION)==this.frmpartida.getMensaje().YES_OPTION){
					this.frmpartida.dispose();
					new ControladorPartida(dificultad, jugador);
				}
				else{
					this.frmpartida.dispose();
				}
			}
		}else if (this.dificultad.getNumero_intentos()==this.intentos_realizados.size()){
			if (Cantidad_Colores_Posicion_Correcto()==this.dificultad.getTamano_combinacion()){
				if (this.frmpartida.getMensaje().showConfirmDialog(this.frmpartida, "Felicidades has Ganado. �Desea Jugar Nuevamente?", "MasterMind", this.frmpartida.getMensaje().YES_NO_OPTION)==this.frmpartida.getMensaje().YES_OPTION){
					this.frmpartida.dispose();
					new ControladorPartida(dificultad, jugador);
				}
				else{
					this.frmpartida.dispose();
				}
				this.frmpartida.getCrtiempo().PararCronometro();
				for (int i=0;i<this.checkboxes_paleta.size();i++){
					this.checkboxes_paleta.get(i).setEnabled(false);
				}
				this.frmpartida.getPncombinacionrespuesta().setVisible(true);
				this.frmpartida.getBtprobar().setEnabled(false);
				Guardar_Partida();				
			}else{
				for (int i=0;i<this.checkboxes_paleta.size();i++){
					this.checkboxes_paleta.get(i).setEnabled(false);
				}
				if (this.frmpartida.getMensaje().showConfirmDialog(this.frmpartida, "Game Over. ¿Desea Jugar Nuevamente?", "MasterMind", this.frmpartida.getMensaje().YES_NO_OPTION)==this.frmpartida.getMensaje().YES_OPTION){
					this.frmpartida.dispose();
					new ControladorPartida(dificultad, jugador);
				}
				else{
					this.frmpartida.dispose();
				}
				this.frmpartida.getCrtiempo().PararCronometro();
				this.frmpartida.getPncombinacionrespuesta().setVisible(true);
				this.frmpartida.getBtprobar().setEnabled(false);
			}
		}
	}

	private void Guardar_Partida() {
		Base_DatosDAO conexion = new Base_DatosDAO();
		Partida partida = new Partida(GenerarId_Juego(), jugador, dificultad, frmpartida.getCrtiempo().getSegundos(),Transformar_Combinacion(this.combinacion_solucion), this.intentos_realizados.size(),new Date());
		conexion.save(partida);
		System.out.println(this.colores_intentos.size());
		for (int i=0;i<colores_intentos.size();i++){
			String rgb="";
			for (int j=0;j<colores_intentos.get(i).size();j++){
				rgb+=colores_intentos.get(i).get(j).getRGB();
			}
			Intento intento = new Intento(rgb, partida, i);
			conexion.save(intento);
		}
	}

	private String GenerarId_Juego() {
		Base_DatosDAO conexion = new Base_DatosDAO();
		int cantidad_juegos = conexion.findByProperty(Partida.class, Restrictions.ge("tiempo", 0)).size();
		String id = "P"+String.valueOf(cantidad_juegos+1);
		return id;
	}

	private String Transformar_Combinacion(Vector<Color> combinacioncolores) {
		String combinacion = "";
		for (int i=0;i<combinacioncolores.size();i++){
			combinacion+=combinacioncolores.get(i).getRGB();
		}
		System.out.println(combinacion);
		return combinacion;
	}

	private void Cargar_Intento() {
		int ancho=this.frmpartida.getPncombinacion().getWidth(),alto=this.frmpartida.getPncombinacion().getHeight();
		Vector<JPanel> intento = new Vector<JPanel>();
		Vector<Color> colores_intento = new Vector<Color>();
		JPanel combinacion = new JPanel();
		JPanel aciertos = new JPanel();
		this.frmpartida.getPncombinaciones().add(combinacion);
		this.frmpartida.getPncombinaciones().add(aciertos);
		combinacion.setBounds(margen_x_intentos, margen_y_intentos, ancho, alto);
		aciertos.setBounds(margen_x_intentos+ancho+20, margen_y_intentos, ancho, alto);
		margen_y_intentos+=alto+10;
		int margen_x_color=0,margen_y_color=0;
		int cantidad_colores_correcto = Cantidad_Colores_Correcto();
		int cantidad_colores_pocision_correcto = Cantidad_Colores_Posicion_Correcto();
		for (int i=0;i<this.dificultad.getTamano_combinacion();i++){
			JPanel color = new JPanel();
			JPanel casilla_acierto = new JPanel();
			combinacion.add(color);
			aciertos.add(casilla_acierto);
			color.setBackground(this.combinacion.get(i).getBackground());
			colores_intento.add(color.getBackground());
			color.setBounds(margen_x_color, margen_y_color, ancho/this.dificultad.getTamano_combinacion(), alto);
			if (cantidad_colores_pocision_correcto>0){
				cantidad_colores_pocision_correcto--;
				cantidad_colores_correcto--;
				casilla_acierto.setBackground(Color.GREEN);
			}else if (cantidad_colores_correcto>0){
				casilla_acierto.setBackground(Color.BLACK);
				cantidad_colores_correcto--;
			}
			casilla_acierto.setBounds(margen_x_color,margen_y_color, ancho/this.dificultad.getTamano_combinacion(), alto);
			margen_x_color+=ancho/this.dificultad.getTamano_combinacion();
		}
		combinacion.setLayout(null);
		aciertos.setLayout(null);
		intento.add(combinacion);
		intento.add(aciertos);
		colores_intentos.add(colores_intento);
		this.intentos_realizados.add(intento);
	}

	private int Cantidad_Colores_Posicion_Correcto() {
		int cantidad=0;
		for (int i=0;i<this.dificultad.getTamano_combinacion();i++){
			if (combinacion.get(i).getBackground().getRGB()==combinacion_solucion.get(i).getRGB()){
				cantidad++;
			}
		}
		return cantidad;
	}

	private int Cantidad_Colores_Correcto() {
		int cantidad=0;
		for (int i=0;i<this.dificultad.getTamano_combinacion();i++){
			for (int j=0;j<this.combinacion_solucion.size();j++){
				if (combinacion.get(i).getBackground().getRGB()==combinacion_solucion.get(j).getRGB()){
					cantidad++;
					j=combinacion_solucion.size();
				}
			}
		}
		return cantidad;
	}
}