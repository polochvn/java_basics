import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:\\Skillbox\\java_basics\\Multithreading\\ImageResizer\\files\\src";
        String dstFolder = "C:\\Skillbox\\java_basics\\Multithreading\\ImageResizer\\files\\dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int middle = files.length / 2;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0 , files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, 300, dstFolder);
        new Thread(resizer1).start();

        File[] files2 = new File[files.length - middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, 300, dstFolder);
        new Thread(resizer2).start();

    }
}
