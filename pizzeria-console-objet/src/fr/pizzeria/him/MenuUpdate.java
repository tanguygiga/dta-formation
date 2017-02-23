package fr.pizzeria.him;

public class MenuUpdate extends Menu {

	public MenuUpdate() {
		super(3, "Mettre à jour une pizza");
	}

	@Override
	public void execute() {

		System.out.println("Vous avez choisi :\n" + index + ". " + name);

	}

}
