package com.techelevator.shelter;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import com.techelevator.shelter.models.AuthenticatedUser;
import com.techelevator.shelter.models.UserCredentials;
import com.techelevator.shelter.services.AuthenticationService;
import com.techelevator.shelter.services.AuthenticationServiceException;
import com.techelevator.view.ConsoleService;

public class App {

	private static final String API_BASE_URL = "http://localhost:8080/";

	private static final String MENU_OPTION_EXIT = "Exit";
	private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN,
			MENU_OPTION_EXIT };
	private static final String MAIN_MENU_OPTION_VIEW_SHELTER = "View all Shelters";
	private static final String MAIN_MENU_OPTION_VIEW_DOGS = "View all Dogs";
	private static final String MAIN_MENU_OPTION_VIEW_DOGS_BY_SHELTER = "View all Dogs by Shelter ID";
	private static final String MAIN_MENU_OPTION_ADD_DOG = "Add a new Dog to a shelter";
	private static final String MAIN_MENU_OPTION_UPDATE_EXISTING_DOG = "Update existing dog by Dog ID";
	private static final String MAIN_MENU_OPTION_ADOPT_DOG = "Adopt a Dog by Dog ID";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_SHELTER, MAIN_MENU_OPTION_VIEW_DOGS,
			MAIN_MENU_OPTION_VIEW_DOGS_BY_SHELTER, MAIN_MENU_OPTION_ADD_DOG,
			MAIN_MENU_OPTION_UPDATE_EXISTING_DOG, MAIN_MENU_OPTION_ADOPT_DOG, MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };


	private AuthenticatedUser currentUser;
	private ConsoleService console;
	private AuthenticationService authenticationService;

	public static void main(String[] args) {
		App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL));
		app.run();
	}

	public App(ConsoleService console, AuthenticationService authenticationService) {
		this.console = console;
		this.authenticationService = authenticationService;

	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to the Puppy Shelter and Dog Finder App! *");
		System.out.println("*********************");

		registerAndLogin();
		mainMenu();
	}

	private void mainMenu() {
		while (true) {

			String choice = (String) console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (MAIN_MENU_OPTION_VIEW_SHELTER.equals(choice)) {
				System.out.println("view shelters");

			} else if (MAIN_MENU_OPTION_VIEW_DOGS.equals(choice)) {
				System.out.println("View all dogs");

			} else if (MAIN_MENU_OPTION_VIEW_DOGS_BY_SHELTER.equals(choice)) {
				System.out.println("View dogs by shelter id");

			} else if (MAIN_MENU_OPTION_ADD_DOG.equals(choice)) {
				System.out.println("Add ");

			} else if (MAIN_MENU_OPTION_UPDATE_EXISTING_DOG.equals(choice)) {
				
			}else if (MAIN_MENU_OPTION_ADOPT_DOG.equals(choice)) {

			} else if (MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}

		}
	}

	private void printHR(int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while (!isAuthenticated()) {
			String choice = (String) console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
		while (!isRegistered) // will keep looping until user is registered
		{
			UserCredentials credentials = collectUserCredentials();
			try {
				authenticationService.register(credentials);
				isRegistered = true;
				System.out.println("Registration successful. You can now login.");
			} catch (AuthenticationServiceException e) {
				System.out.println("REGISTRATION ERROR: " + e.getMessage());
				System.out.println("Please attempt to register again.");
			}
		}
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) // will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
			try {
				currentUser = authenticationService.login(credentials);
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: " + e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}

	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
}
