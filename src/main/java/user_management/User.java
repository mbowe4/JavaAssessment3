package user_management;

import user_management.security.Password;

import java.util.Objects;

public class User {
    private String email;
    private int id;
    private String name;
    private Password password;

    public User(int id, String name, String email, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String email, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = new Password(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getPassword(), user.getPassword());
    }


//    @Override
//    public boolean equals(Object obj) {
//        return false;
//    }


}
