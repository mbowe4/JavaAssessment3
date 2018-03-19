package parsing_json;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ElementCollectionInitializer {
    public static ElementCollection generate() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("/Users/madelinebowe/Dev/JavaAssessment3/src/main/resources/periodic_table.json"));
        ElementCollection elements = new Gson().fromJson(reader, ElementCollection.class);
        return elements;
    }
}
