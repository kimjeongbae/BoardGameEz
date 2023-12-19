package org.example.board;

import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<Board> boardList = new ArrayList<>();


    public int save (String title, String level, int count, int time) {
//        title, level, count, time , Global.getLogineUser().getNickname(),0
      String sql = String.format("INSERT INTO board SET title = '%s' , level = '%s' , count = '%d' , time = '%d', author = '%s',like_count = '%d' , created_date=now();" , title,count,time, Global.getLogineUser().getNickname(),0);

      int id = Global.getDBConnection().insert(sql);

      return id;

    }

    public List<Board> findByAll() {
        return boardList;
    }
    public int delete (Board board) {
        boardList.remove(board);

        return board.getId();
    }

    public Board boardFindId(int id) {
        for (int i = 0; i < boardList.size(); i++) {
            if (id == boardList.get(i).getId()) {
                return boardList.get(i);
            }
        }
        return null;
    }

    public int update(Board board, String title, String level, int count, int time) {
        board.setTitle(title);
        board.setLevel(level);
        board.setCount(count);
        board.setTime(time);

        return board.getId();
    }

    public void likeCountUp(Board board) {
        board.setLike_count(board.getLike_count() + 1);
    }

    public void likeCountDown(Board board) {
        board.setLike_count(board.getLike_count() - 1);
    }
}
