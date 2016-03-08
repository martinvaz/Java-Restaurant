package app;

import java.io.*;
import java.util.ArrayList;


public class AdminMenu {
	
	
	//Menu for users.
	public void Menu () throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		Cuisine cuisine = new Cuisine();
		DrinkMenu drink = DrinkMenu.Instance();
		Menu menu = Menu.Instance();
		TotalPayment total = new TotalPayment();
			
		int value = -1;
		do{			
			System.out.println("Welcome to Jorge's digital restaurant 1.0: ");
			System.out.println("");
			System.out.println("This are the available cuisines: ");
			menu.ShowCuisines();
			System.out.println("");
			System.out.println("0. Exit the restaurant. ");		
			value = Integer.parseInt(br.readLine());
		
		
			if (value!=0){
		        System.out.println("This are the dishes of the chosen cuisine: ");
		        System.out.println("");
		        cuisine.ShowDishes(value);
		        System.out.println("Enter the number of the dish you want to order: ");
		       	value = Integer.parseInt(br.readLine());
		       	cuisine.BuyDish(value);
		       	System.out.println("");
		       	
				System.out.println("Now choose your drink: ");
				System.out.println("");
				drink.ShowDrinks();
				value = Integer.parseInt(br.readLine());
				drink.BuyDrink(value);
				
				do{
					System.out.println("Would you like with your drink: ");
		       		System.out.println("1. Ice ");
		      		System.out.println("2. Lemon ");
		   			System.out.println("3. Ice & Lemon ");
	    			System.out.println("4. No thanks. ");
		       		value = Integer.parseInt(br.readLine());
				
					drink.DrinkLemonIce(value);
				}while ((value<1)||(value>4)); //repeat till value is between 1 and 4
	       			
		       	System.out.println("Your order will be ready soon.");
		       	System.out.println("Total prize: " + total.getTotal() + "zl.");
		       	System.out.println("");
		       	System.out.println("Smacznego!");
		       	value = 0;
			}
		}while(value!=0);
	}
	
	//Admin menu where is possible to add new dishes, cuisines and drinks.
	public void AdminPanel() throws NumberFormatException, IOException{
		Cuisine cuisine = new Cuisine();
		DrinkMenu drink = DrinkMenu.Instance();
		Menu menu = Menu.Instance();
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		

		int value = -1;
		do{			
			System.out.println("Welcome to the restaurant's Admin Panel: ");
			System.out.println("This are the available options: ");
			System.out.println("1. Add new cuisine.");
			System.out.println("2. Add new dish.");
			System.out.println("3. Add new drink.");
			System.out.println("");
			System.out.println("0. Exit Admin Panel. ");		
			value = Integer.parseInt(br.readLine());
			
			switch (value){
				case 1:
					//Menu menu = new Menu();
					menu.NewCuisine();
					break;
				case 2:
					//Cuisine cuisine = new Cuisine();
					cuisine.NewDish();
					break;
				case 3:
					//Drink drink = new Drink();
					drink.NewDrink();
					break;
			}			
		}while (value!=0);
	}
	
	

	@SuppressWarnings("unchecked")
	public void ReadFile(){
		Cuisine cuisine = new Cuisine();
		DrinkMenu drink = DrinkMenu.Instance();
		Menu menu = Menu.Instance();
		
		try {
			FileInputStream in = new FileInputStream("exercise1.dat");
			ObjectInputStream oin = new ObjectInputStream(in);
			
			ArrayList<Cuisine> menuList = null;
			ArrayList<Dish> cuisineList = null;
			ArrayList<Drink> drinkList = null;
			
			drinkList = (ArrayList<Drink>) oin.readObject();
			drink.setDrinkList(drinkList);	
			
			cuisineList = (ArrayList<Dish>) oin.readObject();
			cuisine.setCuisineList(cuisineList);
			
			menuList = (ArrayList<Cuisine>) oin.readObject();
			menu.setMenuList(menuList);						
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void SaveFile() throws IOException{
		Cuisine cuisine = new Cuisine();
		DrinkMenu drink = DrinkMenu.Instance();
		Menu menu = Menu.Instance();
		
		FileOutputStream out = new FileOutputStream("exercise1.dat");
		ObjectOutputStream so= new ObjectOutputStream(out);
		
		so.writeObject(drink.getDrinkList());
		so.writeObject(cuisine.getCuisineList());
		so.writeObject(menu.getMenuList());
			
		so.close();
		out.close();
	}
}