package modelo;

public class Jugador {
	
		private String  id;
		private String  nombre;
		public Jugador() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Jugador(String id, String nombre) {
			super();
			this.id = id;
			this.nombre = nombre;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
			

}
