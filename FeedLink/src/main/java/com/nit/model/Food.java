package com.nit.model;

public class Food {

	private String restaurantUser;
	private String foodName;
	private String quantity;
	private int expiresInHours;
	private String phone;
	private String address;

	public Food() {
	}

	public String getRestaurantUser() {
		return restaurantUser;
	}

	public void setRestaurantUser(String restaurantUser) {
		this.restaurantUser = restaurantUser;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getExpiresInHours() {
		return expiresInHours;
	}

	public void setExpiresInHours(int expiresInHours) {
		this.expiresInHours = expiresInHours;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}