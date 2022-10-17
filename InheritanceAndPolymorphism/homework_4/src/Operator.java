public class Operator implements Employee {

    private final int fixedSalary;
    private int monthSalary;
    private String name;
    Company company;

    public Operator(String name, int fixedSalary) {
        this.name = name;
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        monthSalary = fixedSalary;
        return monthSalary;
    }
}
