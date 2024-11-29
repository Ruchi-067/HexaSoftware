package Leave;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeaveManager manager = new LeaveManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Leave Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Request Leave");
            System.out.println("4. View Leave Requests");
            System.out.println("5. Process Leave");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Leave Balance: ");
                    int balance = scanner.nextInt();
                    manager.addEmployee(new Employee(id, name, balance));
                    break;

                case 2:
                    manager.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Leave Type: ");
                    String leaveType = scanner.nextLine();
                    System.out.print("Enter Number of Leave Days: ");
                    int leaveDays = scanner.nextInt();
                    manager.requestLeave(empId, leaveType, leaveDays);
                    break;

                case 4:
                    manager.viewLeaveRequests();
                    break;

                case 5:
                    manager.viewLeaveRequests();
                    System.out.print("Enter Request Index to Process: ");
                    int requestIndex = scanner.nextInt();
                    System.out.print("Approve? (true/false): ");
                    boolean approve = scanner.nextBoolean();
                    manager.processLeave(requestIndex, approve);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }}
