import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL_LINK = "https://lenta.ru";
    private static final String FILE_PATH = "C:\\Skillbox\\java_basics\\FilesAndNetwork\\homework_4\\images";

    public static void main(String[] args) {

        System.out.println("Ссылки на изображения:");
        for (String str : parseHtml(URL_LINK)){
            System.out.println(str);
            download(str, FILE_PATH);
        }

        }

    public static List<String> parseHtml(String path) {

        List<String> listLinks = new ArrayList<>();

        try {
            Document document = Jsoup.connect(path).get();
            Elements listElements = document.select("a");
            for (Element element : listElements) {
                String link = element.select("img").attr("src");
                if (link.equals("")) {
                    continue;
                }
                listLinks.add(link);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listLinks;
    }

    public static void download(String urlString, String savePath) {

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int length;
            File file = new File(savePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream outputStream = new FileOutputStream(file + "/" +
                    urlString.substring(urlString.lastIndexOf("/") + 1));
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}