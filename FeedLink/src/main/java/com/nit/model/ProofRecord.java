package com.nit.model;

public class ProofRecord {

	private String restaurantUser;
	private String ngoUser;
	private String foodName;
	private String quantity;
	private int expiresInHours;
	private String phone;
	private String address;
	private String proofImagePath;

	public ProofRecord() {
	}

	public String getRestaurantUser() {
		return restaurantUser;
	}

	public void setRestaurantUser(String restaurantUser) {
		this.restaurantUser = restaurantUser;
	}

	public String getNgoUser() {
		return ngoUser;
	}

	public void setNgoUser(String ngoUser) {
		this.ngoUser = ngoUser;
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

	public String getProofImagePath() {
		return proofImagePath;
	}

	public void setProofImagePath(String proofImagePath) {
		this.proofImagePath = proofImagePath;
	}
}
