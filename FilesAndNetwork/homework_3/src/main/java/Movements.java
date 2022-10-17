import au.com.bytecode.opencsv.CSVReader;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movements {

    private final String pathFile;

    public Movements(String pathMovementsCsv) throws IOException {
        this.pathFile = pathMovementsCsv;
        parseOperationCSV(pathMovementsCsv);
    }

    public static List<Operation> parseOperationCSV(String pathMovements) {

        String regex = "[0-9>/]";
        List<Operation> operationList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(pathMovements), ',', '"', 1);
            List<String[]> fileLines = reader.readAll();
            for (String[] fileLine : fileLines) {
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < fileLine.length; i++) {
                    if (i == 5) {
                        columnList.add(fileLine[5].substring(17, 64).
                                replaceAll(regex, " ").trim());
                    } else {
                        columnList.add(fileLine[i]);
                    }
                }
                Operation operation = new Operation();
                operationList.add(operationParameters(operation, columnList));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return operationList;
    }

    private static Operation operationParameters(Operation operation, List list) {

        operation.setOperationDescription((String) list.get(5));
        String income = (String) list.get(6);
        operation.setIncome(Double.valueOf(income.replaceAll(",", ".")));
        String expense = (String) list.get(7);
        operation.setExpense(Double.valueOf(expense.replaceAll(",", ".")));

        return operation;
    }

    public double getExpenseSum() {

        double sum = 0.0;

        try {
            for (Operation line : parseOperationCSV(pathFile)) {
                sum += line.getExpense();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sum;
    }

    public double getIncomeSum(){

        double sum = 0.0;

        try {
            for (Operation line : parseOperationCSV(pathFile)) {
                sum += line.getIncome();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sum;
    }

    public void expenses() {

        try {
            List<Operation> list = parseOperationCSV(pathFile);
            Stream<Operation> operationStream = list.stream();
            Map<String, List<Operation>> map = operationStream.collect(
                    Collectors.groupingBy(Operation::getOperationDescription));
            for (Map.Entry<String, List<Operation>> item : map.entrySet()) {
                System.out.print(item.getKey() + "\t");
                double expenses = 0.0;
                for (Operation operation : item.getValue()) {
                    expenses += operation.getExpense();
                }
                System.out.println(expenses + " руб.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}