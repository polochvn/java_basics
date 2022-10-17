import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner inputSourceDirectory = new Scanner(System.in);
        Scanner inputDestinationDirectory = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Введите путь к папке для её копирования:");
                String strSource = inputSourceDirectory.nextLine();
                if (strSource.equals("Exit")) {
                    break;
                }

                System.out.println("Введите путь для создания копии:");
                String strDestination = inputDestinationDirectory.nextLine();

                FileUtils.copyFolder(strSource, strDestination);
                System.out.println("Копирование завершено!");
            }
            catch (IndexOutOfBoundsException | NoSuchFileException exc) {
                exc.printStackTrace();
            }
        }
    }
}