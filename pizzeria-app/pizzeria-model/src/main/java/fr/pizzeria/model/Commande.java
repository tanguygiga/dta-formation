package fr.pizzeria.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numeroCommande;

	private String statut;

	private LocalDate dateCommande;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToMany
	@JoinTable(name = "CommandePizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

}
