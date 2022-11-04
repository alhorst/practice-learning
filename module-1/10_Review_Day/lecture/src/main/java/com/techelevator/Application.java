package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.*;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();

    private void run() {

        // create some departments
        createDepartments();
            Department department1 = new Department(1, "Marketing");
            departments.add(department1);
            Department department2 = new Department(2, "Sales");
            departments.add(department2);
        Department department3 = new Department(3, "Engineering");
            departments.add(department3);


        // print each department by name
        printDepartments();
            for (Department names : departments) {
                System.out.println(names);
            }

        // create employees
        createEmployees();
            Employee employee1 = new Employee();
            employee1.setEmployeeId(1);
            employee1.setFirstName("Dean");
            employee1.setLastName("Johnson");
            employee1.setEmail("djohnson@teams.com");
            employee1.setSalary(60000.0);
            employee1.setDepartment(department3);
            employee1.setHireDate("08/21/2020");
            employees.add(employee1);

            Employee employee2 = new Employee(2, "Smith", "Angie", "asmith@teams.com", department3, "08/21/2020");
            employee2.setSalary(60000.0);
            employees.add(employee2);
            Employee employee3 = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", department1, "08/21/2020");
            employee3.setSalary(60000.0);
            employees.add(employee3);
        // give Angie a 10% raise, she is doing a great job!
            employee2.raiseSalary(0.10);

        // print all employees
        printEmployees();
        for (Employee empNames : employees) {
            System.out.println(empNames.getFullName() + " " + "("+ empNames.getSalary() + ")" + " "+ empNames.getDepartment());
        }


        // create the TEams project
        createTeamsProject();
            int i = 0;
            Project project1 = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");
            for (Employee p : employees) {
                if(p.getDepartment() == department3) {
                    project1.setTeamMembers(employees);
                    i++;
                }
            }
            projects.put("TEams", project1);
        // create the Marketing Landing Page Project
        createLandingPageProject();
            int j = 0;
            Project project2 = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
            for (Employee p : employees) {
                if(p.getDepartment() == department1) {
                    project2.setTeamMembers(employees);
                    j++;
                }
            }
            projects.put("Marketing Landing Page", project2);
        // print each project name and the total number of employees on the project
        printProjectsReport();
            for (Map.Entry<String, Project> projectType : projects.entrySet()) {
                if (projects.containsValue(project1)) {
                    System.out.println(projectType.getKey() + ": " + i);
                }
                else if (projects.containsValue(project2))
                System.out.println(projectType.getKey() + ": " + j);
            }
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");

    }

}
