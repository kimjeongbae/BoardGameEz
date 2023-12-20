package org.example.user;

import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {

    public int create(String user_id,String password, String nickname) {

        String sql = String.format("INSERT INTO `user` SET user_id='%s', password='%s', nickname='%s', created_date=now(); ",user_id,password,nickname );

        int id =Global.getDBConnection().insert(sql);

        return id;
    }

    public User userFindByUserId(String userId) {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM `user`;";

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            User user = new User(row);
            userList.add(user);
        }

        for(User user :userList) {
            if (userId.equals(user.user_Id)) {
                return user;
            }
        }
        return null;
    }




 }
