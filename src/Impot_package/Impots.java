/*
 * Ce programme permet de calculer l'impot sur le revenu
 * 
 * 				VARIABLES
 * 				---------
 * 		marie = marie (true) célibataire (false) 
 * 		situationFamille : recupere le 'c' ou le 'm' de la variable marie. Elle sera convertie en true ou false pour positionner 'mari'
 * 		nbEnfants/enfantCharge = Nombre d'enfants
 * 		revenuNetFoyer = Revenu net du foyer
 */
package Impot_package;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Impots {

	public static void main(String[] args) {
		/**
		 * 		// Initialisation des variables et on les transmet à l'objet CalculParts()
		 * 		calculParts.setRevenuNetFoyer(sc.nextDouble())	--> Revenus
		 * 		char  situationFamille = sc1.next().charAt(0)	--> situation de famille
		 *		calculParts.setNbEnfants(sc2.nextInt());		--> nombre d'enfants
		 */
					
		
		
		boolean marie;			// si marie=true = marié si true = célibataire
		
		
		CalculParts calculParts = new CalculParts();   // instanciation de l'objet calculParts
		System.out.println("Bienvenue dans le programme des impots\n\n");
		System.out.println("Revenu net imposable foyer ? ");
		Scanner sc = new Scanner(System.in);
		calculParts.setRevenuNetFoyer(sc.nextDouble());
		System.out.println("\n\nEtes-vous marié ou pacsé ? (O) pour Oui (N) pour Non ");
		Scanner sc1 = new Scanner(System.in);
		char  situationFamille = sc1.next().charAt(0);
		// on affecte à 'marie' true pour dire que c'est une personne marie sinon false pour célibataire
		if (situationFamille=='O' || situationFamille=='o') {
			marie=true;
		}
		else
		{
			marie=false
					;
		}
		calculParts.setMarie(marie);
		System.out.println("\n\nNombre d'enfant à charge? ");
		Scanner sc2 = new Scanner(System.in);
		calculParts.setNbEnfants(sc2.nextInt());

		/**
		 * Ici on fait la demande de calcul des parts .
		 * Le résultat sera stocker dans 'revenuCalculer'
		 */
		double revenuCalculer=calculParts.Parts();
		
		/**
		 *  Ici on initialise l'objet Bareme
		 *  ensuite on calcul l'impot par tranche
		 */
		
		Bareme calculImpots = new Bareme(); // instanciation de l'objet calculImpots
		calculImpots.setcalculTranche(revenuCalculer);   // calcul des tranches
		
		
		// affichage du résultats finale. On multiplier le résultat obtenu par le nombre de parts du quotient familial
		
		DecimalFormat df = new DecimalFormat("##,###,###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String résultatFinal = df.format(calculImpots.calculBareme()*calculParts.getnbDePart());
		//double résultatFinal = Double.valueOf((df.format(calculImpots.calculBareme())*calculParts.getnbDePart()));
		
		
	
		//double résultatFinal = (Math.round((calculImpots.calculBareme())*calculParts.getnbDePart()))/100;
		System.out.println("L’impôt à payer est de : "+résultatFinal+ " €");  
		
		// on ferme proprement les objets Scanner
		sc.close();
		sc1.close();
		sc2.close();
	}

}
