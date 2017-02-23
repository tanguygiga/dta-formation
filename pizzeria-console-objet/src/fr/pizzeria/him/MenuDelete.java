package fr.pizzeria.him;

public class MenuDelete extends Menu {

	public MenuDelete() {
		super(4, "Supprimer une pizza");
	}

	@Override
	public void execute() {

		System.out.println("Vous avez choisi :\n" + index + ". " + name);

	}

}
