package miu.edu.labs;

import miu.edu.labs.model.Employee;
import miu.edu.labs.model.PensionPlan;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,01,17), 105945.50);
        Employee e2 = new Employee(2L, "Bernard", "Shaw", LocalDate.of(2019,04,04), 197750.00);
        Employee e3 = new Employee(3L, "Carly", "Agar", LocalDate.of(2014,05,16), 842000.75);
        Employee e4 = new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019,05,02), 74500.00);

        PensionPlan p1 = new PensionPlan("EX1089", null, 100);
        PensionPlan p2 = new PensionPlan("SM2307", null, 1555.50);

        Queue<PensionPlan> pensionPlanQueue = new ArrayDeque<>();
        pensionPlanQueue.add(p1);
        pensionPlanQueue.add(p2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e4);
        employeeList.add(e3);
        employeeList.add(e1);
        employeeList.add(e2);

        employeeList.sort(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));

        // For JSON format
        System.out.println("Printed in JSON format\n[");
        for(Employee employee : employeeList) {
            if(isQualifiedForEnrollment(employee)) {
                if(!pensionPlanQueue.isEmpty()) {
                    employee.setPensionPlan(pensionPlanQueue.poll(),employee);
                }
            }
            System.out.println(employee.toJSONString());
        }

        System.out.println("]");
        System.out.println("------------------------------");

        // Task 2
        System.out.println("Printed in JSON format\n[");
        for(Employee employee : employeeList) {
            if(employee.getPensionPlan() == null && isQualifiedNextMonth(employee)) {
                System.out.println(employee.toJSONString());
            }
        }
        System.out.println("]");
    }



    private static boolean isQualifiedForEnrollment(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = employee.getEmploymentDate();

        // more than 5 years
        return startDate.plusYears(5).isBefore(today);
    }

    private static boolean isQualifiedNextMonth(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);;
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        LocalDate startDate = employee.getEmploymentDate();

        // Will be qualify next month : on or between 1st & last day of next month
        // Needs to be at least 4 years 11 months
        LocalDate nextFiveYears = startDate.plusYears(5);
        return employee.getEmploymentDate().plusYears(4).isBefore(today) &&
                nextFiveYears.isEqual(firstDayOfNextMonth) || nextFiveYears.isEqual(lastDayOfNextMonth) ||
                nextFiveYears.isAfter(firstDayOfNextMonth) && nextFiveYears.isBefore(lastDayOfNextMonth);
    }
}