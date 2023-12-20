package org.example.user;

import org.example.container.Global;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserController {


    UserService userService;

    public UserController () {
        userService = new UserService();
    }


    public void join() {
        System.out.println("회원 가입 페이지 입니다.");

        String user_id;
        String password;
        String passwordConfirm;
        String nickname;


        while (true) {
            System.out.print("아이디 : ");
            user_id = Global.getScanner().nextLine().trim();
            boolean isDuplcated = false;


            User user = this.userService.userFindByUserId(user_id);
            if (user != null){
                System.out.println("중복 하는 아이디가 존재 합니다.");
                isDuplcated = true;
            }

            // 중복 아이디 없는 경우
            if (!isDuplcated) {
                break;
            }
        }

        while (true) {
            System.out.print("비밀번호 : ");
            password = Global.getScanner().nextLine().trim();

            System.out.print("비밀번호 확인 : ");
            passwordConfirm = Global.getScanner().nextLine().trim();

            if (password.equals(passwordConfirm)) {
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        System.out.print("닉네임 : ");
        nickname = Global.getScanner().nextLine().trim();

        int userId = this.userService.create(user_id,password,nickname);
        if (userId == -1){
            System.out.println("회원 가입에 실패 하였습니다.");
            return;
        }


        System.out.println(nickname + "님 가입을 환영 합니다.");
        System.out.println("======================================================");


    }

    public void login() {

        if (Global.getLogineUser() != null) {
            System.out.println("현재 로그인 상태입니다.");
            return;
        }

        User checkedUser = null;
        System.out.println("로그인 페이지 입니다.");
        System.out.printf("아이디 : ");
        String userId = Global.getScanner().nextLine().trim();

        System.out.printf("비밀번호 : ");
        String password = Global.getScanner().nextLine().trim();

        User user =  this.userService.userFindByUserId(userId);
        checkedUser = user;


        if (checkedUser == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            System.out.println("======================================================");
            return;
        } else if (checkedUser.password.equals(password) == false) {
            System.out.println("비밀번호가 일치 하지 않습니다.");
            System.out.println("======================================================");
            return;
        }

        this.userService.login(checkedUser);

        System.out.println(checkedUser.getNickname() + "님 환영합니다.");
        System.out.println("======================================================");
    }

    public void logout() {
        if (Global.getLogineUser() == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        this.userService.logout();

        System.out.println("로그아웃 되었습니다.");
        System.out.println("======================================================");
    }


}
