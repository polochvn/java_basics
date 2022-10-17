public class Operation {

    private String operationDescription;
    private double income;
    public double expense;

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}