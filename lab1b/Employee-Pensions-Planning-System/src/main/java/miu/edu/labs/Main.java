package miu.edu.labs;

import miu.edu.labs.model.Employee;
import miu.edu.labs.model.PensionPlan;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,01,17), 105945.50);
        Employee e2 = new Employee(2L, "Bernard", "Shaw", LocalDate.of(2019,04,24), 197750.00);
        Employee e3 = new Employee(3L, "Carly", "Agar", LocalDate.of(2014,05,16), 842000.75);
        Employee e4 = new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019,05,02), 74500.00);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e4);
        employeeList.add(e3);
        employeeList.add(e1);
        employeeList.add(e2);

        employeeList.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));

        printEmployeeList(employeeList);
    }

    private static void printEmployeeList(List<Employee> employeeList) {
        // For JSON format
        System.out.println("Printed in JSON format\n[");
        for(Employee employee : employeeList) {
            if(employee.isQualifiedForEnrollment(employee)) {
                PensionPlan pensionPlan = new PensionPlan();
                pensionPlan.setPlanReferenceNumber(isQualifiedNextMonth(employee));
                pensionPlan.setEnrollmentDate(employee.getEmploymentDate().plusYears(5));
                pensionPlan.setMonthlyContribution(employee.getYearlySalary() * 0.15); // set as 0.15% from their salary

                employee.setPensionPlan(pensionPlan);
            } else {
                employee.setPensionPlan(null);
            }
            System.out.println(employee.toJSONString());
        }
        System.out.println("]");
        System.out.println("------------------------------");

        // Task 2
        System.out.println("Printed in JSON format\n[");
        for(Employee employee : employeeList) {
            if(employee.getPensionPlan() == null && employee.isQualifiedNextMonth(employee)) {
                System.out.println(employee.toJSONString());
            }
        }
        System.out.println("]");
    }

    // Dummy method to create reference number - fname(0) + lname(0) + 4 digit numbers
    private static String isQualifiedNextMonth(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getFirstName().charAt(0));
        sb.append(employee.getLastName().charAt(0));
        Random random = new Random();
        sb.append(random.nextInt(9000) + 1000); // generate random 4 digits number

        return sb.toString();
    }
}