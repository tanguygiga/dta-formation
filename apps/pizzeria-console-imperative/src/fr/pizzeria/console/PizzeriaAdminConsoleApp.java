package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// initialisation des variables

		Object code_pizza;
		String nom_pizza;
		Double prix_pizza;
		int longueur;

		Object tableauPizza[][] = { { "PEP", "Pépéroni", 12.5 }, { "MAR", "Margherita", 14.00 },
				{ "REI", "La Reine", 11.50 }, { "FRO", "La 4 fromages", 12.00 }, { "CAN", "La cannibale", 12.50 },
				{ "SAV", "La savoyarde", 13.00 }, { "ORI", "L’orientale", 13.50 }, { "IND", "L'indienne", 14.00 } };

		int menu = 0;
		Scanner scan = new Scanner(System.in);

		String menu_principal = ("***** Pizzeria Administration *****\n" + "1. Lister les pizzas\n"
				+ "2. Ajouter une nouvelle pizza\n" + "3. Mettre à jour une pizza\n" + "4. Supprimer une pizza\n"
				+ "99. Sortir");

		// sélection du menu

		do {
			System.out.println("\n" + menu_principal);

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				for (int i = 0; i < tableauPizza.length; ++i) {
					System.out.println(
							tableauPizza[i][0] + " -> " + tableauPizza[i][1] + " (" + tableauPizza[i][2] + " €)");
				}

				break;

			case 2:

				longueur = tableauPizza.length;
				System.out.println("Veuillez saisir le code");
				code_pizza = scan.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nom_pizza = scan.next();
				System.out.println("Veuillez saisir le prix");
				prix_pizza = scan.nextDouble();
				Object tableau_modified[][] = new Object[longueur + 1][3];
				System.arraycopy(tableauPizza, 0, tableau_modified, 0, longueur);
				tableau_modified[longueur][0] = code_pizza;
				tableau_modified[longueur][1] = nom_pizza;
				tableau_modified[longueur][2] = prix_pizza;
				tableauPizza = tableau_modified;

				break;
			case 3:
				for (int i = 0; i < tableauPizza.length; ++i) {
					System.out.println(
							tableauPizza[i][0] + " -> " + tableauPizza[i][1] + " (" + tableauPizza[i][2] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.\n" + "(99 pour abandonner).");
				int numModif = scan.nextInt() - 1;
				System.out.println("Veuillez saisir le code");
				code_pizza = scan.next();
				System.out.println("Veuillez saisir le nom (sans espace)");
				nom_pizza = scan.next();
				System.out.println("Veuillez saisir le prix");
				prix_pizza = scan.nextDouble();
				tableauPizza[numModif][0] = code_pizza;
				tableauPizza[numModif][1] = nom_pizza;
				tableauPizza[numModif][2] = prix_pizza;

				for (int i = 0; i < tableauPizza.length; ++i) {
					System.out.println(
							tableauPizza[i][0] + " -> " + tableauPizza[i][1] + " (" + tableauPizza[i][2] + " €)");
				}

				break;

			case 4:
				longueur = tableauPizza.length;

				for (int i = 0; i < tableauPizza.length; ++i) {
					System.out.println(
							tableauPizza[i][0] + " -> " + tableauPizza[i][1] + " (" + tableauPizza[i][2] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à supprimer.\n" + "(99 pour abandonner).");
				int numSuppr = scan.nextInt();
				Object tableauReduit[][] = new Object[longueur - 1][3];
				System.arraycopy(tableauPizza, 0, tableauReduit, 0, numSuppr - 1);
				System.arraycopy(tableauPizza, numSuppr, tableauReduit, numSuppr - 1, longueur - numSuppr);
				tableauPizza = tableauReduit;
				for (int i = 0; i < tableauReduit.length; ++i) {
					System.out.println(
							tableauPizza[i][0] + " -> " + tableauPizza[i][1] + " (" + tableauPizza[i][2] + " €)");
				}

			}

		} while (menu != 99);

	}

}
