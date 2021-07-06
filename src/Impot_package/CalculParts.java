/**
 * @author Michel
 * 
 * 		L'objectif est de calculer le nombre de part par enfant
 * 
 * 
 * 			--------------------
 * 			revenuNetFoyer		--> revenu net du foryer 
			nbEnfants			--> Nombre d'enfant � charge
			marie				--> situation de famille : marie = true si marie sinon marie=false pour c�libataire
 * 			revenuCalculer : 	sert � stocker le calcul avec le nombre de parts 
 * 			quotienFamille : 	tableau des parts en fonction de la sitation familliale
 */


package Impot_package;

public class CalculParts {
	private double 		revenuNetFoyer;
	private  int 		nbEnfants;
	private  boolean 	marie;
	private double 		nbDePart;
	
	
	public double Parts() {
		/**
		 * quotienFamille
		 */
			double revenuCalculer 	=0;											// Sert � stocker le revenu calcul�
			double[] quotienFamille = {1, 2, 1.5, 2.5, 2, 3, 3,4,4,5,1,1 };		// tableau du qutient familliale
			/*
			 * En fonction du nombre d'enfants et de la situation familliale
			 * on calcule le revenu net (revenuCalculer) en le multipliant 
			 * par le nombre de parts
			 */
			
	
			// si C�libataire, divorc� ou veuf
			if (!marie) {
				if (nbEnfants<5){			// on calcul la partie du tableau de quotient familliale jusque 4 enfants
					revenuCalculer=revenuNetFoyer/quotienFamille[nbEnfants*2];
					setnbDePart(quotienFamille[nbEnfants*2]);
				}
				else {
					revenuCalculer=revenuNetFoyer/nbEnfants;  //si plus de 4 enfants, le nombre d'enfants est �gale au nombre de parts
					setnbDePart(nbEnfants);
				}
				
			}
			
			//si Couple mari� ou pacs�
			if (marie) {
				if (nbEnfants<5){			// on calcul la partie du tableau de quotient familliale jusque 4 enfants
					if (nbEnfants==0){		// si le nombre d'enfant =0 on prend la 1er valeur du tableau quotienFamille
						revenuCalculer=revenuNetFoyer/quotienFamille[1];
						setnbDePart(quotienFamille[1]);
					}
					else					// sinon on prend la colonne "Couple mari� ou pacs�" du tableau quotient familliale
					{
						revenuCalculer=revenuNetFoyer/quotienFamille[nbEnfants*2+1];
						setnbDePart(quotienFamille[nbEnfants*2+1]);
					}
				}
				else {						// si le nombre d'enfants est sup�rieur �4 on ajoute 1 part
					revenuCalculer=revenuNetFoyer/nbEnfants+1;
					setnbDePart(nbEnfants+1);
				}
			}

	
			
			/*
			 * @return retourne le salaire calcul�
			 *
			 */
		return revenuCalculer;
		
	}

	public void setNbEnfants(int nbE) {			
		nbEnfants= nbE;			
	}
		
	
	public int getNbEnfants() {
		return nbEnfants;
	}	

	public void setMarie(boolean m) {			
		marie= m;			
	}
		
		public boolean getMarie() {
		return marie;
	}	
		
		public void setRevenuNetFoyer(double revenus) {			
			revenuNetFoyer= revenus;			
		}
			
			public double getRevenuNetFoyer() {
			return revenuNetFoyer;
		}	
		public void setnbDePart(double parts) {			
			nbDePart= parts;			
		}
			
			public double getnbDePart() {
			return nbDePart;
		}	
			
		
	
}
