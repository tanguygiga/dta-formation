package fr.pizzeria.him;

public class MenuSaveNew extends Menu {

	public MenuSaveNew() {
		super(2, "Ajouter une nouvelle pizza");
	}

	@Override
	public void execute() {

		System.out.println("Vous avez choisi :\n" + index + ". " + name);

	}

}
