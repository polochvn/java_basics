public class Main {

    final static String FILE_PATH = "C:/Skillbox/java_basics/FilesAndNetwork/homework_3/src/doc/movementList.csv";

    public static void main(String[] args) {
        try {
            Movements movements = new Movements(FILE_PATH);
            System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
            System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб." + "\n");
            System.out.println("Сумма расходов по орнагизациям:");
            movements.expenses();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
