package miu.edu.labs.model;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;

    private PensionPlan pensionPlan;

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

    public String toJSONString() {
        return String.format("\t{\"employeeId\":\"%d\", \"firstName\":\"%s\", \"lastName\":\"%s\", " +
                        "\"employmentDate\":\"%s\", \"yearlySalary\":%.2f, \"pensionPlan\":%s}",
                employeeId, firstName, lastName, employmentDate, yearlySalary, pensionPlan);
    }

    // Business Logic
    public boolean isQualifiedForEnrollment(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = employee.getEmploymentDate();

        // more than 5 years
        return startDate.plusYears(5).isBefore(today);
    }

    public boolean isQualifiedNextMonth(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);;
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        LocalDate startDate = employee.getEmploymentDate();

        // Will be qualified next month : on or between 1st & last day of next month
        // Needs to be at least 4 years 11 months
        LocalDate nextFiveYears = startDate.plusYears(5);
        return employee.getEmploymentDate().plusYears(4).isBefore(today) &&
                nextFiveYears.isEqual(firstDayOfNextMonth) || nextFiveYears.isEqual(lastDayOfNextMonth) ||
                nextFiveYears.isAfter(firstDayOfNextMonth) && nextFiveYears.isBefore(lastDayOfNextMonth);
    }
}
