package fr.pizzeria.admin.tool.event;

import java.time.ZonedDateTime;

import fr.pizzeria.model.Pizza;

public class DeletePizzaEvent {

	private Pizza pizza;
	private ZonedDateTime creationTime;

	public DeletePizzaEvent(Pizza pizza) {
		this.pizza = pizza;
		this.creationTime = ZonedDateTime.now();
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}
}