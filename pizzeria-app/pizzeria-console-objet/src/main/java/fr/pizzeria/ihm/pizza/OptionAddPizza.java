package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionAddPizza extends OptionMenu {

	public OptionAddPizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {

		try {
			ihmTools.getDaoPizza().create(ihmTools.saisir());
		} catch (StockageException e) {
			throw new StockageException("\n!!! Une erreur a été enregistrée : " + e);
		}

	}

}
