package org.example.like;

import org.example.board.Board;
import org.example.container.Global;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LikeRepository {
    List<Like> likeList = new ArrayList<>();

    int lastLikeId = 1;


    public int save (int boardId) {
        Like like = new Like(lastLikeId, boardId, Global.getLogineUser().getNickname());
        likeList.add(like);
        lastLikeId++;
        return like.getId();
    }

    public List<Like> findByAll() {
        return likeList;
    }
    public boolean alreadyLiked(int boardId) {
        for (Like like : likeList) {
            if (like.getBoardId() == boardId && like.getUserId().equals(Global.getLogineUser().getNickname())) {
                return true;
            }
        }
        return false;
    }

    public void removeLike(int boardId) {
        Iterator<Like> iterator = likeList.iterator();
        while (iterator.hasNext()) {
            Like like = iterator.next();
            if (like.getBoardId() == boardId && like.getUserId().equals(Global.getLogineUser().getNickname())) {
                iterator.remove();
            }
        }
    }

}
