/**********************************************
 * Workshop 1 
 * Course:APD545 - Fall 2023 
 * Last Name:Thakkar 
 * First Name:Harshil 
 * ID: 160431219 Section:NBB 
 * This assignment represents my own work in accordance with Seneca Academic Policy. 
 * Signature Date:Sep 20, 2023
 **********************************************/
package application;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Product> items = new ArrayList<Product>();

//	add a new product to the cart
	public void addProductToCart(Product p) {
		items.add(p);
	}

//	removes a product from the cart
	public void removeProductFromCart(Product p) {
		items.remove(p);
	}

//	returns the total cost of all items in the cart
	public double totalCostOfItems() {
		double total = 0;
		for (var i : items) {
			total += i.getPrice();
		}
		return total;

	}

//	displays all items in the cart 
	public void displayAllItems() {
		System.out.println("**************************************");
		System.out.println("* Items In The Cart");
		System.out.println("**************************************");
		for (var i : items) {
			System.out.println("Name: " + i.getName());
			System.out.println("ID: " + i.getProductID());
			System.out.println("Description: " + i.getDescription());
			System.out.println("Price: " + i.getPrice());
			System.out.println("**************************************");
		}

	}

}