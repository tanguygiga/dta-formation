package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import fr.pizzeria.exception.SoldeException;
import fr.pizzeria.exception.StockageException;

public class Menu {

	private String titre;
	private Scanner scanner;
	private Map<Integer, OptionMenu> actions;

	public Menu(String titre, Scanner scanner) {
		this.titre = titre;
		this.scanner = scanner;
	}

	public Map<Integer, OptionMenu> getActions() {
		return actions;
	}

	public void setActions(Map<Integer, OptionMenu> actions) {
		this.actions = actions;
	}

	public void afficher() {
		System.out.println("\n" + titre);
		System.out.println("Veuillez choisir une action :");
		for (Entry<Integer, OptionMenu> entrySet : actions.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getLibelle());
		}
		System.out.println(actions.size() + 1 + " : Quitter");
	}

	public void executer() {
		int choix = 0;
		while (choix != actions.size() + 1) {
			afficher();
			choix = this.scanner.nextInt();
			this.scanner.nextLine();

			while (choix > actions.size() + 1) {
				System.out.println("\n!!! Entrez une valeur autorisée !!!\n");
				afficher();
				choix = this.scanner.nextInt();
				this.scanner.nextLine();
			}
			if (choix != actions.size() + 1) {
				try {
					actions.get(choix).execute();
				} catch (StockageException | SoldeException e) {
					throw new StockageException(e);
				}
			}
		}
	}
}
