package fr.pizzeria.ihm.pizza;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

@Controller
public class DeletePizza extends OptionMenu {

	private Scanner scanner;
	private IDao<Pizza, String> dao;

	@Autowired
	public DeletePizza(IDao<Pizza, String> dao, Scanner scanner) {
		super();
		this.dao = dao;
		this.scanner = scanner;
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}

	@Override
	public void execute() throws StockageException {
		System.out.println("Veuillez choisir le code de la pizza a supprimer (99 pour abandonner)");
		String code = this.scanner.nextLine();
		if (code != "99") {
			try {
				this.dao.delete(code);
			} catch (StockageException e) {
				throw new StockageException(e + "\n!!! Code incorrect, cette pizza n'existe pas");
			}
		}
	}

}
