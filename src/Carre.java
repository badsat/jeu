import java.awt.event.KeyEvent;


public class Carre {

    //*****************************************************************
    //***************** DECLARATION VARIABLES PUBLIC ******************
    //*****************************************************************
	
	public final static Carre monjeu = new Carre(); // nécessaire pour appeler les méthodes
	
	public final static int X_MAX= 150; //Définition de la longueur de la fênetre
	public final static int Y_MAX= 70; // Définition de la largeur de la fênetre
	public final static double largeur= 5; // Définition de la largeur du rectangle
	public final static double hauteur= 5;// Définition de la hauteur du rectangle

	public final static String [][] LabyrintheEcran = {
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
	
	public static String Labyrinthe[][] = new String[15][7];

	// les quatre attributs des 2 joueurs
    public static String B_bleu_couleur="B" ;
    public static int B_bleu_x = 0;
    public static int B_bleu_y = 6;
    public static String B_bleu_couleurcase="N"; // couleur de la case d'origine où se trouve le joueur

    public static String B_rouge_couleur="R" ;
    public static int B_rouge_x = 14;
    public static int B_rouge_y = 6;
    public static String B_rouge_couleurcase="N"; // couleur de la case d'origine où se trouve le joueur

    //*****************************************************************
    //***************** PROGRAMME PRINCIPAL MAIN **********************
    //*****************************************************************
	
	public static void main (String [] args) throws InterruptedException {

		// ------------------------------------------
		// ------------ INITIALISATION --------------
		// ------------------------------------------
		
		StdDraw.setXscale(0, X_MAX); // Création de la fênetre suivant l'axe de abscisses
		StdDraw.setYscale(0, Y_MAX); // Création de la fênetre suivant l'axe des ordonnées
		StdDraw.clear(StdDraw.WHITE); // Fond blanc

		// on initialise le labyrinthe selon la logique écran et non selon la logique du tableau LabyrintheEcran
		for (int i=0; i<15;i++) {for (int j=0; j<7;j++) {Labyrinthe[i][j]=LabyrintheEcran[6-j][i];}}
		
		// Ecriture à l'écran de chaque case correspondant à chaque valeur du tableau labyrinthe
        for (int x=0; x<15;x++){for(int y=0; y<7; y++){monjeu.ecrirecellule(Labyrinthe[x][y], x, y);}} // Fin affichage labyrinthe
          
		// ------------------------------------------
		// ------------ DEBUT DU JEU ----------------
		// ------------------------------------------
        
        boolean Arret = false;
        while (Arret == false){
            Thread.sleep(120);
        	if (StdDraw.isKeyPressed(38)){ //fleche haut pour bonhomme bleu
        		monjeu.deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 0, B_bleu_y, 1);
        	}
        	if (StdDraw.isKeyPressed(40)){ //fleche bas pour bonhomme bleu
        		monjeu.deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 0, B_bleu_y, -1);
        	}
        	if (StdDraw.isKeyPressed(37)){ //fleche gauche pour bonhomme bleu
        		monjeu.deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, -1, B_bleu_y, 0);
        	}
        	if (StdDraw.isKeyPressed(39)){ //fleche droite pour le bonhomme bleu
        		monjeu.deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 1, B_bleu_y, 0);
        	}
        	if (StdDraw.isKeyPressed(90)){ //fleche haut pour le bonhomme rouge
        		monjeu.deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 0, B_rouge_y, 1);
        	}
        	if (StdDraw.isKeyPressed(83)){ //fleche bas pour le bonhomme rouge
        		monjeu.deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 0, B_rouge_y, -1);
        	}
        	if (StdDraw.isKeyPressed(81)){ //fleche gauche pour le bonhomme rouge
        		monjeu.deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, -1, B_rouge_y, 0);
        	}
        	if (StdDraw.isKeyPressed(68)){ //fleche droite pour le bonhomme rouge
        		monjeu.deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 1, B_rouge_y, 0);
        	}
        	if (StdDraw.isKeyPressed(32)){ //barre d'espace pour extinction éclairage général
        		if (eclairage==true) {
        			eclairage=false;
        			B_bleu_couleur="BN";B_rouge_couleur="RN";
        		}    		
        		else {
        			eclairage=true;
        			B_bleu_couleur="B";B_rouge_couleur="R";
        		}
    			monjeu.ecrirecellule(B_bleu_couleur, B_bleu_x, B_bleu_y);
    			monjeu.ecrirecellule(B_rouge_couleur, B_rouge_x, B_rouge_y);
        	}
        	if (StdDraw.isKeyPressed(10)){
        		monjeu.tir(B_bleu_x, B_bleu_y, 1, 0);
        	}
        	if(StdDraw.isKeyPressed(27)){
        		Arret = true;
        	}        	
        } // fin while

		// ------------------------------------------
		// ------------ FIN DU JEU ------------------
		// ------------------------------------------

		StdOut.println("FIN DU PROGRAMME");
        
    } // fin main

    //*****************************************************************
    //***************** DECLARATION METHODES **************************
    //*****************************************************************
	
	void deplacerbonhomme(String couleur_depart, String couleur_destination, int position_x, int direction_x, int position_y, int direction_y) {
		// vérification à faire : 
		// - ne pas dépasser les bornes
		// - ne pas traverser les murs (W) ni les joueurs (B,R,BN,RN) ni l'ordinateur vert (V)
		int dx=position_x+direction_x;
		int dy=position_y+direction_y;
		if (dx < 15 && dx >=0 && dy < 7 && dy >=0) {
			String c=Labyrinthe[dx][dy];
			// StdOut.println("deplacer bonhomme" + " * " + dx + " * " + dy + " * " + c + " * " + couleur_depart + " * " + couleur_destination);
			if (c=="N" || c=="J") {
				monjeu.ecrirecellule(couleur_depart, position_x, position_y); // départ
				if (couleur_destination=="B" ) {
					B_bleu_couleurcase=c;
					B_bleu_x=dx;
					B_bleu_y=dy;
				}
				else {
					B_rouge_couleurcase=c;			
					B_rouge_x=dx;
					B_rouge_y=dy;
				}
				monjeu.ecrirecellule(couleur_destination, position_x + direction_x, position_y + direction_y); // arrivée			
			}			
		}
	}// fin déplacerbonhomme

	public boolean proximite_lanterne (int x, int y){
		boolean resultat = false;
		if (Labyrinthe[x][y]=="J"){resultat = true;}
		if (x+1 < 15) {if (Labyrinthe[x+1][y]=="J"){resultat = true;}}
		if (x-1 >= 0) {if (Labyrinthe[x-1][y]=="J"){resultat = true;}}
		if (y+1 < 7) {if (Labyrinthe[x][y+1]=="J"){resultat = true;}}
		if (y-1 >= 0) {if (Labyrinthe[x][y-1]=="J"){resultat = true;}}
		return resultat;
	}// fin proximite_lanterne
	
	
	
	public void tir (int tx, int ty, int dx, int dy) throws InterruptedException{
		int i=0;
		boolean stop_tir = false;
		while(stop_tir == false){
			i=i+1;
			if (i==4){stop_tir = true;}
			if (tx+dx*i>=15 || tx+dx*i<0 || ty+dy*i>=7 || tx+dx*i<0){stop_tir = true;}
			if(Labyrinthe[tx+dx*i][ty+dy*i]=="W"){stop_tir = true;}
			if (Labyrinthe[tx+dx*i][ty+dy*i]=="J"){stop_tir = true;
				monjeu.ecrirecellule(Lanterne_noire, tx+dx*i, ty+dy*i);
			}
			monjeu.ecrire1tir(tx+dx*i, ty+dy*i);
			if (Labyrinthe[tx+dx*i][ty+dy*i]=="R" || Labyrinthe[tx+dx*i][ty+dy*i]=="RN"){
				stop_tir = false;
				//Immobilisation du rouge
			}
			if 	(Labyrinthe[tx+dx*i][ty+dy*i]=="B" || Labyrinthe[tx+dx*i][ty+dy*i]=="BN"){
				stop_tir = false;
			}//Immobilisation du bleu
		}
	}
	
	
	
	
	void ecrirecellule(String couleur, int x, int y) {// ecrire une couleur donnée à une position x,y donnée
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
					if (monjeu.proximite_lanterne(x,y)==true){
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
					if (monjeu.proximite_lanterne(x,y)==true){
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
			Labyrinthe[x][y] = couleur;
		}
	} // fin écrirecellule

	void ecrire1tir(int x, int y) throws InterruptedException {// ecrire un tir dans une couleur donnée à une position x,y donnée
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
	
	
} // fin classe
