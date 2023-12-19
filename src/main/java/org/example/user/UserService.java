package org.example.user;

import org.example.container.Global;


public class UserService {

    UserRepository userRepository;

    public UserService () {
        this.userRepository = new UserRepository();
    }
    public User userFindByUserId(String userId) {
        return this.userRepository.userFindByUserId(userId);
    }

    public String create(String user_id,String password, String nickname) {
        return this.userRepository.create(user_id,password,nickname);
    }

    public void loing(User checkedUser) {
        Global.setLogineUser(checkedUser);
    }

    public void logout() {
        Global.setLogineUser(null);
    }
}
