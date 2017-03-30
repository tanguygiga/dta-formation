package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.pizza.CreatePizza;
import fr.pizzeria.ihm.pizza.DeletePizza;
import fr.pizzeria.ihm.pizza.ListeCategorie;
import fr.pizzeria.ihm.pizza.ReadPizzas;
import fr.pizzeria.ihm.pizza.UpdatePizza;

@Controller
public class Menu {

	private String titre;
	private Scanner scanner;
	private Map<Integer, OptionMenu> actions;
	@Autowired
	private ApplicationContext ac;

	@Autowired
	public Menu(@Value("${app.title}") String titre, Scanner scanner) {
		this.titre = titre;
		this.scanner = scanner;
	}

	@PostConstruct
	public void init() {
		this.actions = new TreeMap<>();
		this.actions.put(1, ac.getBean(ReadPizzas.class));
		this.actions.put(2, ac.getBean(CreatePizza.class));
		this.actions.put(3, ac.getBean(UpdatePizza.class));
		this.actions.put(4, ac.getBean(DeletePizza.class));
		this.actions.put(5, ac.getBean(ListeCategorie.class));
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
				} catch (StockageException e) {
					throw new StockageException(e);
				}
			}
		}
	}
}
