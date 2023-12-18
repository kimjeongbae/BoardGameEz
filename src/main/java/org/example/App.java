package org.example;

import org.example.board.Board;
import org.example.board.BoardController;
import org.example.like.Like;
import org.example.like.LikeController;
import org.example.review.Review;
import org.example.review.ReviewController;
import org.example.user.UserController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    BoardController boardController;
    LikeController likeController;
    ReviewController reviewController;
    UserController userController;

    App () {

         boardController = new BoardController();
         likeController = new LikeController();
         reviewController = new ReviewController();
         userController = new UserController();

    }
    void run () {


        System.out.println("==================== 보드게임 추천 게시판 ====================");
        System.out.println(" 로그인 / 회원가입 / 메뉴 / 게시판 / 리뷰 / 좋아요 메뉴 / 검색 ");
        System.out.println("==============================================================");


        User user1 = new User(1,"user1","1234","둘리", LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user1);
        User user2 = new User(2,"user2","1234","짱구",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user2);
        User user3 = new User(3,"user3","1234","코난",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user3);


        while (true) {

            System.out.print("명령어 :  ");
            String command = sc.nextLine().trim();
            System.out.println("======================================================");

            if (command.equals("종료")) {
                break;
            }else if (command.equals("메뉴")){
                System.out.println("========================= 전체 메뉴 =========================");
                System.out.println("  로그인  /  회원가입  /  게시판  /  리뷰  / 좋아요 메뉴 / 검색");
                System.out.println("==============================================================");
            } else if (command.equals("게시판")) {
                System.out.println("게시글 작성 / 게시글 목록 / 게시글 삭제 / 게시글 수정");
                System.out.println("======================================================");
            } else if (command.equals("게시글 작성")) {

            } else if (command.equals("게시글 목록")) {



            } else if (command.equals("게시글 삭제")) {

            } else if (command.equals("게시글 수정")) {


            } else if (command.equals("리뷰")){
                System.out.println(" 리뷰 작성  /  리뷰 목록  /  리뷰 삭제  /  리뷰 수정");
                System.out.println("======================================================");

            } else if (command.equals("리뷰 작성")) {

            } else if (command.equals("리뷰 목록")) {


            } else if (command.equals("리뷰 삭제")) {


            } else if (command.equals("리뷰 수정")) {

            } else if (command.equals("좋아요 메뉴")){
                System.out.println("======================");
                System.out.println(" 좋아요 / 좋아요 취소");
                System.out.println("======================");

            } else if (command.equals("좋아요")) {

            } else if (command.equals("좋아요 취소")) {

            } else if (command.equals("회원가입")) {

            }else if (command.equals("로그인")) {

            }
            else if (command.equals("로그아웃")) {

            }
            else if (command.equals("검색")) {
                System.out.println("키워드를 입력하세요. | 게시판 검색 / 리뷰 검색 |");
                System.out.println("======================================================");
            }
            else if (command.equals("게시판 검색")){
                System.out.println("게시판 검색 입니다.");
                System.out.println("보드게임 이름 또는 작성자를 입력하세요.");
                System.out.println("======================================================");
            }
            else if (command.equals("리뷰 검색")){
                System.out.println("리뷰 검색 입니다.");
                System.out.println("보드게임 이름 또는 작성자를 입력하세요.");
                System.out.println("======================================================");
            }


        }


        sc.close();
    }
}
