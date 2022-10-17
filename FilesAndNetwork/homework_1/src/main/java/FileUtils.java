import java.io.File;

public class FileUtils {

    private static String[] units = {"Б", "Кб", "Мб", "Гб"};

    public static long calculateFolderSize(String path) {

        File file = new File(path);
        if (file.isFile()) {
            return file.length();
        }
        long size = 0;
        File[] files = file.listFiles();
        for (File f : files) {
            size += calculateFolderSize(f.getPath());
        }
        return size;
    }

    public static String getSize(long size) {

        for (int i = 0; i < units.length; i++) {
            double value = (double) Math.round((size / Math.pow(1024, i)) * 10) / 10;
            if (value < 1024) {
                return value + " " + units[i];
            }
        }
        return "Слишком большое число";
    }
}
