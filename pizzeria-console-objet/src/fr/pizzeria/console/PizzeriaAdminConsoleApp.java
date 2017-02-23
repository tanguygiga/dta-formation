package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	}

	public static void main(String[] args) {

		// initialisation des variables

		String codePizza;
		String nomPizza;
		Double prixPizza;
		int longueurModif;

		Pizza[] tableauPizza = { new Pizza(0, "PEP", "Pépéroni", 12.5), new Pizza(1, "MAR", "Margherita", 14.00),
				new Pizza(2, "REI", "La Reine", 11.50), new Pizza(3, "FRO", "La 4 fromages", 12.00),
				new Pizza(4, "CAN", "La cannibale", 12.50), new Pizza(5, "SAV", "La savoyarde", 13.00),
				new Pizza(6, "ORI", "L’orientale", 13.50), new Pizza(7, "IND", "L'indienne", 14.00) };

		int menu = 0;
		Scanner scan = new Scanner(System.in);

		String menu_principal = ("***** Pizzeria Administration *****\n" + "1. Lister les pizzas\n"
				+ "2. Ajouter une nouvelle pizza\n" + "3. Mettre à jour une pizza\n" + "4. Supprimer une pizza\n"
				+ "99. Sortir");

		// Sélection du menu

		do {
			System.out.println("\n" + menu_principal);

			menu = scan.nextInt();

			switch (menu) {

			case 1:

				afficher(tableauPizza);

				break;

			case 2:
				// Ajout d'une pizza

				afficher(tableauPizza);

				longueurModif = tableauPizza.length + 1;
				System.out.println("Veuillez saisir le code");
				codePizza = scan.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nomPizza = scan.next();
				System.out.println("Veuillez saisir le prix");
				prixPizza = scan.nextDouble();

				Pizza pizzaNEW = new Pizza(longueurModif, codePizza, nomPizza, prixPizza);

				Pizza[] tableauModified = new Pizza[longueurModif];

				System.arraycopy(tableauPizza, 0, tableauModified, 0, tableauPizza.length);

				tableauModified[tableauPizza.length] = pizzaNEW;

				afficher(tableauModified);
				System.out.println("-> " + longueurModif + " pizzas créées depuis l'initialisation du programme");

				break;

			case 3:

				// Mettre à jour une pizza

				afficher(tableauPizza);

				System.out.println("Veuillez choisir la pizza à modifier.\n" + "(99 pour abandonner).");
				int numModif = scan.nextInt() - 1;
				System.out.println("Veuillez saisir le code");
				codePizza = scan.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nomPizza = scan.next();
				System.out.println("Veuillez saisir le prix");
				prixPizza = scan.nextDouble();

				tableauPizza[numModif] = new Pizza(numModif, codePizza, nomPizza, prixPizza);

				afficher(tableauPizza);

				break;

			case 4:
				// Supprimer une pizza

				afficher(tableauPizza);

				longueurModif = tableauPizza.length - 1;

				System.out.println("Veuillez choisir la pizza à supprimer.\n" + "(99 pour abandonner).");
				int indexSuppr = scan.nextInt() - 1;

				Pizza[] tableauReduit = new Pizza[longueurModif];

				System.arraycopy(tableauPizza, 0, tableauReduit, 0, indexSuppr);
				System.arraycopy(tableauPizza, indexSuppr + 1, tableauReduit, indexSuppr, longueurModif - indexSuppr);
				tableauPizza = tableauReduit;

				afficher(tableauPizza);

			}
		} while (menu != 99);
		System.out.println("Au revoir !");
	}
}
