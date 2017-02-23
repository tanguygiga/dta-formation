package fr.pizzeria.model;

public class Pizza {

	int id;
	String code;
	String nom;
	double prix;
	public static int nbPizzas;

	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	void PrintPizza() {
		System.out.println(id + " - " + code + "\t" + nom + "\t" + prix);
	}

}
