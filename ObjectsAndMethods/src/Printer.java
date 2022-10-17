public class Printer {

    private String queue = "";
    private String nameDocument;
    private int numberPages = 0;
    private int pendingPages = 0;
    private int totalPrintPages = 0;

    public void append(String textDocument) { append(textDocument, "Документ_1", 135); }

    public void append(String textDocument, String nameDocument) { append(textDocument, nameDocument, 207); }

    public void append(String textDocument, String nameDocument, int numberPages) {
            queue = queue + "\n" + nameDocument + "\n" + textDocument + "\n" + numberPages + " стр.";
            pendingPages = numberPages;
            totalPrintPages = totalPrintPages + numberPages;
    }

    public void clear() {
        queue = "";
        pendingPages = 0;
    }

    public void print(String title) {
        System.out.println(title);
        System.out.println(queue + "\n");
    }

    public int getPendingPages() { return pendingPages; }

    public int getTotalPrintPages() { return totalPrintPages; }
}
