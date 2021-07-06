/**
 * @author Michel
 *  
* 		L'objectif est de calculer le revenu par tranche d'imposition 
 * 
 * 
 * 			--------------------
 * 			calculTranche		--> stocke le revenu calculé
			tranchex			--> stocke le total de la tranche X en fonction du tablea d'imposition
		
 */

package Impot_package;
//bareme
public class Bareme {
	private double calculTranche;
	private double tranche1;
	private double tranche2;
	private double tranche3;
	private double tranche4;
	
	

		public  double calculBareme() {	
			
			/**
			 *  si le revenu est supérieure à une tranche on multiplie toute la tranche par le % d'imposition
			 *  si le revenu est inférieur à la tranche on calcul le reste et on le multiplie par le % d'imposition
			 */
			
		
			// on soustrait la tranche à 0%
			if (calculTranche>9807){
				calculTranche=calculTranche-9807;
			}
			
			
			//Calcul tranche 14%
			if (calculTranche<=17279) {
				tranche1=calculTranche*0.14;	
				return tranche1;
			}
			else  {
				tranche1=(27086-9807)*0.14;
				calculTranche=calculTranche-17279;
						
			}
			
			//	Calcul tranche 30%
			if (calculTranche<=45531) {
				tranche2=calculTranche*0.30;
				return tranche1+tranche2;
			
				
			}
			else {
				tranche2=(72617-27086)*0.30;
				calculTranche=calculTranche-45531;
			}			
			
			// Calcul tranche4 41%
			if (calculTranche<=81166) {
				tranche3=calculTranche*0.41;
				return tranche1+tranche2+tranche3;
				
			}
			else {
				tranche3=(153783-72617)*0.41;	
				calculTranche=calculTranche-81166;
			}
			
			// Calcul tranche4 45%
			if (calculTranche>0 ) {
				tranche4=calculTranche*0.45;	
				
			}
			
			/**
			 * @return : additionne les tranches 
			 */
			return tranche1+tranche2+tranche3+tranche4;
			
		}
			
		public void setcalculTranche(double rNet) {			
			calculTranche= rNet;			
		}
				
			
		public double getcalculTranche() {
			return calculTranche;
		}	

		
}
