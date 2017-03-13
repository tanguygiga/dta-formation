package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

public class MenuClient extends Menu {

	public MenuClient(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionClientInscrire(ihmTools));
		actions.put(2, new OptionClientConnecter(ihmTools));
		actions.put(99, new OptionSortir(ihmTools));
	}

}
