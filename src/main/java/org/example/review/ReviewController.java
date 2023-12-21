package org.example.review;

import org.example.board.Board;
import org.example.board.BoardService;
import org.example.container.Global;
import org.example.user.User;
import org.example.user.UserService;

import java.util.List;

public class ReviewController {

    ReviewService reviewService;
    UserService userService;


    public ReviewController() {

        reviewService = new ReviewService();
        userService = new UserService();
    }


    public void create() {

        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("리뷰할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int reviewId = Integer.parseInt(Global.getScanner().nextLine().trim());
        System.out.println("======================================================");


        Board board = new BoardService().boardFindId(reviewId);

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다.");
            System.out.println("======================================================");
            return;
        }
        System.out.println("리뷰 점수를 입력해 주세요. (0 ~ 10점) ");
        System.out.print("리뷰 점수 : ");
        String score = Global.getScanner().nextLine();
        System.out.println("======================================================");

        System.out.println("리뷰 내용을 입력해 주세요.");
        System.out.print("리뷰 내용 : ");
        String content = Global.getScanner().nextLine();
        System.out.println("======================================================");

        int id = this.reviewService.save(board.getTitle(), score, content);

        System.out.println(id+ "번 리뷰글이 등록 되었습니다.");

    }

    public void delete() {
        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("삭제할 리뷰 번호를 입력하세요.");
        System.out.print("리뷰 번호 : ");
        int removeId = Integer.parseInt(Global.getScanner().nextLine().trim());

        Review review = this.reviewService.reviewFindById(removeId);

        if (review == null) {
            System.out.println("해당 리뷰는 존재 하지 않습니다.");
            return;
        }

        if (review.getUserId() != Global.getLogineUser().getId()) {
            System.out.println("해당 작성자만 삭제가 가능합니다.");
            return;
        }

        this.reviewService.delete(review);


        System.out.println(removeId + " 번 리뷰가 삭제 되었습니다.");
    }

    public void update() {
        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("수정할 리뷰 번호를 입력하세요.");
        System.out.print("리뷰 번호 : ");
        int modifyId = Integer.parseInt(Global.getScanner().nextLine().trim());

        Review review = this.reviewService.reviewFindById(modifyId);


        if (review == null) {
            System.out.println("해당 리뷰는 존재 하지 않습니다.");
            return;
        }

        if (review.getUserId() != Global.getLogineUser().getId()) {
            System.out.println("해당 작성자만 수정 가능합니다.");
            return;
        }

        System.out.printf("해당 리뷰 점수 : %s \n", review.getScore());
        System.out.print("수정할 점수 : ");
        String score = Global.getScanner().nextLine();
        System.out.println("======================================================");

        System.out.printf("리뷰 내용 : %s \n", review.getContent());
        System.out.print("수정할 내용 : ");
        String content = Global.getScanner().nextLine();
        System.out.println("======================================================");

        this.reviewService.update(review, score, content);

        System.out.println(modifyId + " 번 리뷰가 수정 되었습니다.");
    }

    public void list() {
        List<ReviewDTO> reviewList = this.reviewService.joinMemberFindByAll();

        System.out.println("번호 /보드게임 이름 / 리뷰 점수 /    리뷰 내용    /  작성자 / 등록일");
        System.out.println("=======================================================================================");
        for (ReviewDTO review : reviewList) {
            System.out.printf("%d  /   %s   /   %s   /  %s  /   %s  /   %s    \n",
                    review.getId(), review.getBoardTitle(), review.getScore(),
                    review.getContent(), review.getNickname(), review.getCreated_date());
        }

    }

    public void searchByNickname() {
        System.out.println("검색 하실 작성자 닉네임을 한글자 이상 입력하세요. ");
        System.out.print("검색 : ");
        String searchKeyword = Global.getScanner().nextLine().trim();
        System.out.println("=======================================================================================");

        List<ReviewDTO> searchResult = this.reviewService.searchByNickname(searchKeyword);

        if (searchResult.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("번호 / 보드게임 이름 / 리뷰 점수 / 리뷰 내용 / 작성자 / 등록일");
            System.out.println("=======================================================================================");

            for (ReviewDTO review : searchResult) {
                System.out.printf("%d  /   %s   /   %s   /  %s  /   %s  /   %s    \n",
                        review.getId(), review.getBoardTitle(), review.getScore(),
                        review.getContent(), review.getNickname(), review.getCreated_date());

            }
            System.out.println("======================= 작성자 검색이 완료 되었습니다. =================================");
        }
    }

    public void searchByTitlename() {
        System.out.println("검색 하실 보드게임 이름을 한글자 이상 입력하세요. ");
        System.out.print("검색 : ");
        String searchKeyword = Global.getScanner().nextLine().trim();
        System.out.println("=======================================================================================");

        List<ReviewDTO> searchResult = this.reviewService.searchByTitlename(searchKeyword);

        if (searchResult.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("번호 / 보드게임 이름 / 리뷰 점수 / 리뷰 내용 / 작성자 / 등록일");
            System.out.println("=======================================================================================");

            for (ReviewDTO review : searchResult) {
                System.out.printf("%d  /   %s   /   %s   /  %s  /   %s  /   %s    \n",
                        review.getId(), review.getBoardTitle(), review.getScore(),
                        review.getContent(), review.getNickname(), review.getCreated_date());

            }
            System.out.println("====================== 보드게임 검색이 완료 되었습니다. ================================");
        }
    }


}
