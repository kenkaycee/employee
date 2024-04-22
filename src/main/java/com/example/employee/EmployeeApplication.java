package com.example.employee;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAOIn){
		return runner ->{
			createSingleEmployee(employeeDAOIn);
			createMultipleEmployees(employeeDAOIn);
			//queryEmployeeById(employeeDAOIn);
			queryAllEmployees(employeeDAOIn);
			// queryEmployeeByLastName(employeeDAOIn);
			//updateEmployee(employeeDAOIn);
			//deleteEmployee(employeeDAOIn);
			//deleteAllEmployees(employeeDAOIn);

		};
	}

	private void deleteAllEmployees(EmployeeDAO employeeDAOIn) {
		int rowsDeleted = employeeDAOIn.deleteAll();
		System.out.println("Number of rows deleted: " + rowsDeleted);
	}

	private void deleteEmployee(EmployeeDAO employeeDAOIn) {
		// retrieve id of the employee you want to delete
		int id = 4;
		// delete the employee
		employeeDAOIn.delete(id);
	}

	private void updateEmployee(EmployeeDAO employeeDAOIn) {
		// retrieve employee you want to update
		int id = 3;
		Employee employee = employeeDAOIn.findById(id);
		// display the original surname
		System.out.println("The original surname of employee id of " + id + " is: " + employee.getLastName());
		// update the last name
		employee.setLastName("Obama");
		employeeDAOIn.update(employee);
		// display the original surname
		System.out.println("The updated surname of employee id of " + id + " is: " + employee.getLastName());
	}

	private void queryEmployeeByLastName(EmployeeDAO employeeDAOIn) {
		List<Employee> employeeList = employeeDAOIn.findByLastName("Okeke");
		employeeList.forEach(System.out::println);
	}

	private void queryAllEmployees(EmployeeDAO employeeDAOIn) {
		List<Employee> employees = employeeDAOIn.findAll();
		employees.forEach(System.out::println);
	}

	private void queryEmployeeById(EmployeeDAO employeeDAOIn) {
		// get the id of the employee you want to retrieve
		int id = 3;
		// retrieve the employee with the specified id
		Employee employee = employeeDAOIn.findById(id);
		// display the employee
		System.out.println("The employee with id of " + id + ": " + employee);
	}

	private void createMultipleEmployees(EmployeeDAO employeeDAOIn) {
		List<Employee> employeeList = new ArrayList<>();

		// create five new employees
		Employee employee1 = new Employee("Kenneth", "Clarke", "k.clarke@hotmail.com", "Doctor");
		Employee employee2 = new Employee("Emy", "Okeke", "e.okeke@hotmail.com", "Cybersecurity");
		Employee employee3 = new Employee("Sam", "Owen", "s.owen@hotmail.com", "Manager");
		Employee employee4 = new Employee("Esther", "Nerd", "e.nerd@hotmail.com", "Admin");
		Employee employee5 = new Employee("Nkechi", "Okeke", "n.okeke@hotmail.com", "Social Worker");


		// save the employees
		employeeDAOIn.save(employee1);
		employeeDAOIn.save(employee2);
		employeeDAOIn.save(employee3);
		employeeDAOIn.save(employee4);
		employeeDAOIn.save(employee5);
	}

	private void createSingleEmployee(EmployeeDAO employeeDAOIn) {
		// create new employee object
		Employee employee = new Employee("Kaycee", "Ezenta", "k.ezenta@hotmail.com", "Nurse");

		// save the employee
		employeeDAOIn.save(employee);

		// retrieve the id of the employee
		int id = employee.getId();
		System.out.println("The id of the employee is: " + id);
	}


}















