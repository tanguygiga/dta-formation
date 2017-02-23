package fr.pizzeria.him;

public class MenuList extends Menu {

	public MenuList() {
		super(1, "Lister les pizzas");
	}

	@Override
	public void execute() {

		System.out.println("Vous avez choisi :\n" + index + ". " + name);

	}

}
