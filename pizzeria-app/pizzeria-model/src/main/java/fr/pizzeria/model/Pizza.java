package fr.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza implements Comparable<Pizza> {

	@Id
	@GeneratedValue
	private int id;

	@ToString(uppercase = true)
	private String code;

	@ToString
	private String nom;

	@ToString
	private double prix;

	@Enumerated
	private CategoriePizza categorie;

	public Pizza(String code, String nom, double prix, CategoriePizza category) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = category;
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

	public CategoriePizza getCategorie() {
		return categorie;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Field field : this.getClass().getDeclaredFields()) {
			appendIfAnnoted(field, sb);
		}
		return sb.toString();
	}

	private StringBuilder appendIfAnnoted(Field field, StringBuilder sb) {
		if (field.isAnnotationPresent(ToString.class)) {
			String fieldValue;
			try {
				fieldValue = field.get(this).toString();

				if (field.getAnnotation(ToString.class).uppercase()) {
					fieldValue = fieldValue.toUpperCase();
				}
				sb.append(fieldValue).append(";");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return sb;
	}

	@Override
	public int compareTo(Pizza pizza) {
		return this.code.compareTo(pizza.getCode());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(23, 31).append(code).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return new EqualsBuilder().append(code, other.code).isEquals();
	}

}
