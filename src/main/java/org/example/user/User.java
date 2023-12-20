package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class User {
    int id;
    String user_Id;
    String password;
    String nickname;
    String created_date;

    User (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.user_Id = (String)row.get("user_Id");
        this.password = (String)row.get("password");
        this.nickname = (String) row.get("nickname");
        this.created_date = row.get("created_date").toString();
    }
}
