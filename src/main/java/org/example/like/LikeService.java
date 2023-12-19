package org.example.like;


import org.example.board.Board;
import java.util.List;

public class LikeService {
    LikeRepository likeRepository;

    LikeService() {
        likeRepository = new LikeRepository();
    }


    public int save(int boardId) {
        return this.likeRepository.save(boardId);
    }

    public List<Like> findByAll(int boardId) {
        this.likeRepository.findByAll();
    }

    public Board findBoardById(int boardId) {
        this.likeRepository.findBoardById(boardId);
    }

    public boolean alreadyLiked(int boardId) {
        return this.alreadyLiked(boardId);

    }

    public void removeLike(int boardId) {
        this.removeLike(boardId);
    }

}
