package user_management;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserCollectionInitializer {

    public static UserCollection generate() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("/Users/madelinebowe/Dev/JavaAssessment3/src/main/resources/users.json"));
        UserCollection users = new Gson().fromJson(reader, UserCollection.class);
        return users;
    }
}
