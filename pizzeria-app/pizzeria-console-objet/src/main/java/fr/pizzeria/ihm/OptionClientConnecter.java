package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

public class OptionClientConnecter extends OptionMenu {

	public OptionClientConnecter(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Se connecter";
	}

	@Override
	public void execute() {
		System.out.println("Je connecte le client !");

	}

}
