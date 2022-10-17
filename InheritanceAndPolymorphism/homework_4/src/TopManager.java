public class TopManager implements Employee {

    private final int fixedSalary;
    private final int incomeOfInfluence = 10_000_000;
    private final double shareBonus = 1.5;
    private int monthSalary;
    private String name;
    Company company;

    public TopManager(String name, int fixedSalary, Company company) {
        this.name = name;
        this.fixedSalary = fixedSalary;
        this.company = company;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > incomeOfInfluence) {
            monthSalary = fixedSalary + (int) (shareBonus * fixedSalary);
        } else {
            monthSalary = fixedSalary;
        }
        return monthSalary;
    }
}
