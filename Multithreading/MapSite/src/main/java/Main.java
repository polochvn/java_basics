import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String url = "https://skillbox.ru/";
    private static final String path = "files\\sitemap.txt";

    public static void main(String[] args) throws IOException {

        NodeLink node = new NodeLink(url);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SearchingLinks searchingLinks = new SearchingLinks(node);
        forkJoinPool.invoke(searchingLinks);
        String result = createSiteMap(node, 0);

        FileOutputStream stream = new FileOutputStream(path);
        stream.write(result.getBytes());
        stream.flush();
        stream.close();

     }
    public static String createSiteMap(NodeLink node, int tab) {

        String tabs = String.join("", Collections.nCopies(tab, "\t"));
        StringBuilder builder = new StringBuilder(tabs + node.getLink());
        node.getNodeLinkSet().forEach(nodeLink -> builder.append("\n")
                .append(createSiteMap(nodeLink, tab + 1)));

        return builder.toString();
    }
}
