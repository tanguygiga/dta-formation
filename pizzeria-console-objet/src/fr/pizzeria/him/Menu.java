package fr.pizzeria.him;

public abstract class Menu {

	int index;

	String name;

	public abstract void execute();

	public boolean compareTo(int i) {
		return i == index;
	}

	public Menu(int index, String name) {
		super();
		this.index = index;
		this.name = name;
	}

}
