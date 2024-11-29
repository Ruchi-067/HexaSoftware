package Leave;

public class Leave {
    private int employeeId;
    private String leaveType;
    private int leaveDays;
    private String status;

    public Leave(int employeeId, String leaveType, int leaveDays) {
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.leaveDays = leaveDays;
        this.status = "Pending";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Leave Type: " + leaveType +
               ", Leave Days: " + leaveDays + ", Status: " + status;
    }
}

