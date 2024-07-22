package com.jsp.Hibernate.Employee;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Employee\n2.Find Employee By ID\n3.Update Employee\n4.Delete Employee ");
        System.out.println("Please Enter any option to Perform");
        int choice = sc.nextInt();
        
        EmployeeService service = new EmployeeService();

        switch (choice) {
            case 1: 
                service.addEmployee(); 
                break;
            case 2: 
                service.findEmployeeById(); 
                break;
            case 3: 
                service.updateEmployeeDetails(); 
                break;
            case 4: 
                service.deleteEmployee(); 
                break; 
            default:
                System.out.println("Enter Valid Number!!");
        }
        sc.close();
    }
}
