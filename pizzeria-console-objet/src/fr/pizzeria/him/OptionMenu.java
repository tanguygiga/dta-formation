package fr.pizzeria.him;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionMenu {

	public static void main(String[] args) {

		Menu menuList = new MenuList();
		Menu menuSaveNew = new MenuSaveNew();
		Menu menuUpdate = new MenuUpdate();
		Menu menuDelete = new MenuDelete();
		Menu menuOut = new MenuOut();

		int num;
		boolean enter = false;

		Scanner sc = new Scanner(System.in);

		List<Menu> listMenu = new ArrayList<Menu>();

		listMenu.add(menuList);
		listMenu.add(menuSaveNew);
		listMenu.add(menuUpdate);
		listMenu.add(menuDelete);
		listMenu.add(menuOut);

		while (!enter) {

			System.out.println("***** Pizzeria Administration *****");

			for (Menu option : listMenu)
				System.out.println(option.index + ". " + option.name);

			num = sc.nextInt();
			sc.nextLine();

			for (Menu option : listMenu) {
				if (option.compareTo(num)) {
					option.execute();
					enter = true;
				}
			}
		}
		sc.close();
	}

}
