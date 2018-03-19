package user_management;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserCollection extends ArrayList<User> {
    private List<User> userList;

    public User findById(int id) {
        try {
            userList = UserCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User result = null;
        for(User user: userList) {
            if (user.getId() == id) {
                result = user;
            }
        }
        return result;
    }

    public User findByEmail(String email) {
        try {
            userList = UserCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User result = null;
        for(User user: userList) {
            if(user.getEmail().equals(email)) {
                result = user;
            }
        }
        return result;
    }

    public User attemptLogin(String email, String password) {
        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
