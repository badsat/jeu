import java.awt.event.KeyEvent;


public class Voleur extends Players {
	
	    public static String Color_player ;
	    public static int positionx ;
	    public static int positiony ;
	    public static String Color_case;
	    public static int KEY_EVENT_UP;
	    public static int KEY_EVENT_DOWN;
	    public static int KEY_EVENT_RIGHT;
	    public static int KEY_EVENT_LEFT;
	    
	    
	   public Voleur( ) {
		   positionx=0;
		   positiony=16;
		   Color_player= "B";
		   Color_case="BN";
		   KEY_EVENT_UP = KeyEvent.VK_UP;
		   KEY_EVENT_DOWN=KeyEvent.VK_DOWN;
		   KEY_EVENT_RIGHT=KeyEvent.VK_RIGHT;
		   KEY_EVENT_LEFT=KeyEvent.VK_LEFT;
		   
	   }
	    
	    

}
