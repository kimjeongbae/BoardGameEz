package org.example.review;

import org.example.board.Board;

import java.time.LocalDate;

public class ReviewController {
    public void create () {

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

    }

    public void delete () {
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
    }

    public void update () {
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

    }

    public void list () {

        System.out.println("번호 /보드게임 이름 / 리뷰 점수 /    리뷰 내용    /  작성자 / 등록일");
        System.out.println("=======================================================================================");

        for (Review review : reviewList) {
            System.out.printf("%d  /   %s   /   %s   /  %s  /   %s  /   %s    \n", review.getId(), review.getBoardTitle(), review.getScore(), review.getContent(), review.getAuthor(), review.getCreated_date());
        }
    }
}
