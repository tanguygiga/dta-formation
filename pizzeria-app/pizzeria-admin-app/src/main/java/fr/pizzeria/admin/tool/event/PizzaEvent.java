package fr.pizzeria.admin.tool.event;

import java.time.ZonedDateTime;

import fr.pizzeria.model.Pizza;

public class PizzaEvent {

	private Pizza pizza;
	private String methodName;
	private ZonedDateTime creationTime;

	public PizzaEvent(Pizza pizza) {
		this.pizza = pizza;
		this.methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		this.creationTime = ZonedDateTime.now();
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}
}
