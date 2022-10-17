import net.sf.saxon.resource.CollectionURIResolverWrapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
        System.out.println("Отсортированный список");
        staff.forEach(s -> System.out.println(s.toString()));
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> {
            if (o1.getSalary().equals(o2.getSalary())){
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getSalary().compareTo(o2.getSalary());
        });
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
    }
}