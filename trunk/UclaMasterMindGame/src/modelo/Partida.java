package modelo;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.criterion.Restrictions;

import dao.imp.Base_DatosDAO;

public class Partida {
	    private String id;
		private Jugador jugador;
		private Dificultad dificultad;
		private int tiempo;
		private String combinacion_colores;
		private int numero_intentos;
		private Date fecha;
		public Partida() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Partida(String id, Jugador jugador, Dificultad dificultad,
				int tiempo, String combinacion_colores, int numero_intentos, Date fecha) {
			super();
			this.id = id;
			this.jugador = jugador;
			this.dificultad = dificultad;
			this.tiempo = tiempo;
			this.combinacion_colores = combinacion_colores;
			this.numero_intentos = numero_intentos;
			this.fecha = fecha;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Jugador getJugador() {
			return jugador;
		}
		public void setJugador(Jugador jugador) {
			this.jugador = jugador;
		}
		public Dificultad getDificultad() {
			return dificultad;
		}
		public void setDificultad(Dificultad dificultad) {
			this.dificultad = dificultad;
		}
		public int getTiempo() {
			return tiempo;
		}
		public void setTiempo(int tiempo) {
			this.tiempo = tiempo;
		}
		public String getCombinacion_colores() {
			return combinacion_colores;
		}
		public void setCombinacion_colores(String combinacion_colores) {
			this.combinacion_colores = combinacion_colores;
		}
		public int getNumero_intentos() {
			return numero_intentos;
		}
		public void setNumero_intentos(int numero_intentos) {
			this.numero_intentos = numero_intentos;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public List<Intento> getIntentos(){
			Base_DatosDAO conexion = new Base_DatosDAO();
			return conexion.findBySQLQuery("select * from intento where partida='"+this.getId()+"'", "intentos", Intento.class);
		}
}
