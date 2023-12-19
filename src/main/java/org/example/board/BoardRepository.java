package org.example.board;

import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<Board> boardList = new ArrayList<>();
    int lastBoardId = 1;

    public int save (String title, String level, int count, int time) {
        Board board = new Board(lastBoardId, title, level, count, time , Global.getLogineUser().getNickname(),0,Global.nowDateTime());
        boardList.add(board);

        lastBoardId++;

        return board.getId();
    }

    public List<Board> findByAll() {
        return boardList;
    }
    public int delte (Board board) {
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
}
