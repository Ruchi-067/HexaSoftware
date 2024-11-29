package Leave;

import java.util.ArrayList;

public class LeaveManager {
    private ArrayList<Employee> employees;
    private ArrayList<Leave> leaveRequests;

    public LeaveManager() {
        employees = new ArrayList<>();
        leaveRequests = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void requestLeave(int employeeId, String leaveType, int leaveDays) {
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        if (employee.getLeaveBalance() < leaveDays) {
            System.out.println("Insufficient leave balance.");
            return;
        }

        leaveRequests.add(new Leave(employeeId, leaveType, leaveDays));
        System.out.println("Leave request submitted.");
    }

    public void viewLeaveRequests() {
        for (Leave leave : leaveRequests) {
            System.out.println(leave);
        }
    }

    public void processLeave(int requestIndex, boolean approve) {
        if (requestIndex < 0 || requestIndex >= leaveRequests.size()) {
            System.out.println("Invalid request index.");
            return;
        }

        Leave leave = leaveRequests.get(requestIndex);
        Employee employee = findEmployeeById(leave.getEmployeeId());

        if (approve) {
            leave.approve();
            employee.setLeaveBalance(employee.getLeaveBalance() - leave.getLeaveDays());
        } else {
            leave.reject();
        }

        System.out.println("Leave request processed.");
    }

    public void viewEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

