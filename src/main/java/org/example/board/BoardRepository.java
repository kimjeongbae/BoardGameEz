package org.example.board;

import org.example.container.Global;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class BoardRepository {



    public int save (String title, String level, int count, int time) {
      String sql = String.format("INSERT INTO board SET title = '%s' , level = '%s' , count = '%d' , time = '%d', user_id = '%d',like_count = '%d' , created_date=now();" , title,level,count,time, Global.getLogineUser().getNickname(),0);

      int id = Global.getDBConnection().insert(sql);

      return id;

    }

    public List<Board> findByAll() {
        List<Board> boardList = new ArrayList<>();

        List<Map<String, Object>> rows =  Global.getDBConnection().selectRows("select * from board");

        for (Map<String, Object> row : rows) {
            Board board = new Board(row);

            boardList.add(board);
        }

        return boardList;
    }

    public void delete(Board board) {
        String sql = String.format("DELETE FROM article where id=%d;", board.getId());
        Global.getDBConnection().delete(sql);
    }

    public Board boardFindId(int id) {
        List<Board> boardList = this.findByAll();
        for (int i = 0; i < boardList.size(); i++) {
            if (id == boardList.get(i).getId()) {
                return boardList.get(i);
            }
        }
        return null;
    }

    public void update(Board board, String title, String level, int count, int time) {
        String sql = String.format("UPDATE board set title='%s', level='%s', count='%d', time='%d' ,where id=%d;", title, level,count,time,board.getId());
        Global.getDBConnection().update(sql);
    }

    public void likeCountUp(Board board) {
        board.setLike_count(board.getLike_count() + 1);
    }

    public void likeCountDown(Board board) {
        board.setLike_count(board.getLike_count() - 1);
    }
}
