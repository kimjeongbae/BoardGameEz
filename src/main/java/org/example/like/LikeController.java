package org.example.like;

import org.example.board.Board;
import org.example.container.Global;
import java.util.List;

public class LikeController {

    LikeService likeService;
    public LikeController () {
        likeService = new LikeService();
    }



    public void like_up () {
        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("좋아요 누를  게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int boardId = Integer.parseInt(Global.getScanner().nextLine().trim());
        System.out.println("======================================================");

        Board board = likeService.findBoardById(boardId);

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다.");
            System.out.println("======================================================");
            return;
        }

        if (likeService.alreadyLiked(boardId)){
            System.out.println("해당 게시글은 이미 [좋아요] 누르셨습니다.");
            System.out.println("======================================================");
        } else {
            int id = likeService.save(boardId);
            System.out.println(id + "번 게시글을 [좋아요] 누르셨습니다.");
            System.out.println("======================================================");
        }

    }

    public void like_down () {
        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }
        System.out.println("좋아요 취소할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int boardId = Integer.parseInt(Global.getScanner().nextLine().trim());
        System.out.println("======================================================");

        List<Like> likeList = likeService.findByAll(boardId);
        Board board = likeService.findBoardById(boardId);

        if(board == null){
            System.out.println("해당 게시글은 존재하지 않습니다.");
            System.out.println("======================================================");
            return;
        }
        if (!likeService.alreadyLiked(boardId)) {
            System.out.println("해당 게시글은 [좋아요] 가 없습니다.");
            System.out.println("======================================================");
        } else {
            this.likeService.removeLike(boardId);
            System.out.println(boardId + "번 게시글에 [좋아요 취소]를 누르셨습니다.");
            System.out.println("======================================================");
        }
    }
}
