package com.dbs.emp_mgmt.client;

import com.dbs.emp_mgmt.controller.EmployeeController;
import com.dbs.emp_mgmt.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDate;

public class EmpManangementClient {

    private static  EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        employeeController = applicationContext.getBean(EmployeeController.class);
        saveEmployees();
        listAllEmployees();
        fetchEmployeeDetailsById(12);
    }

    private static void fetchEmployeeDetailsById(int i) {
        System.out.println("Employee with id "+i +" is " +employeeController.findById(i));
    }

    private static void listAllEmployees() {
        employeeController.listAll().forEach(System.out::println);
    }



    private static void saveEmployees(){
        Employee employee = new Employee(12,"Harish", LocalDate.of(1985,5, 25));
        employeeController.saveEmployee(employee);
        employee = new Employee(15,"VInayak", LocalDate.of(1985,6, 18));
        employeeController.saveEmployee(employee);
        employee = new Employee(12,"Harish", LocalDate.of(1981,3, 25));
        employeeController.saveEmployee(employee);
    }
}