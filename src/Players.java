
public abstract class Players extends Map {
	
	protected  int positionx;
	protected int positiony;
	protected  String Color_player;
	protected String Color_case;
	

	
	public int getPositionx(){
		return positionx;
	}
	
	public int getPositiony(){
		return positiony;
	}
	
	public String getColor_player(){
		return Color_player;
	}
	
	public String getColor_case(){
		return Color_case;
	}// accesseur
	
	
	public void setPositionx(int x){
		positionx = 0;
	}
	
	public void setPositiony(int y){
		positiony = 6;
	}
	
	public void setColorplayer(String B){
		Color_player="B";
	}
	
	public void setColorcase(String colorcase){
		Color_case="BN";
	}
	
	
	
	public Players()throws InterruptedException{
		 
	boolean Arret = false;
    while (Arret == false){
        Thread.sleep(120);
    	if (StdDraw.isKeyPressed(38)){ //fleche haut pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, 0, positiony, 1);
    	}
    	if (StdDraw.isKeyPressed(40)){ //fleche bas pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player,positionx, 0, positiony, -1);
    	}
    	if (StdDraw.isKeyPressed(37)){ //fleche gauche pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, -1, positiony, 0);
    	}
    	if (StdDraw.isKeyPressed(39)){ //fleche droite pour le bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, 1, positiony, 0);
    	}
    }
	if(StdDraw.isKeyPressed(27)){     
		Arret = true;
	}        	
 // fin
    
    } // fin while
	
	
		}
	
	
	
	

	
	
	
	
	
	
	






