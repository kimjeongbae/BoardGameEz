package org.example;


import org.example.board.BoardController;
import org.example.container.Global;
import org.example.like.LikeController;
import org.example.review.ReviewController;
import org.example.user.UserController;



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




        while (true) {

            System.out.print("명령어 :  ");
            String command = Global.getScanner().nextLine().trim();
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
                boardController.creat();
            } else if (command.equals("게시글 목록")) {
                boardController.list();
            } else if (command.equals("게시글 삭제")) {
                boardController.delete();
            } else if (command.equals("게시글 수정")) {
                boardController.update();
            } else if (command.equals("리뷰")){
                System.out.println(" 리뷰 작성  /  리뷰 목록  /  리뷰 삭제  /  리뷰 수정");
                System.out.println("======================================================");
            } else if (command.equals("리뷰 작성")) {
                reviewController.create();
            } else if (command.equals("리뷰 목록")) {
                reviewController.list();
            } else if (command.equals("리뷰 삭제")) {
                reviewController.delete();
            } else if (command.equals("리뷰 수정")) {
                reviewController.update();
            } else if (command.equals("좋아요 메뉴")){
                System.out.println("======================");
                System.out.println(" 좋아요 / 좋아요 취소");
                System.out.println("======================");
            } else if (command.equals("좋아요")) {
                likeController.like_up();
            } else if (command.equals("좋아요 취소")) {
                likeController.like_down();
            } else if (command.equals("회원가입")) {
                userController.join();
            }else if (command.equals("로그인")) {
                userController.login();
            }
            else if (command.equals("로그아웃")) {
                userController.logout();
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
