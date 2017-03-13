package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

public class OptionSortir extends OptionMenu {

	public OptionSortir(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Sortir";
	}

	@Override
	public void execute() {
		System.out.println("Je sors du programme !");

	}

}
