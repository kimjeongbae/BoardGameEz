package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    void run () {
        Scanner sc = new Scanner(System.in);

        System.out.println("================ 보드게임 추천 게시판 ================");
        System.out.println("  로그인  /  회원가입  /  게시판  /  리뷰  /  좋아요 ");
        System.out.println("======================================================");

        List<Like> likeList = new ArrayList<>();
        int likeId = 1;

        List<Review> reviewList = new ArrayList<>();
        int lastReviewId = 1;


        List<User> userList = new ArrayList<>();
        int lastUserId = 1;

        User user1 = new User(1,"user1","1234","둘리", LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user1);
        User user2 = new User(2,"user2","1234","짱구",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user2);
        User user3 = new User(3,"user3","1234","코난",LocalDate.now().toString(),LocalDate.now().toString());
        userList.add(user3);

        List<Board> boardList = new ArrayList<>();
        int lastBoardId = 1;

        User loginedUser = null;

        while (true) {

            System.out.print("명령어 :  ");
            String command = sc.nextLine().trim();
            System.out.println("======================================================");

            if (command.equals("종료")) {
                break;
            } else if (command.equals("게시판")) {
                System.out.println("======================================================");
                System.out.println("게시글 작성 / 게시글 목록 / 게시글 삭제 / 게시글 수정");
                System.out.println("======================================================");
            } else if (command.equals("게시글 작성")) {

                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("보드게임 이름을 입력해주세요.");
                System.out.print("보드게임 이름 : ");
                String title = sc.nextLine();
                System.out.println("======================================================");

                System.out.println("보드게임 난이도를 입력해주세요. ex) 상 중 하");
                System.out.print("보드게임 난이도 : ");
                String level = sc.nextLine();
                System.out.println("======================================================");

                System.out.println("보드게임 플레이어 수 를 입력해주세요.");
                System.out.print("추천 플레이 인원 : ");
                String count = sc.nextLine().trim();
                System.out.println("======================================================");

                System.out.println("보드게임 플레이 타임을 입력해주세요");
                System.out.print("플레이 타임 : ");
                String time = sc.nextLine().trim();
                System.out.println("======================================================");

                LocalDate now = LocalDate.now();

                Board board = new Board(lastBoardId, title, level, count, time , loginedUser.getNickname(),0,now.toString());
                boardList.add(board);

                lastBoardId++;

            } else if (command.equals("게시글 목록")) {
                System.out.println("번호 /보드게임 이름 / 게임 난이도 / 추천 인원수 / 플레이 타임 / 작성자 / 좋아요 /등록일");
                System.out.println("=======================================================================================");
                for (Board board : boardList) {
                    System.out.printf("%d  /    %s  /    %s     /    %s    /     %s   /    %s   /   %s   /  %s \n", board.getId(), board.getTitle(), board.getLevel(), board.getCount() ,board.getTime() , board.getAuthor(), board.getLike_count() ,board.getCreated_date());
                }

            } else if (command.equals("게시글 삭제")) {

                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("삭제할 게시글 번호를 입력하세요.");
                System.out.print("게시글 번호 : ");
                int removeId = Integer.parseInt(sc.nextLine().trim());

                Board board = null;
                for (int i = 0; i < boardList.size(); i++) {
                    if (removeId == boardList.get(i).getId()) {
                        board = boardList.get(i);
                    }
                }

                if (board == null) {
                    System.out.println("해당 게시글은 존재 하지 않습니다." );
                    continue;
                }

                if (board.getAuthor() != loginedUser.getNickname()) {
                    System.out.println("해당 작성자만 삭제가 가능합니다.");
                    continue;
                }

                boardList.remove(board);

                System.out.println(removeId + " 번 게시글이 삭제 되었습니다.");

            } else if (command.equals("게시글 수정")) {

                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("수정할 게시글 번호를 입력하세요.");
                System.out.print("게시글 번호 : ");

                int modifyId = Integer.parseInt(sc.nextLine().trim());

                Board board = null;

                for (int i = 0; i < boardList.size(); i++) {
                    if (modifyId == boardList.get(i).getId()) {
                        board = boardList.get(i);
                    }
                }

                if (board == null) {
                    System.out.println("해당 게시글은 존재 하지 않습니다." );
                    continue;
                }

                if (board.getAuthor() != loginedUser.getNickname()) {
                    System.out.println("해당 작성자만 수정 가능합니다.");
                    continue;
                }

                System.out.printf("보드게임 이름 : %s \n", board.getTitle());
                System.out.print("수정할 이름 : ");
                String title = sc.nextLine();
                System.out.println("======================================================");

                System.out.printf("보드게임 난이도 : %s \n", board.getLevel());
                System.out.print("수정할 난이도 : ");
                String level = sc.nextLine();
                System.out.println("======================================================");

                System.out.printf("추천 플레이 인원 : %s \n", board.getCount());
                System.out.print("수정할 추천 인원수  : ");
                String count = sc.nextLine();
                System.out.println("======================================================");

                System.out.printf("플레이 타임  : %s  \n", board.getTime());
                System.out.print("수정할 플레이 타임 : ");
                String time = sc.nextLine();
                System.out.println("======================================================");


                board.setTitle(title);
                board.setLevel(level);
                board.setCount(count);
                board.setTime(time);

                System.out.println(modifyId + " 번 게시글이 수정 되었습니다.");

            } else if (command.equals("리뷰")){
                System.out.println("======================================================");
                System.out.println(" 리뷰 작성  /  리뷰 목록  /  리뷰 삭제  /  리뷰 수정");
                System.out.println("======================================================");

            } else if (command.equals("리뷰 작성")) {

                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("리뷰할 게시글 번호를 입력하세요.");
                System.out.print("게시글 번호 : ");
                int reviewId = Integer.parseInt(sc.nextLine().trim());
                System.out.println("======================================================");

                Board board = null;
                for (int i = 0; i < boardList.size(); i++) {
                    if (reviewId == boardList.get(i).getId()) {
                        board = boardList.get(i);
                    }
                }

                if (board == null) {
                    System.out.println("해당 게시글은 존재 하지 않습니다." );
                    System.out.println("======================================================");
                    continue;
                }
                System.out.println("리뷰 점수를 입력해 주세요. (0 ~ 10점) ");
                System.out.print("리뷰 점수 : ");
                String score = sc.nextLine();
                System.out.println("======================================================");

                System.out.println("리뷰 내용을 입력해 주세요.");
                System.out.print("리뷰 내용 : ");
                String content = sc.nextLine();
                System.out.println("======================================================");


                LocalDate now = LocalDate.now();

                Review review = new Review(lastReviewId,board.getTitle(), score, content,loginedUser.getNickname() ,now.toString());
                reviewList.add(review);

                lastReviewId++;

            } else if (command.equals("리뷰 목록")) {
                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("번호 /보드게임 이름 / 리뷰 점수 /    리뷰 내용    /  작성자 / 등록일");
                System.out.println("=======================================================================================");

                for (Review review : reviewList) {
                    System.out.printf("%d  /   %s   /   %s   /  %s  /   %s  /   %s    \n", review.getId(), review.getBoardTitle(), review.getScore(), review.getContent(), review.getAuthor(), review.getCreated_date());
                }

            } else if (command.equals("리뷰 삭제")) {
                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("삭제할 리뷰 번호를 입력하세요.");
                System.out.print("리뷰 번호 : ");

                int removeId = Integer.parseInt(sc.nextLine().trim());

                Review review = null;
                for (int i = 0; i < reviewList.size(); i++) {
                    if (removeId == reviewList.get(i).getId()) {
                        review = reviewList.get(i);
                    }
                }

                if (review == null) {
                    System.out.println("해당 리뷰는 존재 하지 않습니다." );
                    continue;
                }

                if (review.getAuthor() != loginedUser.getNickname()) {
                    System.out.println("해당 작성자만 삭제가 가능합니다.");
                    continue;
                }

                reviewList.remove(review);

                System.out.println(removeId + " 번 리뷰가 삭제 되었습니다.");

            } else if (command.equals("리뷰 수정")) {
                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }



                System.out.println("수정할 리뷰 번호를 입력하세요.");
                System.out.print("리뷰 번호 : ");
                int modifyId = Integer.parseInt(sc.nextLine().trim());

                Review review = null;

                for (int i = 0; i < reviewList.size(); i++) {
                    if (modifyId == reviewList.get(i).getId()) {
                        review = reviewList.get(i);
                    }
                }

                if (review == null) {
                    System.out.println("해당 리뷰는 존재 하지 않습니다." );
                    continue;
                }

                if (review.getAuthor() != loginedUser.getNickname()) {
                    System.out.println("해당 작성자만 수정 가능합니다.");
                    continue;
                }

                System.out.printf("해당 리뷰 점수 : %s \n", review.getScore());
                System.out.print("수정할 점수 : ");
                String score = sc.nextLine();
                System.out.println("======================================================");

                System.out.printf("리뷰 내용 : %s \n", review.getContent());
                System.out.print("수정할 내용 : ");
                String content = sc.nextLine();
                System.out.println("======================================================");


                review.setScore(score);
                review.setContent(content);

                System.out.println(modifyId + " 번 리뷰가 수정 되었습니다.");

            } else if (command.equals("좋아요 메뉴")){
                System.out.println("======================");
                System.out.println(" 좋아요 / 좋아요 취소");
                System.out.println("======================");

            } else if (command.equals("좋아요")) {
                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }

                System.out.println("좋아요 누를  게시판 번호를 입력하세요.");
                System.out.print("게시판 번호 : ");
                int boardId = Integer.parseInt(sc.nextLine().trim());
                System.out.println("======================================================");

                Board board = null;
                for (int i = 0; i < boardList.size(); i++) {
                    if (boardId == boardList.get(i).getId()) {
                        board = boardList.get(i);
                    }
                }

                if (board == null) {
                    System.out.println("해당 게시글은 존재 하지 않습니다.");
                    System.out.println("======================================================");
                    continue;
                }

                boolean alreadyLiked = false;
                for (Like like : likeList) {
                    if (like.getBoardId() == boardId && like.getUserId().equals(loginedUser.getNickname())) {
                        System.out.println("해당 게시글은 이미 [좋아요] 누르셨습니다.");
                        System.out.println("======================================================");
                        alreadyLiked = true;
                    }
                }

                if (!alreadyLiked) {
                    // 좋아요를 누르지 않은 경우에만 추가
                    Like like = new Like(likeId, boardId, loginedUser.getNickname());
                    likeList.add(like);
                    board.setLike_count(board.getLike_count() + 1); // 좋아요 수 증가
                    likeId++;
                    System.out.println(board.getId() + "번 게시글을 [좋아요] 누르셨습니다.");
                    System.out.println("======================================================");
                }
            } else if (command.equals("좋아요 취소")){
                if (loginedUser == null) {
                    System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
                    continue;
                }
                System.out.println("좋아요 취소할 게시판 번호를 입력하세요.");
                System.out.print("게시판 번호 : ");
                int boardId = Integer.parseInt(sc.nextLine().trim());
                System.out.println("======================================================");

                Board board = null;
                for (int i = 0; i < boardList.size(); i++) {
                    if (boardId == boardList.get(i).getId()) {
                        board = boardList.get(i);
                    }
                }

                if (board == null) {
                    System.out.println("해당 게시글은 존재 하지 않습니다.");
                    System.out.println("======================================================");
                    continue;
                }

                boolean alreadyUnliked = false;
                for (Like like : likeList) {
                    if (like.getBoardId() == boardId && like.getUserId().equals(loginedUser.getNickname())) {
                        // 좋아요를 누른 경우에만 제거
                        likeList.remove(like);
                        board.setLike_count(board.getLike_count() - 1);
                        alreadyUnliked = true;
                        System.out.println(board.getId() + "번 게시글에 [좋아요 취소]를 누르셨습니다.");
                        System.out.println("======================================================");
                    }
                    if (!alreadyUnliked) {
                        System.out.println("해당 게시글은 [좋아요] 가 없습니다.");
                        System.out.println("======================================================");
                    }


                }
            }
            else if (command.equals("회원가입")) {
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

                    // 중복 아이디 없느 경우
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

            }else if (command.equals("로그인")) {
                if (loginedUser != null) {
                    System.out.println("현재 로그인 상태입니다.");
                    continue;
                }

                User checkedUser = null;

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
            else if (command.equals("로그아웃")) {
                if (loginedUser == null) {
                    System.out.println("로그인 상태가 아닙니다.");
                    continue;
                }

                loginedUser = null;
                System.out.println("로그아웃 되었습니다.");
                System.out.println("======================================================");
            }
        }


        sc.close();
    }
}
