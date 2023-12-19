package org.example.like;

import org.example.board.Board;
import org.example.container.Global;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LikeRepository {
    List<Like> likeList = new ArrayList<>();
    int likeId = 1;

    Board board;

    LikeService (Board board) {
        this.board = board;
    }


    public int save (String boardId) {
        Like like = new Like(boardId, Global.getLogineUser().getNickname());
        likeList.add(like);
        board.setLike_count(board.getLike_count()+1);
        return like.getId();
    }

    public List<Like> findByAll() {
        return likeList;
    }
    public Board findBoardById(int boardId) {
        return null;
    }
    public boolean alreadyLiked(String boardId) {
        for (Like like : likeList) {
            if (like.getBoardId().equals(boardId) && like.getUserId().equals(Global.getLogineUser().getNickname())) {
                return true;
            }
        }
        return false;
    }

    public void removeLike(String boardId) {
        Iterator<Like> iterator = likeList.iterator();
        while (iterator.hasNext()) {
            Like like = iterator.next();
            if (like.getBoardId().equals(boardId) && like.getUserId().equals(Global.getLogineUser().getNickname())) {
                iterator.remove();
                board.setLike_count(board.getLike_count() - 1);
            }
        }
    }

}
