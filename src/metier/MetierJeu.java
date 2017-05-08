package metier;

public class MetierJeu {
	private int nombreSecret;
	private int nombreTentative;
	private boolean fin;
	
	public void genererSecret(){
		nombreSecret=(int) (Math.random()*100);
	}
	public String jouer(int nb){
		
	if(fin==false){
		if(nb<nombreSecret){
			nombreTentative++;
			return "Votre nombre "+nb+" est plus petit";
		}
		else if(nb>nombreSecret){
			nombreTentative++;
			return "Votre nombre "+nb+" est plus grand";
		}else{
			fin=true;
			return "Bravo Wadi ,vous avez gagné ! Vous avez éffectué "+nombreTentative+" tentatives";
		}
	}else
	{
		
		return "Le jeu est terminé,le nombre recherché est "+nombreSecret+" Merci d'avoir joué.";
	}
	}
	public int getNombreSecret() {
		return nombreSecret;
	}
	public void setNombreSecret(int nombreSecret) {
		this.nombreSecret = nombreSecret;
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	

}
