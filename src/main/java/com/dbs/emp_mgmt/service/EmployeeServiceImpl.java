package com.dbs.emp_mgmt.service;

import com.dbs.emp_mgmt.dao.EmployeeDAO;
import com.dbs.emp_mgmt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("h2Dao") EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public List<Employee> listAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(long empId)  {
        return this.employeeDAO.findById(empId);
    }

    @Override
    public void deleteEmployee(long empId) {
        this.employeeDAO.deleteEmployee(empId);
    }
}