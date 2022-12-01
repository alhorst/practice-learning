package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, " +
				"birth_date, hire_date FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List <Employee> employees = new ArrayList<>();
		SqlRowSet employeeResults;

		if (lastNameSearch.equals("")) {
			String searchByNameSql = "SELECT employee.employee_id, employee.department_id, first_name, last_name, " +
									 "birth_date, hire_date FROM employee WHERE first_name ILIKE ?;";
			firstNameSearch = "%" + firstNameSearch + "%";
			employeeResults = jdbcTemplate.queryForRowSet(searchByNameSql, firstNameSearch);

			while (employeeResults.next()) {
				employees.add(mapRowToEmployee(employeeResults));
			}
		} else if (firstNameSearch.equals("")) {
			String searchByNameSql = "SELECT employee.employee_id, employee.department_id, first_name, last_name, " +
									 "birth_date, hire_date FROM employee WHERE last_name ILIKE ?;";
			lastNameSearch = "%" + lastNameSearch + "%";
			employeeResults = jdbcTemplate.queryForRowSet(searchByNameSql, lastNameSearch);

			while (employeeResults.next()) {
				employees.add(mapRowToEmployee(employeeResults));
			}
		} else {
			String searchByNameSql = "SELECT employee.employee_id, employee.department_id, first_name, last_name, " +
									 "birth_date, hire_date FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?;";
			firstNameSearch = "%" + firstNameSearch + "%";
			lastNameSearch = "%" + lastNameSearch + "%";
			employeeResults = jdbcTemplate.queryForRowSet(searchByNameSql, firstNameSearch, lastNameSearch);

			while (employeeResults.next()) {
				employees.add(mapRowToEmployee(employeeResults));
			}
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String employeeByProjectIdSql =
				"SELECT employee.employee_id, employee.department_id, first_name, last_name, birth_date, hire_date FROM employee " +
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_id = ?;";
		SqlRowSet employeeByProjectIdResults = jdbcTemplate.queryForRowSet(employeeByProjectIdSql, projectId);
		while (employeeByProjectIdResults.next()) {
			employees.add(mapRowToEmployee(employeeByProjectIdResults));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
					 "VALUES (?, ?) RETURNING project_id;";
		jdbcTemplate.queryForObject(sql, Integer.class, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String removeEmployeeProjectSql = "DELETE FROM project_employee WHERE project_id = ? " +
										  "AND employee_id = ?;";
		jdbcTemplate.update(removeEmployeeProjectSql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String employeeNoProjectIdSql =
				"SELECT employee.employee_id, employee.department_id, first_name, last_name, birth_date, hire_date FROM employee " +
				"LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_employee.project_id IS NULL;";
		SqlRowSet employeeNoProjectIdResults = jdbcTemplate.queryForRowSet(employeeNoProjectIdSql);
		while (employeeNoProjectIdResults.next()) {
			employees.add(mapRowToEmployee(employeeNoProjectIdResults));
		}
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getInt("employee_id"));
		employee.setDepartmentId(results.getInt("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		return employee;
	}

}

