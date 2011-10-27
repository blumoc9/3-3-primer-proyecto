package modelo;

public class Dificultad {
	private String id;
	private int tamano_combinacion;
	private int numero_intentos;
	private int numero_colores;
	private String nombre;
	private char estatus;
	public Dificultad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dificultad(String id, int tamancombinacion, int numero_intentos,int numero_colores, String nombre, char estatus) {
		super();
		this.id = id;
		this.tamano_combinacion = tamano_combinacion;
		this.numero_intentos = numero_intentos;
		this.numero_colores = numero_colores;
		this.nombre =  nombre;
		this.estatus = estatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTamano_combinacion() {
		return tamano_combinacion;
	}
	public void setTamano_combinacion(int tamano_combinacion) {
		this.tamano_combinacion = tamano_combinacion;
	}
	public int getNumero_intentos() {
		return numero_intentos;
	}
	public void setNumero_intentos(int numero_intentos) {
		this.numero_intentos = numero_intentos;
	}
	public int getNumero_colores() {
		return numero_colores;
	}
	public void setNumero_colores(int numero_colores) {
		this.numero_colores = numero_colores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getEstatus() {
		return estatus;
	}
	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}
	
}
