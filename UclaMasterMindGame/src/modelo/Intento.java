package modelo;

import java.io.Serializable;

public class Intento implements Serializable{
	
	private String intento;
	private Partida partida;
	private int numero;
	public Intento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Intento(String intento, Partida partida,int numero) {
		super();
		this.intento = intento;
		this.partida = partida;
		this.numero = numero;
	}
	public String getIntento() {
		return intento;
	}
	public void setIntento(String intento) {
		this.intento = intento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	

}
