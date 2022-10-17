import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    private final int income;

    private final ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public Company(int income) {
        new ArrayList<Employee>();
        this.income = income;
    }

    public int getIncome() {
        return income;
    }

    public void hireAll(List<Employee> employees) {
        employeeArrayList.addAll(employees);
    }

    public void hire(Employee employee) {
        employeeArrayList.add(employee);
    }

    public void fire(int count) {
        if (count <= employeeArrayList.size()){
            for (int i = 0; i < count; i++) {
                employeeArrayList.remove((int) Math.random() * employeeArrayList.size());
            }
        }
    }

    static class SortBySalary implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getMonthSalary() - o2.getMonthSalary();
        }
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {

        Collections.sort(employeeArrayList, new SortBySalary());
        Collections.reverse(employeeArrayList);
        ArrayList<Employee> topSalaryStaff = new ArrayList<>();

        if (count >= employeeArrayList.size()) {
            topSalaryStaff.addAll(employeeArrayList);
            return topSalaryStaff;
        } else if (count < employeeArrayList.size() && count > 0) {
            for (int i = 0; i < count; i++) {
                topSalaryStaff.add(employeeArrayList.get(i));
            }
            return topSalaryStaff;
        }
        return null;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {

        Collections.sort(employeeArrayList, new SortBySalary());
        ArrayList<Employee> lowestSalaryStaff = new ArrayList<>();

        if (count >= employeeArrayList.size()) {
            lowestSalaryStaff.addAll(employeeArrayList);
            return lowestSalaryStaff;
        } else if (count < employeeArrayList.size() && count > 0) {
            for (int i = 0; i < count; i++) {
                lowestSalaryStaff.add(employeeArrayList.get(i));
            }
            return lowestSalaryStaff;
        }
            return null;
    }
}
