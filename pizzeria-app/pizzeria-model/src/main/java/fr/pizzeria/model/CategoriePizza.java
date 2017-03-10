package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("VIANDE"), POISSON("POISSON"), VEGETARIEN("VEGETARIEN");

	private String libelle;

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
