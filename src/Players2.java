
public abstract class Players2 extends Map  {
	public static String B_bleu_couleur="B" ;
    public static int B_bleu_x = 0;
    public static int B_bleu_y = 6;
    public static String B_bleu_couleurcase="N"; // couleur de la case d'origine où se trouve le joueur

    public static String B_rouge_couleur="R" ;
    public static int B_rouge_x = 14;
    public static int B_rouge_y = 6;
    public static String B_rouge_couleurcase="N"; // couleur de la case d'origine où se trouve le joueur

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
				Map.ecrirecellule(couleur_depart, position_x, position_y); // départ
				if (couleur_destination=="B" ||couleur_destination=="BN") {
					B_bleu_couleurcase=c;
					B_bleu_x=dx;
					B_bleu_y=dy;
				}
				else {
					B_rouge_couleurcase=c;			
					B_rouge_x=dx;
					B_rouge_y=dy;
				}
				Map.ecrirecellule(couleur_destination, position_x + direction_x, position_y + direction_y); // arrivée			
			}			
		}
	}
// fin déplacerbonhomme
	
	public void tir (int tx, int ty, int dx, int dy) throws InterruptedException{
		int i=0;
		boolean stop_tir = false;
		while(stop_tir == false){
			i=i+1;
			if (i==4){stop_tir = true;}
			if (tx+dx*i>=15 || tx+dx*i<0 || ty+dy*i>=7 || tx+dx*i<0){stop_tir = true;}
			if(LABYRINTHE[tx+dx*i][ty+dy*i]=="W"){stop_tir = true;}
			if (LABYRINTHE[tx+dx*i][ty+dy*i]=="J"){stop_tir = true;
			Map.ecrirecellule(Lanterne_noire, tx+dx*i, ty+dy*i);
			}
			Map.ecrire1tir(tx+dx*i, ty+dy*i);
			if (LABYRINTHE[tx+dx*i][ty+dy*i]=="R" || LABYRINTHE[tx+dx*i][ty+dy*i]=="RN"){
				stop_tir = false;
				//Immobilisation du rouge
			}
			if 	(LABYRINTHE[tx+dx*i][ty+dy*i]=="B" || LABYRINTHE[tx+dx*i][ty+dy*i]=="BN"){
				stop_tir = false;
			}//Immobilisation du bleu
	
			
 		
			boolean Arret = false;
	        while (Arret == false){
	            Thread.sleep(120);
	        	if (StdDraw.isKeyPressed(38)){ //fleche haut pour bonhomme bleu
	        		deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 0, B_bleu_y, 1);
	        	}
	        	if (StdDraw.isKeyPressed(40)){ //fleche bas pour bonhomme bleu
	        		deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 0, B_bleu_y, -1);
	        	}
	        	if (StdDraw.isKeyPressed(37)){ //fleche gauche pour bonhomme bleu
	        		deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, -1, B_bleu_y, 0);
	        	}
	        	if (StdDraw.isKeyPressed(39)){ //fleche droite pour le bonhomme bleu
	        		deplacerbonhomme(B_bleu_couleurcase, B_bleu_couleur, B_bleu_x, 1, B_bleu_y, 0);
	        	}
	        	if (StdDraw.isKeyPressed(90)){ //fleche haut pour le bonhomme rouge
	        		deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 0, B_rouge_y, 1);
	        	}
	        	if (StdDraw.isKeyPressed(83)){ //fleche bas pour le bonhomme rouge
	        		deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 0, B_rouge_y, -1);
	        	}
	        	if (StdDraw.isKeyPressed(81)){ //fleche gauche pour le bonhomme rouge
	        		deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, -1, B_rouge_y, 0);
	        	}
	        	if (StdDraw.isKeyPressed(68)){ //fleche droite pour le bonhomme rouge
	        		deplacerbonhomme(B_rouge_couleurcase, B_rouge_couleur, B_rouge_x, 1, B_rouge_y, 0);
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
	    			ecrirecellule(B_bleu_couleur, B_bleu_x, B_bleu_y);
	    			ecrirecellule(B_rouge_couleur, B_rouge_x, B_rouge_y);
	        	}
	        	if (StdDraw.isKeyPressed(10)){
	        		tir(B_bleu_x, B_bleu_y, 1, 0);
	        	}
	        	if(StdDraw.isKeyPressed(27)){
	        		Arret = true;
	        	}        	
	        } // fin while

			// ------------------------------------------
			// ------------ FIN DU JEU ------------------
			// ------------------------------------------

			StdOut.println("FIN DU PROGRAMME");

		}}


}
