
public abstract class Players extends Map {
	
	protected  int positionx;
	protected int positiony;
	protected  String Color_player;
	protected String Color_case;
	public static int KEY_EVENT_UP;
    public static int KEY_EVENT_DOWN;
    public static int KEY_EVENT_RIGHT;
    public static int KEY_EVENT_LEFT;

	
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
	
	public int getKEY_EVENT_UP(){
		return KEY_EVENT_UP;
	}
	public int getKEY_EVENT_DOWN(){
		return KEY_EVENT_DOWN;
	}
	public int getKEY_EVENT_RIGHT(){
		return KEY_EVENT_RIGHT;
	}
	public int getKEY_EVENT_LEFT(){
		return KEY_EVENT_LEFT;
	}
	
	public void setPositionx(int x){
		positionx = x;
	}
	
	public void setPositiony(int y){
		positiony = y;
	}
	
	public void setColorplayer(String B){
		Color_player="B";
	}
	
	public void setColorcase(String colorcase){
		Color_case="BN";
	}
	
	public void setKEY_EVENT_UP(int key_envent_up){
		KEY_EVENT_UP = key_envent_up;
	}
	
	public void setKEY_EVENT_DOWN(int key_envent_down){
		KEY_EVENT_DOWN = key_envent_down;
	}
	
	public void setKEY_EVENT_RIGHT(int key_envent_right){
		KEY_EVENT_RIGHT = key_envent_right;
	}
	public void setKEY_EVENT_LEFT(int key_envent_left){
		KEY_EVENT_LEFT = key_envent_left;
	}
	
	
	
	public Players() {
		 
	boolean Arret = false;
    while (Arret == false){
    	Thread.sleep(120);
    	if (StdDraw.isKeyPressed(KEY_EVENT_RIGHT)){ //fleche haut pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, 0, positiony, 1);
    	}
    	if (StdDraw.isKeyPressed(KEY_EVENT_LEFT)){ //fleche bas pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player,positionx, 0, positiony, -1);
    	}
    	if (StdDraw.isKeyPressed(KEY_EVENT_DOWN)){ //fleche gauche pour bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, -1, positiony, 0);
    	}
    	if (StdDraw.isKeyPressed(KEY_EVENT_UP)){ //fleche droite pour le bonhomme bleu
    		deplacerbonhomme(Color_case, Color_player, positionx, 1, positiony, 0);
    	}
    }
	if(StdDraw.isKeyPressed(27)){     
		Arret = true;
	}        	
 // fin
    
    } // fin while
	
	
		}
	
	
	
	

	
	
	
	
	
	
	






