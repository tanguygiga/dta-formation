package fr.pizzeria.model;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza {

	public int id;
	@ToString
	public String code;
	@ToString
	public String nom;
	@ToString
	public Double prix;

	public Double getPrix() {
		return prix;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int nbPizzas;
	@ToString
	public CategoriePizza categorie;

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;

		nbPizzas++;

	}

	@Override
	public String toString() {

		String temp = "";
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {

				ToString annotationTrouve = champ.getAnnotation((ToString.class));

				if (annotationTrouve != null) {

					if (champ.getAnnotation((ToString.class)).uppercase() == false) {

						temp += champ.get(this).toString() + " ";
					} else {
						temp += champ.get(this).toString().toUpperCase() + " ";
					}
				}

			}
		}

		catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();

		}
		return temp;
	}

	public String toCSV() {

		String temp = "";

		temp += id + ";" + code + ";" + nom + ";" + prix + ";" + categorie.getLibelle();

		return temp;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza pizza = (Pizza) obj;
		return new EqualsBuilder().append(id, pizza.getId()).append(code, pizza.getCode()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(89, 97).append(id).append(code).toHashCode();
	}
}
