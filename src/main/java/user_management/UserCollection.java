package user_management;

import user_management.security.Authenticator;
import user_management.security.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserCollection extends ArrayList<User> {
    private List<User> userList;

    public User findById(int id) {
//        try {
//            userList = UserCollectionInitializer.generate();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            this.addAll(UserCollectionInitializer.generate());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User result = null;
        for(User user: this) {
            if (user.getId() == id) {
                result = user;
            }
        }
        return result;
    }

    public User findByEmail(String email) {
//        try {
//            userList = UserCollectionInitializer.generate();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            this.addAll(UserCollectionInitializer.generate());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        User result = null;
        for(User user: this) {
            if(user.getEmail().equals(email)) {
                result = user;
            }
        }
        return result;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
//        try {
//            userList = UserCollectionInitializer.generate();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        for(User user: userList) {
            User userToCheck = this.findByEmail(email);
            if(userToCheck != null) {
                if (Authenticator.authenticate(userToCheck, password)) {
                    return userToCheck;
                }
            }
        throw new UserAuthenticationFailedException("Unable to Authenticate");
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {


        if(this.findByEmail(email) != null) {
            throw new EmailNotAvailableException();
        }

        if(!email.matches("[a-zA-Z0-9-\\\\+_]+?@[a-zA-Z0-9-\\\\+]+?\\.[A-Za-z.]{2,5}")) {
            throw new InvalidEmailException();
        }

        if(password.length() < 8 || !password.matches("(.*[A-Z].*)") || !password.matches("(.*[a-z].*)") || !password.matches("(.*\\d.*)") || !password.matches("(.*[!@#$%^&*()<>?].*)")) {
            throw new PasswordTooSimpleException();
        }

        User newUser = new User(getNewID(), name, email, password);

//        if (this.userList.contains(this.findById(newUser.getId()))) {
//            int nextId = newUser.getId();
//            nextId++;
//            newUser.setId(nextId);
//        }

        this.add(newUser);
        return newUser.getId();
    }

    public int getNewID() {
        int nextId = 1;

//        try {
//            userList = UserCollectionInitializer.generate();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        List<Integer> userIds = new ArrayList<>();
        for(User user: this) {
            userIds.add(user.getId());
        }


        ListIterator litr = userIds.listIterator();

        while(litr.hasNext()) {
            int nextIdInList = (int) litr.next();
            if(nextIdInList == nextId) {
                nextId++;
            }
        }
        return nextId;
    }
}
