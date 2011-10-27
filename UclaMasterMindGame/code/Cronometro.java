package bean;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Cronometro implements Serializable{
	private JLabel lblTiempo;
	private Timer timer;
	private int segundos;//manejar el valor del contador
	private boolean frozen; //manejar el estado del contador

	final static int SEGUNDOS = 1000;
	final static int MILESEGUNDOS = 1;
	final static int MINUTOS = 60000;
	
	public Cronometro() {
		lblTiempo = new JLabel("0",SwingConstants.CENTER);
		frozen = true; //iniciamos el estado en congelado
		segundos = 0;
	}
	//clase interna que sobre-escribe el metodo run de TimerTask
	class RemindTask extends TimerTask {
		public void run(){
			segundos++;
			lblTiempo.setText(String.valueOf(segundos));
			if(frozen){
				timer.cancel(); //detenemos el timer
			}	
		}
	}
	public void IniciarCronometro(int unidad_tiempo){
		frozen = false;
		timer = new Timer();
		  //le asignamos una tarea al timer
		timer.schedule(new RemindTask(),0,unidad_tiempo);
	}
	public void PararCronometro(){
		timer.cancel();
	}
	public void ResetCronometro(){
		segundos = 0;
		lblTiempo.setText(String.valueOf(0));
	}
	public JLabel getLblTiempo() {
		return lblTiempo;
	}
	public Timer getTimer() {
		return timer;
	}
	public int getSegundos() {
		return segundos;
	}
	public boolean isFrozen() {
		return frozen;
	}
}
