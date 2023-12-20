package org.example.review;

import org.example.board.BoardDTO;

import java.util.List;

public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService () {
        reviewRepository = new ReviewRepository();
    }

    public int save (String boardTitle, String score, String content) {
        return this.reviewRepository.save(boardTitle, score,content);
    }

    public List<ReviewDTO> joinMemberFindByAll() {
        return this.reviewRepository.joinMemberFindByAll();
    }

    public List<Review> findByAll() {
        return this.reviewRepository.findByAll();
    }
    public Review reviewFindById(int id){
        return reviewRepository.reviewFindById(id);
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    public void update(Review review, String score, String content) {
        reviewRepository.update(review,score,content);
    }
}
