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

public class RegisteredUser extends User {
	private String password;

//	no-arg constructor
	public RegisteredUser() {

	}

//	4-arg constructor 
	public RegisteredUser(int id, String name, String address, String password) {
		super(id, name, address);
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}