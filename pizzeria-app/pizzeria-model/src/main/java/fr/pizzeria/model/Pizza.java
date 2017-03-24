package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQueries({ @NamedQuery(name = "pizza.readAll", query = "select p from Pizza p"),
		@NamedQuery(name = "pizza.getByCode", query = "select p from Pizza p where p.code = :code") })
public class Pizza implements Comparable<Pizza> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ToString(uppercase = true)
	private String code;

	@ToString
	private String nom;

	@ToString
	private Double prix;

	@ToString
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	public Pizza(String code, String nom, Double prix, CategoriePizza category) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = category;
	}

	public Pizza() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		StringBuilder builder = new StringBuilder();

		if (code != null) {
			builder.append(code);
			builder.append(" - ");
		}
		if (nom != null) {
			builder.append(nom);
			builder.append(" ");
		}
		if (prix != null) {
			builder.append("(");
			builder.append(prix);
			builder.append(" €)");
		}
		if (categorie != null) {
			builder.append(" ~");
			builder.append(categorie);
		}
		return builder.toString();
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
