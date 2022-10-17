import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Loader implements Runnable {

    private char[] letters;
    private List<Integer> regionGroup;
    private String groupRegion;

    public Loader(char[] letters, List<Integer> regionGroup, String groupRegion) {
        this.letters = letters;
        this.groupRegion = groupRegion;
        this.regionGroup = regionGroup;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("D:\\Games\\numbers\\numbers" + groupRegion + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Integer integer : regionGroup) {
        for (int number = 1; number < 1000; number++) {
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append(firstLetter);
                        buffer.append(padNumber(number, 3));
                        buffer.append(secondLetter);
                        buffer.append(thirdLetter);
                        buffer.append(padNumber(integer, 2));
                        buffer.append("\n");
                        writer.write(buffer.toString());
                    }
                }
            }
        }
    }
        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {

        StringBuffer buffer = new StringBuffer(Integer.toString(number));
        int padSize = numberLength - buffer.length();
        for (int i = 0; i < padSize; i++) {
            buffer.insert(0, '0');
        }
        return buffer.toString();
    }
}
