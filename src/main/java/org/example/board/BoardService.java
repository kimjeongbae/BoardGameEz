package org.example.board;


import org.example.review.ReviewDTO;

import java.util.List;

public class BoardService {
    BoardRepository boardRepository;

    public BoardService() {
        boardRepository = new BoardRepository();
    }

    public int save(String title, String level, int count, int time) {
        return this.boardRepository.save(title, level, count, time);
    }

    public List<Board> findByAll() {
        return this.boardRepository.findByAll();
    }
    public List<BoardDTO> joinMemberFindByAll() {
        return this.boardRepository.joinMemberFindByAll();
    }

    public void delete(Board board) {
        this.boardRepository.delete(board);
    }

    public Board boardFindId(int id) {
        return this.boardRepository.boardFindId(id);
    }

    public void update(Board board, String title, String level, int count, int time) {
        this.boardRepository.update(board, title, level, count, time);
    }

    public List<BoardDTO> searchByBoardUser (String searchKeyword) {
        return this.boardRepository.searchByBoardUser(searchKeyword);
    }
    public List<BoardDTO> searchByBoardGame (String searchKeyword) {
        return this.boardRepository.searchByBoardGame(searchKeyword);
    }

    public void likeCountUp(Board board) {
        this.boardRepository.likeCountUp(board);
    }

    public void likeCountDown(Board board) {
        this.boardRepository.likeCountDown(board);
    }


}


