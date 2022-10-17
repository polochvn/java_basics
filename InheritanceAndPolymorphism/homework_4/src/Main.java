import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company comp = new Company(20000000);

        comp.hire(new Manager("Manager", 140000));
        comp.hire(new Operator("Operator", 80000));
        comp.hire(new TopManager("TopManager", 180000, comp));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Manager2", 140000));
        employees.add(new Manager("Manager3", 140000));
        employees.add(new Manager("Manager4", 140000));

        comp.hireAll(employees);
        comp.getTopSalaryStaff(3).forEach((s -> System.out.println(s.getMonthSalary())));
    }
}
