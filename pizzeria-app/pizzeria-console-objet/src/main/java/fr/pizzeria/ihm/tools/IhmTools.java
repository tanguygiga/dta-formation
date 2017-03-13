package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza, String> daoPizza;
	private IClientDao daoClient;

	public IhmTools(IDao<Pizza, String> dao) {
		this.daoPizza = dao;
	}

	public IDao<Pizza, String> getDaoPizza() {
		return daoPizza;
	}

	public IClientDao getDaoClient() {
		return daoClient;
	}

	public Scanner getSc() {
		return sc;
	}
}
