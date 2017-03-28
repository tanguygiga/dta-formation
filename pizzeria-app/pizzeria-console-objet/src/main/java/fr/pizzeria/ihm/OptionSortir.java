package fr.pizzeria.ihm;

public class OptionSortir extends OptionMenu {

	public OptionSortir() {
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
