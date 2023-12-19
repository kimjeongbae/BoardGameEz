package org.example.like;


import org.example.board.Board;
import java.util.List;

public class LikeService {
    private  LikeRepository likeRepository;

    LikeService () {
        likeRepository = new LikeRepository();
    }


    public int save (String boardId) {
        this.likeRepository.save(boardId);
    }

    public List<Like> findByAll() {
    }
    public Board findBoardById(int boardId) {
    }
    public boolean alreadyLiked(String boardId) {

    }

    public void removeLike(String boardId) {

    }
}

