package org.example.board;


import java.util.List;

public class BoardService {
    BoardRepository boardRepository;

    BoardService() {
        boardRepository = new BoardRepository();
    }

    public int save(String title, String level, int count, int time) {
        return this.boardRepository.save(title, level, count, time);
    }

    public List<Board> findByAll() {
        return this.boardRepository.findByAll();
    }

    public int delete(Board board) {
        return this.boardRepository.delte(board);
    }

    public Board boardFindId(int id) {
        return this.boardRepository.boardFindId(id);
    }

    public int update(Board board, String title, String level, int count, int time) {
        return this.boardRepository.update(board, title, level, count, time);
    }
}
