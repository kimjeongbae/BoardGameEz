package org.example.review;

import org.example.board.Board;
import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    List<Review> reviewList = new ArrayList<>();
    int lastReviewId = 1;

    Board


    public int save (String score, String content) {
        Review review = new Review(lastReviewId,board.getTitle(), score, content, Global.getLogineUser().getNickname() , Global.nowDateTime());
        reviewList.add(review);

        lastReviewId++;

        return review.getId();
    }

    public List<Review> findByAll() {
        return reviewList;
    }
    public Review reviewFindById(int id){
        for (int i = 0; i < reviewList.size(); i++) {
            if (id == reviewList.get(i).getId()) {
                return reviewList.get(i);
            }
        }
        return null;
    }

    public int delete(Review review) {
        reviewList.remove(review);

        return review.getId();
    }

    public int update(Review review, String score, String content) {
        review.setScore(score);
        review.setContent(content);

        return review.getId();
    }
}
