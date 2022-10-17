import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SearchingLinks extends RecursiveTask<Set<String>> {

    private final NodeLink nodeLink;
    public static final Set<String> allLinks = Collections.synchronizedSet(new TreeSet<>());

    public SearchingLinks(NodeLink nodeLink) {
        this.nodeLink = nodeLink;
    }

    @Override
    protected Set<String> compute() {

            Set<String> set = Collections.synchronizedSet(
                    nodeLink.parseLink(nodeLink.getLink()));
            Set<NodeLink> nodeLinkSet = Collections.synchronizedSet(new HashSet<>());

            for (String str : set) {
                synchronized (allLinks) {
                    if (checkSet(str, allLinks)) {
                        continue;
                    }
                }
                NodeLink nodeLink = new NodeLink(str);
                nodeLinkSet.add(nodeLink);
            }

            nodeLink.setNodeLinkSet(nodeLinkSet);
            allLinks.addAll(set);

            List<SearchingLinks> listTask = new ArrayList<>();

            for (NodeLink node : nodeLink.getNodeLinkSet()) {

                    SearchingLinks task = new SearchingLinks(node);
                    task.fork();
                    listTask.add(task);
            }

            addResultsFromTasks(set, listTask);
            return set;
    }

    private synchronized void addResultsFromTasks(Set<String> set, List<SearchingLinks> tasks) {
        for (SearchingLinks item : tasks) {
            synchronized (set) {
                set.addAll(item.join());
            }
        }
    }

    private synchronized boolean checkSet(String str, Set<String> set) {
        if (!(set == null)) {
            for (String link : set) {
                if (link.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}