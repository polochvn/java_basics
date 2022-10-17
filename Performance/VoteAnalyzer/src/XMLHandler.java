import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    int number = 0;
    int count = 1;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

            if (qName.equals("voter")) {
                String name = attributes.getValue("name");
                String birthDay = attributes.getValue("birthDay");
                try {
                DBConnection.countVoter(name, birthDay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            number++;
        }
        if (number == 100000) {
            number = 0;
            try {
                long start = System.currentTimeMillis();
                DBConnection.executeMultiInsert();
                System.out.println("Parsing duration: " + (System.currentTimeMillis() - start) + " ms.");
                System.out.println("Part " + count);
                count++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endDocument() {
        try {
            DBConnection.executeMultiInsert();
            System.out.println("Part " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
