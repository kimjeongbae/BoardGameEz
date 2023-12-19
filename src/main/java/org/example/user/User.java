package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class User {
    int id;
    String user_Id;
    String password;
    String nickname;
    String created_date;

}
