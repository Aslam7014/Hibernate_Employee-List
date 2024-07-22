package com.jsp.Hibernate.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class EmployeeService {
    
    Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
    SessionFactory sf = cfg.buildSessionFactory();
    Scanner sc = new Scanner(System.in);
    
    public void addEmployee() {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        
        Employee employee = new Employee();
        
        System.out.println("Enter Employee Name: ");
        String name = sc.next();
        employee.setEmployeeName(name);
        
        System.out.println("Enter Employee Id: ");
        int id = sc.nextInt();
        employee.setEmployeeId(id);
        
        System.out.println("Enter Employee Email: ");
        String email = sc.next();
        employee.setEmployeeEmail(email);
        
        System.out.println("Enter Employee Address: ");
        String address = sc.next();
        employee.setEmployeeAddress(address);
        
        System.out.println("Enter Employee Salary: ");
        int salary = sc.nextInt();
        employee.setEmployeeSalary(salary);
        
        session.save(employee);
        tr.commit();
        
        session.close();
    }
    
    public void findEmployeeById() {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        
        System.out.println("Enter your Employee Id: ");
        int id = sc.nextInt();
        Employee employee = session.get(Employee.class, id);
        
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found!");
        }
        
        tr.commit();
        session.close();
    }
    
    public void updateEmployeeDetails() {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        
        System.out.println("Enter your Employee Id: ");
        int id = sc.nextInt();
        Employee employee = session.get(Employee.class, id);
        
        if (employee != null) {
            System.out.println("Enter new Employee Name: ");
            String name = sc.next();
            employee.setEmployeeName(name);
            
            System.out.println("Enter new Employee Email: ");
            String email = sc.next();
            employee.setEmployeeEmail(email);
            
            System.out.println("Enter new Employee Address: ");
            String address = sc.next();
            employee.setEmployeeAddress(address);
            
            System.out.println("Enter new Employee Salary: ");
            int salary = sc.nextInt();
            employee.setEmployeeSalary(salary);
            
            session.update(employee);
        } else {
            System.out.println("Employee not found!");
        }
        
        tr.commit();
        session.close();
    }
    
    public void deleteEmployee() {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        
        System.out.println("Enter Id of Employee to Delete: ");
        int id = sc.nextInt();
        Employee employee = session.get(Employee.class, id);
        
        if (employee != null) {
            session.delete(employee);
        } else {
            System.out.println("Employee not found!");
        }
        
        tr.commit();
        session.close();
    }
}
