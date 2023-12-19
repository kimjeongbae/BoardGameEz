package org.example.user;

import org.example.container.Global;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList = new ArrayList<>();
    int lastUserId = 1;




    public UserRepository () {
        User user1 = new User(1, "user1", "1234", "둘리", LocalDate.now().toString());
        userList.add(user1);
        User user2 = new User(2, "user2", "1234", "짱구", LocalDate.now().toString());
        userList.add(user2);
        User user3 = new User(3, "user3", "1234", "코난", LocalDate.now().toString());
        userList.add(user3);
    }
    public User userFindByUserId(String userId) {
        for(User user :userList) {
            if (userId.equals(user.user_Id)) {
                return user;
            }
        }
        return null;
    }

    public String create(String user_id,String password, String nickname) {
        User user = new User(lastUserId, user_id, password, nickname, Global.nowDateTime());
        userList.add(user);
        lastUserId++;

        return user.getNickname();
    }
}
