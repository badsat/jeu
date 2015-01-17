
public abstract class Players extends Map {
	
	protected static int positionx;
	protected static int positiony;
	protected static String Colorplayer;
	protected static String Colorcase;
	

	
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
		positionx = 0;
	}
	
	public void setPositiony(int y){
		positiony = 6;
	}
	
	public void setColorplayer(String B){
		Colorplayer="B";
	}
	
	public void setColorcase(String colorcase){
		Colorcase="BN";
	}
	
	
	
	public Players()throws InterruptedException{
		 
	boolean Arret = false;
    while (Arret == false){
        Thread.sleep(120);
    	if (StdDraw.isKeyPressed(38)){ //fleche haut pour bonhomme bleu
    		deplacerbonhomme(Colorcase, Colorplayer, positionx, 0, positiony, 1);
    	}
    	if (StdDraw.isKeyPressed(40)){ //fleche bas pour bonhomme bleu
    		deplacerbonhomme(Colorcase, Colorplayer,positionx, 0, positiony, -1);
    	}
    	if (StdDraw.isKeyPressed(37)){ //fleche gauche pour bonhomme bleu
    		deplacerbonhomme(Colorcase, Colorplayer, positionx, -1, positiony, 0);
    	}
    	if (StdDraw.isKeyPressed(39)){ //fleche droite pour le bonhomme bleu
    		deplacerbonhomme(Colorcase, Colorplayer, positionx, 1, positiony, 0);
    	}
    }
	if(StdDraw.isKeyPressed(27)){     
		Arret = true;
	}        	
 // fin
    
    } // fin while
	
	
		}
	
	
	
	

	
	
	
	
	
	
	






