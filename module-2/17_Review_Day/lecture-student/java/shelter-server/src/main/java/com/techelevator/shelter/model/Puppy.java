package com.techelevator.shelter.model;


public class Puppy {
	
	private int id;
	private String name;
	private String breed;
	private int age;
	private String gender;
	private int shelterId;
	
	public Puppy() {
		
	}
	

	public Puppy(int id, String name, String breed, int age, String gender, int shelterId) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
		this.shelterId = shelterId;
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getShelterId() {
		return shelterId;
	}

	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}


	@Override
	public String toString() {
		return "\n--------------------------------------------" +
	            "\n Shelter Details" +
	            "\n--------------------------------------------" +
				"Puppy id: " + id + 
				"\nName: " + name + 
				"\nBreed: " + breed + 
				"\nAge: " + age + 
				"\nGender: " + gender +
				"\nShelterId: " + shelterId;
	}
	

}
