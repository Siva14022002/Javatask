package org.example;

import java.util.Scanner;

public class EmployeeManagementArray {
    static Scanner scanner = new Scanner(System.in);
    static Employee[] employeeList = new Employee[100]; // Max 100 employees
    static int totalEmployees = 0;

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewAllEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (option != 5);
    }

    static void addEmployee() {
        if (totalEmployees >= employeeList.length) {
            System.out.println("Cannot add more employees. Limit reached.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < totalEmployees; i++) {
            if (employeeList[i] != null && employeeList[i].id == id) {
                System.out.println("Employee with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employeeList[totalEmployees++] = new Employee(id, name, salary);
        System.out.println("Employee added successfully.");
    }

    static void viewAllEmployees() {
        if (totalEmployees == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < totalEmployees; i++) {
            if (employeeList[i] != null) {
                System.out.println(employeeList[i]);
            }
        }
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < totalEmployees; i++) {
            if (employeeList[i] != null && employeeList[i].id == id) {
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Salary: ");
                double salary = scanner.nextDouble();
                employeeList[i].name = name;
                employeeList[i].salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < totalEmployees; i++) {
            if (employeeList[i] != null && employeeList[i].id == id) {
                employeeList[i] = null;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}


