import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "Employees/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);

        Path path = Paths.get(STAFF_TXT);
        System.out.println(path.toAbsolutePath());
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Optional<Employee> employee = staff.stream()
                .filter(s -> s.getWorkStart().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().getYear() == year)
                .max(Comparator.comparing(Employee::getSalary));

        if (employee.isPresent()){
            return employee.get();
        }
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        return null;
    }
}