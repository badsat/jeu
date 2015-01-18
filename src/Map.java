
public class Map {
	
	public final static int X_MAX= 150; //Définition de la longueur de la fênetre
	public final static int Y_MAX= 70; // Définition de la largeur de la fênetre
	public final static double largeur= 5; // Définition de la largeur du rectangle
	public final static double hauteur= 5;// Définition de la hauteur du rectangle
	
	public final static String [][] LABYRINTHE_ECRAN = {
    	{"B","W","N","W","N","J","N","W","N","N","N","N","N","N","R"},
    	{"N","N","N","N","N","W","N","W","N","W","N","W","N","W","N"},
    	{"N","W","N","W","N","W","N","W","N","W","N","W","N","N","N"},
	    {"N","W","J","W","N","N","J","N","N","W","N","W","N","W","N"},
	    {"N","W","N","W","N","W","N","W","J","N","N","V","N","W","N"},
	    {"N","W","N","W","N","W","N","N","N","W","N","W","N","W","N"},
		{"N","N","J","N","N","W","N","W","N","W","N","W","N","W","N"},
	}; //Création du labyrinthe de base suivant les couleurs attribuées au départ

	public static boolean eclairage = true;
	public static String Lanterne_noire = "N";
	
	public static String LABYRINTHE[][] = new String[15][7];
	

	public Map(){
	
		StdDraw.setXscale(0, X_MAX); // Création de la fênetre suivant l'axe de abscisses
		StdDraw.setYscale(0, Y_MAX); // Création de la fênetre suivant l'axe des ordonnées
		StdDraw.clear(StdDraw.WHITE); // Fond blanc
		for (int i=0; i<15;i++) {
			for (int j=0; j<7;j++) {
				LABYRINTHE[i][j]=LABYRINTHE_ECRAN[6-j][i];
			}
		}
		
		// Ecriture à l'écran de chaque case correspondant à chaque valeur du tableau labyrinthe
        for (int x=0; x<15;x++){
        	for(int y=0; y<7; y++){
        		ecrirecellule(LABYRINTHE[x][y], x, y);
        	}
        }// Fin affichage labyrinthe
        
        Players infiltre= new Voleur();
        Players garde= new Gardien();
        
    
        
	}
	
	static void deplacerbonhomme(String couleur_depart, String couleur_destination, int position_x, int direction_x, int position_y, int direction_y) {
		// vérification à faire : 
		// - ne pas dépasser les bornes
		// - ne pas traverser les murs (W) ni les joueurs (B,R,BN,RN) ni l'ordinateur vert (V)
		int dx=position_x+direction_x;
		int dy=position_y+direction_y;
		if (dx < 15 && dx >=0 && dy < 7 && dy >=0) {
			String c=LABYRINTHE[dx][dy];
			// StdOut.println("deplacer bonhomme" + " * " + dx + " * " + dy + " * " + c + " * " + couleur_depart + " * " + couleur_destination);
			if (c=="N" || c=="J") {
				ecrirecellule(couleur_depart, position_x, position_y); // départ
				if (couleur_destination=="B" ||couleur_destination=="BN") {
					Voleur.Color_case=c;
					Voleur.positionx=dx;
					Voleur.positiony=dy;
				}
				else {
					Gardien.Color_case=c;			
					Gardien.positionx=dx;
					Gardien.positiony=dy;
				}
				
				Map.ecrirecellule(couleur_destination, position_x + direction_x, position_y + direction_y); // arrivée			
			}			
		}
	}
	
	public boolean proximite_lanterne (int x, int y){
		boolean resultat = false;
		if (LABYRINTHE[x][y]=="J"){resultat = true;}
		if (x+1 < 15) {if (LABYRINTHE[x+1][y]=="J"){resultat = true;}}
		if (x-1 >= 0) {if (LABYRINTHE[x-1][y]=="J"){resultat = true;}}
		if (y+1 < 7) {if (LABYRINTHE[x][y+1]=="J"){resultat = true;}}
		if (y-1 >= 0) {if (LABYRINTHE[x][y-1]=="J"){resultat = true;}}
		return resultat;
	}
	
	static void ecrirecellule(String couleur, int x, int y) {// ecrire une couleur donnée à une position x,y donnée
		// StdOut.println("ecrirecellule" + " * " + couleur + " * " + x + " * " + y);
		if (x < X_MAX && y < Y_MAX) {
			switch (couleur) {
				case "V": StdDraw.setPenColor(StdDraw.GREEN);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					break;
				case "N": StdDraw.setPenColor(StdDraw.BLACK);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					break;
				case "B": StdDraw.setPenColor(StdDraw.BLUE);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  				break;
				case "BN": 
					if (Main.monjeu.proximite_lanterne(x,y)==true){
						StdDraw.setPenColor(StdDraw.BLUE);}
					else{StdDraw.setPenColor(StdDraw.BLACK);}
					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
				break;
				case "R": StdDraw.setPenColor(StdDraw.RED);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  				break;
				case "RN": 
					if (Main.monjeu.proximite_lanterne(x,y)==true){
						StdDraw.setPenColor(StdDraw.RED);}
					else{StdDraw.setPenColor(StdDraw.BLACK);}
					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
				break;
				case "J": StdDraw.setPenColor(StdDraw.YELLOW);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  				break;
				case "W": StdDraw.setPenColor(StdDraw.WHITE);
  					StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  					StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur, hauteur);
  				break;
				default : StdOut.print("Erreur");
			}
			LABYRINTHE[x][y] = couleur;
		}
	} // fin écrirecellule

	static void ecrire1tir(int x, int y) throws InterruptedException {// ecrire un tir dans une couleur donnée à une position x,y donnée
		StdOut.println("ecriretir" + " * " + x + " * " + y);
		if (x < X_MAX && y < Y_MAX) {
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur/5, hauteur/5);
			StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur/5, hauteur/5);
            Thread.sleep(35);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur)-4, largeur/5, hauteur/5);
			StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur)-4, largeur/5, hauteur/5);
            Thread.sleep(35);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur/5, hauteur/5);
			StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur), largeur/5, hauteur/5);
            Thread.sleep(35);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(x*(largeur+hauteur),y*(largeur+hauteur)-4, largeur/5, hauteur/5);
			StdDraw.rectangle(x*(largeur+hauteur),y*(largeur+hauteur)-4, largeur/5, hauteur/5);
		}
		
	} // fin ecriretir

}
