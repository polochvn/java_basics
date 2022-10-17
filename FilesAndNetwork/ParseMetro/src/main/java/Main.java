import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final String PATH_FILE = "data\\metro.json";
    private static final String PATH_HTML = "https://skillbox-java.github.io/";

    public static void main(String[] args) throws Exception {

        writeJSON(PATH_HTML, PATH_FILE);

        JSONObject jsonObject = (JSONObject) readJson(PATH_FILE);
        JSONObject stations = (JSONObject) jsonObject.get("stations");
        Object[] array = stations.keySet().toArray();

        for (Object object : array) {
            JSONArray jsonArray = (JSONArray) stations.get(object);
            int count = jsonArray.size();
            System.out.println("Линия " + object + ": " + count + " ст.");
        }
    }

    public static void writeJSON(String pathHTML, String pathFile) throws IOException {

        JSONObject resultJson = new JSONObject();
        Document document = Jsoup.connect(pathHTML).get();
        Elements lines = document.select("span.js-metro-line");
        JSONArray jsonArrayLines = new JSONArray();
        for (Element element : lines) {
            JSONObject jsonObjectLine = new JSONObject();
            jsonObjectLine.put("number", element.attr("data-line"));
            jsonObjectLine.put("name", element.text());
            jsonArrayLines.add(jsonObjectLine);
        }

        Elements stations = document.select("div.js-metro-stations");
        JSONObject jsonObjectStations = new JSONObject();

        for (Element element : stations) {
            JSONArray jsonArrayStations = new JSONArray();
            for (Element station : element.select("span.name")) {
                jsonArrayStations.add(station.text());
            }
            jsonObjectStations.put(element.attr("data-line"), jsonArrayStations);
        }

        resultJson.put("stations", jsonObjectStations);
        resultJson.put("lines", jsonArrayLines);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Files.write(Paths.get(pathFile), gson.toJson(JsonParser
                .parseString(String.valueOf(resultJson))).getBytes());
    }

    public static Object readJson(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
}