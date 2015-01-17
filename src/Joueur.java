
public class Joueur {
	
	private  int positionx;
	private int positiony;
	private String Colorplayer;
	private String Colorcase;
	
	public Joueur(int x, int y, String colorplayer, String colorcase){
		 Colorplayer = colorplayer ;
	     positionx = x;
	     positiony = y;
	     Colorcase= colorcase; // couleur de la case d'origine où se trouve le joueur
	}
	
	public int getPositionx(){
		return positionx;
	}
	
	public int getPositiony(){
		return positiony;
	}
	
	public String getColorplayer(){
		return Colorplayer;
	}
	
	public String getColorcase(){
		return Colorcase;
	}// accesseur
	
	
	public void setPositionx(int x){
		positionx = x;
	}
	
	public void setPositiony(int y){
		positionx = y;
	}
	
	public void setColorplayer(String colorplayer){
		Colorplayer=colorplayer;
	}
	
	public void setColorcase(String colorcase){
		Colorcase=colorcase;
	}
	
	
	
	
	
	
	
	
	
	

}
