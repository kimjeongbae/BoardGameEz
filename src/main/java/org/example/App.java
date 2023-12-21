package org.example;


import org.example.board.BoardController;
import org.example.container.Global;
import org.example.db.DBConnection;
import org.example.like.LikeController;
import org.example.review.ReviewController;
import org.example.user.UserController;

import java.util.List;
import java.util.Map;


public class App {

    BoardController boardController;
    LikeController likeController;
    ReviewController reviewController;
    UserController userController;

    App() {

        DBConnection.DB_NAME = "bproj";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Global.getDBConnection().connect();

        boardController = new BoardController();
        likeController = new LikeController();
        reviewController = new ReviewController();
        userController = new UserController();

    }

    void run() {


        System.out.println("==================== 보드게임 추천 게시판 ====================");
        System.out.println(" 로그인 / 회원가입 / 메뉴 / 게시판 / 리뷰 / 좋아요 메뉴 / 검색 ");
        System.out.println("==============================================================");


        while (true) {

            System.out.print("명령어 :  ");
            String command = Global.getScanner().nextLine().trim();
            System.out.println("======================================================");

            switch (command) {
                case "종료":
                    return;
                case "메뉴":
                    System.out.println("========================= 전체 메뉴 =========================");
                    System.out.println("  로그인  /  회원가입  /  게시판  /  리뷰  / 좋아요 메뉴 / 검색");
                    System.out.println("==============================================================");
                    break;
                case "게시판":
                    System.out.println("게시글 작성 / 게시글 목록 / 게시글 삭제 / 게시글 수정");
                    System.out.println("======================================================");
                    break;
                case "리뷰":
                    System.out.println(" 리뷰 작성  /  리뷰 목록  /  리뷰 삭제  /  리뷰 수정");
                    System.out.println("======================================================");
                    break;
                case "좋아요 메뉴":
                    System.out.println("======================");
                    System.out.println(" 좋아요 / 좋아요 취소");
                    System.out.println("======================");
                    break;
                case "검색":
                    System.out.println("키워드를 입력하세요. | 게시판 검색 / 리뷰 검색 |");
                    System.out.println("======================================================");
                    break;
                case "게시판 검색":
                    System.out.println("게시판 검색 입니다, 키워드를 선택해주세요.");
                    System.out.println("[보드게임] 또는 [게시글 작성자] 입력하세요.");
                    System.out.println("======================================================");
                    break;
                case "리뷰 검색":
                    System.out.println("리뷰 검색 입니다, 키워드를 선택해주세요.");
                    System.out.println("[보드게임 이름] 또는 [리뷰 작성자]를 입력하세요.");
                    System.out.println("======================================================");
                    break;
                case "게시글 작성":
                    boardController.create();
                    break;
                case "게시글 삭제":
                    boardController.delete();
                    break;
                case "게시글 목록":
                    boardController.list();
                    break;
                case "게시글 수정":
                    boardController.update();
                    break;
                case "리뷰 작성":
                    reviewController.create();
                    break;
                case "리뷰 삭제":
                    reviewController.delete();
                    break;
                case "리뷰 수정":
                    reviewController.update();
                    break;
                case "리뷰 목록":
                    reviewController.list();
                    break;
//                case "좋아요":
//                    boardController.likeCountUp();
//                    break;
//                case "좋아요 취소":
//                    boardController.likeCountDown();
//                    break;
                case "회원가입":
                    userController.join();
                    break;
                case "로그인":
                    userController.login();
                    break;
                case "로그아웃":
                    userController.logout();
                    break;
                case "리뷰 작성자":
                    reviewController.searchByNickname();
                    break;
                case "보드게임 이름":
                    reviewController.searchByTitlename();
                    break;
                case "게시글 작성자":
                    boardController.searchByBoardUser();
                    break;
                case "보드게임":
                    boardController.searchByBoardGame();
                    break;
            }
        }
    }
}
