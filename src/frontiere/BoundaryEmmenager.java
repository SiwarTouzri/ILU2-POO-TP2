package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder phrase = new StringBuilder() ; 
					phrase.append("Bienvenu villageois " + nomVisiteur) ; 
					phrase.append("Quelle est votre force ? ") ; 
					int choixForce =Clavier.entrerEntier(phrase.toString()) ;
					controlEmmenager.ajouterGaulois(nomVisiteur, choixForce);
					break;
					

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder string = new StringBuilder( ); 
		string.append("Bienvenu druide " + nomVisiteur ) ; 
		string.append("Quelle est votre force ? " ) ; 
		int forceDruide = Clavier.entrerEntier(string.toString()) ;
		int effetPotionMin ; 
		int effetPotionMax ; 
		do {
			StringBuilder question2 = new StringBuilder() ; 
			question2.append("Quelle est la force de potion la plus faible que vous produisiez ? ") ; 
			effetPotionMin = Clavier.entrerEntier(question2.toString()) ; 
			StringBuilder question3 = new StringBuilder() ; 
			question3.append("Quelle est la force de potion la plus forte que vous produisez ?  ") ; 
			effetPotionMax = Clavier.entrerEntier(question3.toString()) ; 
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide , vous vous etes trompé entre le minimum et le maximum ");
			}
			
		}while ( effetPotionMin>effetPotionMax) ; 
		controlEmmenager.ajouterDruide(nomVisiteur , forceDruide , effetPotionMin , effetPotionMax ); 
	}
}
