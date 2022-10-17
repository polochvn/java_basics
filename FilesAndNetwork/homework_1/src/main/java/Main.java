import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

            while (true) {
                try {
                    System.out.println("Введите путь до папки:");
                    String str = input.next();
                    if (str.equals("Exit")) {
                        break;
                    }
                    long size = FileUtils.calculateFolderSize(str);

                    System.out.println("Размер папки " + str + " составляет" + "\n"
                            + FileUtils.getSize(size));
                }
                catch (NullPointerException nex) {
                    System.out.println(Arrays.toString(nex.getStackTrace()) + "\n"
                            + "Файл не найден!");
                }
            }
        }
}
