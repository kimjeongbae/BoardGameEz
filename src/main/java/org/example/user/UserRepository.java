package org.example.user;

import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {

    public int create(String user_id, String password, String nickname) {

        String sql = String.format("INSERT INTO `user` SET user_id='%s', password='%s', nickname='%s', created_date=now(); ", user_id, password, nickname);

        int id = Global.getDBConnection().insert(sql);

        return id;
    }



    public User userFindByUserId(String userId) {
        List<User> userList = this.findByAll();

        for (User user : userList) {
            if (userId.equals(user.getUser_Id())) {
                return user;
            }
        }
        return null;
    }

    public User userFindById(int id) {
        List<User> memberList = this.findByAll();

        for (User user : memberList) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public List<User> findByAll() {
        List<User> memberList = new ArrayList<>();

        String sql = "select * from `user`;";

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            User user = new User(row);
            memberList.add(user);
        }
        return memberList;
    }

}
