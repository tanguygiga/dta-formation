package fr.pizzeria.him;

public class MenuOut extends Menu {

	public MenuOut() {
		super(99, "Sortir");
	}

	@Override
	public void execute() {

		System.out.println("Vous avez choisi :\n" + index + ". " + name);

	}
}
