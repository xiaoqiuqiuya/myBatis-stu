package pojo;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
