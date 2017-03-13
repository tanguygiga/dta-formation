package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

public class OptionClientInscrire extends OptionMenu {

	public OptionClientInscrire(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "S'inscrire";
	}

	@Override
	public void execute() {
		System.out.println("J'inscris le client !");

	}

}
