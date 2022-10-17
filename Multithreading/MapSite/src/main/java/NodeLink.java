import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

public class NodeLink {

    private String link;
    private Set<NodeLink> nodeLinkSet;
    public static Set<NodeLink> allNode;

    public NodeLink(String link) {
        this.link = link;
    }

    public Set<String> parseLink (String link) {

        Set<String> set = Collections.synchronizedSet(new TreeSet<>());

        Document document = null;
        try {
            document = Jsoup.connect(link).get();
            Thread.sleep(150);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(document == null)) {

            Elements elements = document.select("a[href]");

            for (Element element : elements) {

                String absLink = element.attr("abs:href");
                if (absLink.contains(link)) {
                    set.add(absLink);
                }
            }
        }
        return set;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<NodeLink> getNodeLinkSet() {
        return nodeLinkSet;
    }

    public void setNodeLinkSet(Set<NodeLink> nodeLinkSet) {
        this.nodeLinkSet = nodeLinkSet;
    }

    public static Set<NodeLink> getAllNode() {
        return allNode;
    }

    public static void setAllNode(Set<NodeLink> allNode) {
        NodeLink.allNode = allNode;
    }
}
