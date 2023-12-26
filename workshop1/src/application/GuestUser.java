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

public class GuestUser extends User {
//	no-arg constructor
	public GuestUser() {

	}

//	3-arg constructor 
	public GuestUser(int id, String name, String address) {
		super(id, name, address);
	}
}