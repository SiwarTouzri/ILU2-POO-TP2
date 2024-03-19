package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		if (!controlPrendreEtal.verifierIdentite(nomVendeur) ) {
			System.out.println("Je suis désolée "+ nomVendeur+ "mais il faut etre un habitant de notre village pour commercer ici");
		}
		else {
			System.out.println("Bonjour "+ nomVendeur +"je vais regarder si je peux vous trouver un étal");
 
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+ nomVendeur+"je n'ai plus d'étal qui ne soit pas déjà occupé");
				
			}
			else {
				installerVendeur(nomVendeur) ; 
				 
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder() ;
		question.append("C'est parfait , il me reste un étal pour vous !" ) ; 
		question.append("Il me faudrait quelques renseignements :") ; 
		question.append("Quel produit souhaitez-vous vendre ? " ) ; 
		String produit = Clavier.entrerChaine(question.toString()) ;
		question.append("Combien souhaitez-vous en vendre ?") ; 
		int nbProduit = Clavier.entrerEntier(question.toString()) ;
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit) ; 
		if (numeroEtal !=-1 ) {
			System.out.println("Le vendeur "+ nomVendeur + "s'est installé à l'étal n°"+ numeroEtal);
		}
		
		
	}
}
