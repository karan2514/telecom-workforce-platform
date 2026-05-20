package com.telecom.platform.attendance;

import com.telecom.platform.attendance.model.Employee;
import com.telecom.platform.attendance.repo.EmployeeRepo;
import com.telecom.platform.attendance.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@MockitoBean
	private EmployeeRepo repository;

	@Autowired
	private EmployeeService service;

	@Test
	void testSaveEmployee() {

		Employee employee = Employee.builder()
				.name("Karan")
				.build();

		Mockito.when(repository.save(any()))
				.thenReturn(employee);

		Employee saved = service.addEmployee(employee);

		Assertions.assertEquals("Karan", saved.getName());
	}

}
