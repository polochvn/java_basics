public class Manager implements Employee {

    private int fixedSalary;
    private int monthSalary;
    private String name;
    Company company;

    public Manager(String name, int fixedSalary) {
        this.name = name;
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {

        double shareBonus = 0.05;
        int minIncomeCompany = 115_000;
        int maxIncomeCompany = 140_000;
        int incomeCompany = (int) (Math.random() *
                (maxIncomeCompany - minIncomeCompany) + minIncomeCompany);

        return monthSalary = fixedSalary + (int) (shareBonus * incomeCompany);
    }
}
