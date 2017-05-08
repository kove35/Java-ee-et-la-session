package web;

import java.util.ArrayList;
import java.util.List;

public class ModelJeu {
	
	private int nombre;
	List<String>   historique=new ArrayList<String>();
	
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public List<String> getHistorique() {
		return historique;
	}
	public void setHistorique(List<String> historique) {
		this.historique = historique;
	}
	

}
