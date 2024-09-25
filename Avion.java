package pj;
import java.util.*;

public class Avion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan  = new Scanner(System.in);
		
		
		System.out.println("*******************************************");
		System.out.println("*******************************************");
		System.out.println("Bienvenu au Programme FMS-AIRBUS");
		System.out.println("*******************************************");
		System.out.println("*******************************************");

		displayMenu();
		scan.close();
		
		
		
	}

	public static String sendFly(String id, String program, String phaseAcutally, String type) {
		
		return "Id: "+id + "/ Program: " + program +"/ Phase actually:  " + phaseAcutally + "/ Type: "+ type;
		
	}
	public static String checkScan(Scanner scan,  String promptOnError) {
			
			// Tant que c'est pas une lettre on boucle 
			while(!scan.hasNextLine()) {
				System.out.println(promptOnError);	
				// Important : il faut vider le SCAN incorrect sinon boucle infinyty
				//scan.nextLine();
			}
			String str = scan.nextLine();	
			scan.nextLine(); // On vide le buffer
			return str; 
		}
	public static void displayMenu() {
		
		Scanner scan = new Scanner(System.in);
		String[] displayStr = {"1: Afficher tous les avions", 
								"2: Afficher tous les avions contenant un mots clé dans le programme",
								"3: Ajouter ou supprimer une pièce pour un avion donné",
								"4: Afficher un avion avec les infos détaillées de chaque pièce",
								"5: Quitter l'application"};
		
		// affichage du menu de début 
		for(String str: displayStr) {
			System.out.println(str);
		}
		// parcour du tab du menu de présentation et récupration de la saisie users
		for(int i = 1; i < displayStr.length; i++) {
				int scanInput = scan.nextInt();
				while(scanInput > 5 || scanInput < 1) {
					System.out.println("Erreur: chiffre en 1 et 5");
					scanInput = scan.nextInt();
				}
				switch(scanInput) {
						case 1:
							// send function allflay
							allFlay();
							break; 
						case 2:
							displayByPiece();
							break; 
						case 3:
							displayShop();
							break; 
						
			
			}
		}
		
		scan.close();
		
	}
	public static void allFlay() {
		String[] avion1 = {"1:", "A380", "study feasibilty", "transport passenger","", ""};
		String[] avion2 = {"2:", "A400M", "design", "freight", "",""};
		String[] avion3 = {"3:", "A320", "definition", "military","",""};
		String[] avion4 = {"4:", "A300", "closed", "business aircraft","",""};
		String[] avion5 = {"5:", "B300", "closed", "business aircraft","",""};
		String[] avion6 = {"6:","B450", "study feasibilty", "transport passenger","",""};
		String[][] allFly2 = {
					avion1,
					avion2,
					avion3,
					avion4,
					avion5,
					avion6
				
		};
		for(int k = 0; k < allFly2.length; k++) {
			for(int j = 0; j < allFly2.length; j++) {
				System.out.println(allFly2[k][j]);
				
			}
		}
	}
	public static void displayByPiece() {
		Scanner scan  = new Scanner(System.in);
		System.out.println("Entrez votre mot clé pour la recherche");
		String wordKey = scan.nextLine();
		
		String fly1 = sendFly("1", "A380", "study feasibilty", "transport passenger");
		String fly2 = sendFly("2", "A400M", "design", "freight"); 
		String fly3 = sendFly("3", "A320", "definition", "military");
		String fly4 = sendFly("4", "A300", "closed", "business aircraft");
		String fly5 = sendFly("5", "B300", "closed", "business aircraft");
		String fly6 = sendFly("6", "B450", "study feasibilty", "transport passenger");
		String[] allFly2 = {fly1,
							fly2,
							fly3,
							fly4,
							fly5,
							fly6
				
		};
		boolean verif = false; 
		for(String fly: allFly2) {
			if(fly.contains(wordKey)) {
				System.out.println(fly);
				verif = true; 
			}
		}
		if(!verif) {
			System.out.println("Erreur de saisie");
		}
		//scan.close();
	}
	public static void displayShop() {
		
		String[] displayMenuShop = {"1: Afficher toutes les pièces dispo", 
				"2: Ajouter une pièce",
				"3: Supprimer une pièce",
				"4: Quitter la boutique des pièces"};
		
			// display menu
		for(String shop: displayMenuShop) {
			System.out.println(shop);
		}
			String[][] arrayShop = {
					
					{"ID", "NOM", "CATEGORIE","PRIX"},
					{"1", "compas", "navigation", "5000"},
					{"2", "gps", "navigation", "1000"},
					{"3", "indic vitesse", "pilotage", "7500"},
					{"4", "indic altitude", "pilotage", "3500"},
					{"5", "altimètre", "pilotage", "3500"},
					{"6", "radar météo", "environnement de vol", "15000"},
					{"7", "sys anti collision", "environement de vol", "50000"},

			};
	}

}
	
