package com.techelevator.shelter.model;



public class Shelter {
	
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	public Shelter() {
		
	}

	public Shelter(int id, String name, String address, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
	    return "\n--------------------------------------------" +
	            "\n Shelter Details" +
	            "\n--------------------------------------------" +
	            "\n Id: " + id +
	            "\n Name:'" + name + '\'' +
	            "\n Address: " + address +
	            "\n City: " + city + ", " + state + " " + zipcode;
	}

}


