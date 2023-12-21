package org.example.board;

import org.example.container.Global;
import org.example.like.Like;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardRepository {

    List<Like> boadList = new ArrayList<>();

    int lastLikeId = 1;

    public int save (String title, String level, int count, int time) {
      String sql = String.format("INSERT INTO board SET title = '%s' , level = '%s' , count = '%d' , time = '%d', userId = '%s',like_count = '%d' , created_date=now();" , title,level,count,time, Global.getLogineUser().getId(),0);

      int id = Global.getDBConnection().insert(sql);

      return id;

    }
    public void delete(Board board) {
        String sql = String.format("DELETE FROM board where id=%d;", board.getId());
        Global.getDBConnection().delete(sql);
    }
    public void update(Board board, String title, String level, int count, int time) {
        String sql = String.format("UPDATE board SET title='%s', level='%s', count='%d', time='%d' where id=%d;", title, level,count,time,board.getId());
        Global.getDBConnection().update(sql);
    }


//    user id -> 닉네임 ( 게시글 번호 / 보드게임 이름 / 난이도 / 인원수 / 시간 / 닉네임 / 좋아요 / 날짜)
    public List<BoardDTO> joinMemberFindByAll() {
        List<BoardDTO> boardList = new ArrayList<>();
        List<Map<String, Object>> rows =  Global.getDBConnection().selectRows("SELECT B.*,U.nickname FROM board AS B INNER JOIN `user` AS U ON B.userId = U.id;\n");

        for (Map<String, Object> row : rows) {
            BoardDTO board = new BoardDTO(row);

            boardList.add(board);
        }

        return boardList;
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

    public Board boardFindId(int id) {
        List<Board> boardList = this.findByAll();
        for (int i = 0; i < boardList.size(); i++) {
            if (id == boardList.get(i).getId()) {
                return boardList.get(i);
            }
        }
        return null;
    }
    public List<BoardDTO> searchByBoardUser(String searchKeyword) {
        List<BoardDTO> boardList = new ArrayList<>();

        String sql = String.format(
                "SELECT B.*, U.nickname FROM `board` AS B INNER JOIN `user` AS U ON B.userId = U.id WHERE U.nickname LIKE '%s%%';",
                searchKeyword);

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            BoardDTO board = new BoardDTO(row);
            boardList.add(board);
        }

        return boardList;
    }

    public List<BoardDTO> searchByBoardGame(String searchKeyword) {
        List<BoardDTO> boardList = new ArrayList<>();

        String sql = String.format(
                "SELECT B.*, U.nickname FROM `board` AS B INNER JOIN `user` AS U ON B.userId = U.id WHERE `title` LIKE '%s%%';",
                searchKeyword);

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            BoardDTO board = new BoardDTO(row);
            boardList.add(board);
        }

        return boardList;
    }



    public void likeCountUp(Board board) {
        board.setLike_count(board.getLike_count() + 1);
    }

    public void likeCountDown(Board board) {
        board.setLike_count(board.getLike_count() - 1);
    }

}
