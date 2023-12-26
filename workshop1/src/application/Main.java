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

public class Main {
	public static void main(String[] args) {

//		creating a new product
		Product p1 = new Product();
		p1.setProductID(1);
		p1.setName("iPhone");
		p1.setDescription("iPhone 15 pro max !");
		p1.setPrice(1999.99);
		p1.setQty(2);

//		creating a second product
		Product p2 = new Product();
		p2.setProductID(2);
		p2.setName("MacBook");
		p2.setDescription("Macbook Pro- m2 pro !");
		p2.setPrice(3999.99);
		p2.setQty(3);

//		creating users / an array of users 
		ArrayList<User> users = new ArrayList<>();

//		creating a guest user and adding to array
		users.add(new GuestUser(10, "Elon Musk", "somewhere in USA"));

//		creating a registered user and adding to the array
		users.add(new RegisteredUser(20, "Marc Zuckerburg", "Also somewhere in USA", "ThisISPAssword"));

//		printing program header
		System.out.println("*****************************************");
		System.out.println("* Workshop 1 - Shopping Cart System !");
		System.out.println("*****************************************");

		System.out.println("\n*****************************************");
		System.out.println("* Testing Guest User");
		System.out.println("*****************************************");

//		adding product p1 to the cart of guest user  
		System.out.println("Adding Product 1(p1) to cart !");
		users.get(0).getCart().addProductToCart(p1);
		System.out.println("Sucess !");

		System.out.println("\n*****************************************");
		System.out.println("* Testing Registered User");
		System.out.println("*****************************************");

//		adding product p1 to the cart of registered user
		System.out.println("Adding Product 1(p1) to cart !");
		users.get(1).getCart().addProductToCart(p1);
		System.out.println("Sucess !");

//		adding product p2 to the cart of registered user
		System.out.println("\nAdding Product 2(p2) to cart !");
		users.get(1).getCart().addProductToCart(p2);
		System.out.println("Sucess !");

		System.out.println("\n*****************************************");
		System.out.println("* Testing Polymorphism, display cart function and total cost");
		System.out.println("*****************************************\n");

		for (int i = 0; i < users.size(); i++) {

			System.out.println("\n*****************************************");
			System.out.println("* User " + (i + 1));
			System.out.println("*****************************************\n");

//			displaying the items in cart of the user
			users.get(i).getCart().displayAllItems();

//			calculating and displaying the total of the items in the cart of the user 
			System.out.println("Total for this User is : " + users.get(i).getCart().totalCostOfItems());
			System.out.println("*****************************************\n");
		}

	}
}