package org.example.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList = new ArrayList<>();
    int lastUserId = 1;
    User loginedUser = null;

    public  UserController () {
        User user1 = new User(1,"user1","1234","둘리", LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user1);
        User user2 = new User(2,"user2","1234","짱구",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user2);
        User user3 = new User(3,"user3","1234","코난",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user3);
    }

    public void join () {
        System.out.println("회원 가입 페이지 입니다.");

        String user_id;
        String password;
        String passwordConfirm;
        String nickname;
        LocalDate now = LocalDate.now();



        while (true) {

            System.out.print("아이디 : ");
            user_id = sc.nextLine().trim();

            boolean isDuplcated = false;

            for (User user : userList) {
                if(user_id.equals(user.getUser_Id())) {
                    System.out.println("중복 하는 아이디가 존재 합니다.");
                    isDuplcated = true;
                }
            }

            // 중복 아이디 없는 경우
            if (!isDuplcated) {
                break;
            }
        }

        while (true) {
            System.out.print("비밀번호 : ");
            password = sc.nextLine().trim();

            System.out.print("비밀번호 확인 : ");
            passwordConfirm = sc.nextLine().trim();

            if (password.equals(passwordConfirm)) {
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        System.out.print("닉네임 : ");
        nickname = sc.nextLine().trim();



        User user = new User(lastUserId,user_id,password,nickname,now.toString(),now.toString());
        userList.add(user);
        System.out.println(nickname+"님 가입을 환영 합니다.");
        System.out.println("======================================================");
        lastUserId++;

    }
    public void login () {
        if (loginedUser != null) {
            System.out.println("현재 로그인 상태입니다.");
            continue;
        }

        User checkedUser = null;
        System.out.println("로그인 페이지 입니다.");
        System.out.printf("아이디 : ");
        String userId = sc.nextLine().trim();

        System.out.printf("비밀번호 : ");
        String password = sc.nextLine().trim();

        for (User user : userList) {
            if (userId.equals(user.user_Id)) {
                checkedUser = user;
                break;
            }
        }

        if (checkedUser == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            System.out.println("======================================================");
            continue;
        } else if (checkedUser.password.equals(password) == false) {
            System.out.println("비밀번호가 일치 하지 않습니다.");
            System.out.println("======================================================");
            continue;
        }

        loginedUser = checkedUser;

        System.out.println(checkedUser.getNickname() + "님 환영합니다.");
        System.out.println("======================================================");
    }
    public void logout () {
        if (loginedUser == null) {
            System.out.println("로그인 상태가 아닙니다.");
            continue;
        }

        loginedUser = null;
        System.out.println("로그아웃 되었습니다.");
        System.out.println("======================================================");
    }
}
