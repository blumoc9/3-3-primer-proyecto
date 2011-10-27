package bean;
import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;


public class GenerarCombinaciones implements Serializable{
	
	public GenerarCombinaciones(){}
	
	public Vector<Color> Generar_Combinancion(int tamano, Vector<Color> paletacolores){
		Vector<Color> combinacion= new Vector<Color>();int indicealeatorio;
		boolean encontrado;
		for(int i=0; i<tamano; i++){
			encontrado =false;
			indicealeatorio= (int) ((paletacolores.size())*Math.random());
			System.out.println(indicealeatorio);
			for(int j=0; j<combinacion.size(); j++) {
				if (paletacolores.get(indicealeatorio)==combinacion.get(j)){
					encontrado=true;
					j=combinacion.size();
				}
			}
			if(encontrado==false){
				combinacion.add(paletacolores.get(indicealeatorio));
			}else{
				i--;				
			}
		}
		return combinacion;
	}
}
