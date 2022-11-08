package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.text.NumberFormat;
import java.util.*;

public class Application {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();
    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {

        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();
        // print each project name and the total number of employees on the project
        printProjectsReport();
    }
    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department names : departments) {
            System.out.println(names.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Department engineering = departments.get(2);
        Department marketing = departments.get(0);

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setFirstName("Dean");
        employee1.setLastName("Johnson");
        employee1.setEmail("djohnson@teams.com");
        employee1.setSalary(60000.0);
        employee1.setDepartment(engineering);
        employee1.setHireDate("08/21/2020");
        employees.add(employee1);

        Employee employee2 = new Employee(2, "Smith", "Angie", "asmith@teams.com", engineering, "08/21/2020");
        employee2.setSalary(60000.0);
        employees.add(employee2);
        Employee employee3 = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", marketing, "08/21/2020");
        employee3.setSalary(60000.0);
        employees.add(employee3);
        employee2.raiseSalary(0.10);

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        for (Employee empNames : employees) {
            System.out.println(empNames.getFullName() + " (" + currency.format(empNames.getSalary()) + ") " + empNames.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        List<Employee> engineeringTeam = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getDepartment().getName().equals("Engineering")) {
                engineeringTeam.add(employee);
            }
        }
        teams.setTeamMembers(engineeringTeam);
        projects.put(teams.getName(), teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");

        List<Employee> marketingTeam = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getDepartment().getName().equals("Marketing")) {
                marketingTeam.add(employee);
            }
        }

        landingPage.setTeamMembers(marketingTeam);
        projects.put(landingPage.getName(), landingPage);

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getValue().getName() + ": " + project.getValue().getTeamMembers().size());
        }
    }

}
