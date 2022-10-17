import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        List<Integer> regions = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            regions.add(i);
        }

        int partitionSize = 25;
        List<List<Integer>> partitions = new ArrayList<>();
        for (int i = 0; i < regions.size(); i += partitionSize) {
            partitions.add(regions.subList(i, Math.min(i + partitionSize, regions.size())));
        }

        Loader loader = new Loader(letters, partitions.get(0), "A");
        new Thread(loader).start();

        Loader loader2 = new Loader(letters, partitions.get(1), "B");
        new Thread(loader2).start();

        Loader loader3 = new Loader(letters, partitions.get(2), "C");
        new Thread(loader3).start();

        Loader loader4 = new Loader(letters, partitions.get(3), "D");
        new Thread(loader4).start();
    }
}
