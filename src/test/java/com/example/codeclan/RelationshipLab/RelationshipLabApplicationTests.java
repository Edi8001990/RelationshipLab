package com.example.codeclan.RelationshipLab;

import com.example.codeclan.RelationshipLab.models.Department;
import com.example.codeclan.RelationshipLab.models.Employee;
import com.example.codeclan.RelationshipLab.models.Project;
import com.example.codeclan.RelationshipLab.repositories.DepartmentRepository;
import com.example.codeclan.RelationshipLab.repositories.EmployeeRepository;
import com.example.codeclan.RelationshipLab.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("IT Department");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Smith", 1 ,department);
		employeeRepository.save(employee);
	}

	@Test
	public void addEmployeeToAProject(){

		Department department = new Department("IT Department");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Smith", 1 ,department);
		employeeRepository.save(employee);

		Project project = new Project("Ruby Project", 14);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);

	}

}
