package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;


public class DrinkMenu implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DrinkMenu instance;
	
	private DrinkMenu(){		
	}
	
	public static DrinkMenu Instance() {
		if (instance == null) {
			instance = new DrinkMenu();
		}
		return instance;
	}
	
	private ArrayList<Drink> drinkList = new ArrayList<Drink>();
	
	public void setDrinkList(ArrayList<Drink> list){
		this.drinkList=list;
	}
		
	public ArrayList<Drink> getDrinkList(){
		return drinkList;
	}
	
	
	//creates a new drink and add it to the drinks ArrayList
	public void NewDrink() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		Drink drink = new Drink();
		
		System.out.println("Add a new Drink. ");
		
		System.out.print("Name: ");
		drink.setName(br.readLine()); 
		
		System.out.print("Prize: ");
		drink.setPrize(Double.parseDouble(br.readLine()));
		
		drinkList.add(drink);
		ShowDrinks(); //borrar
		
		System.out.print("Drink added to the system.");
		System.out.println();	
	}
	
	//Runs the array and shows all drinks with their prizes.
	public void ShowDrinks(){
		Drink drink = new Drink();
		for(int i=0; i< drinkList.size(); i++){
			drink = drinkList.get(i);
			System.out.println((i+1) + ". " + drink.getName() + " - " + drink.getPrize() + "zl.");
			System.out.println("");
		}
	}
	
	
	//buys a drink and adds the prize to the total prize
	public void BuyDrink(int i){
		Drink drink = new Drink();
		TotalPayment total = new TotalPayment();
		
		drink = drinkList.get(i-1); ////drink number (its i-1 because in ShowDrinks it shows i+1 so theres no drink 0.
		System.out.println(drink.getName() + " - " + drink.getPrize() + "zl. Pruchased");
		total.setTotal(total.getTotal() + drink.getPrize());		
	}
	
	
	//extra option for drinks.
	public void DrinkLemonIce(int option){
		Drink drink = new Drink();
		switch (option){
			case 1: drink.setIce();
					break;
			case 2: drink.setLemon();
					break;
			case 3: drink.setIce();
					drink.setLemon();
					break;
			case 4: break;
		}
	}
	


}
