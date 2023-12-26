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

public class User {
	private int userId;
	private String userName;
	private String userAddress;
	private ShoppingCart cart = new ShoppingCart();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

//	no-arg constructor
	public User() {

	}

//	3-arg constructor 
	public User(int id, String name, String address) {
		setUserId(id);
		setUserName(name);
		setUserAddress(address);
	}

	/**
	 * @return the cart
	 */
	public ShoppingCart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
}