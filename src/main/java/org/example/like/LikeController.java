package org.example.like;

import org.example.board.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LikeController {
    List<Like> likeList = new ArrayList<>();
    int likeId = 1;

    public void like_up () {
        if (loginedUser == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            continue;
        }

        System.out.println("좋아요 누를  게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int boardId = Integer.parseInt(sc.nextLine().trim());
        System.out.println("======================================================");

        Board board = null;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardId == boardList.get(i).getId()) {
                board = boardList.get(i);
            }
        }

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다.");
            System.out.println("======================================================");
            continue;
        }

        boolean alreadyLiked = false;
        for (Like like : likeList) {
            if (like.getBoardId() == boardId && like.getUserId().equals(loginedUser.getNickname())) {
                System.out.println("해당 게시글은 이미 [좋아요] 누르셨습니다.");
                System.out.println("======================================================");
                alreadyLiked = true;
            }
        }

        // 좋아요를 누르지 않은 경우에만 추가
        if (!alreadyLiked) {
            Like like = new Like(likeId, boardId, loginedUser.getNickname());
            likeList.add(like);
            board.setLike_count(board.getLike_count() + 1);
            likeId++;
            System.out.println(board.getId() + "번 게시글을 [좋아요] 누르셨습니다.");
            System.out.println("======================================================");
        }
    }

    public void like_down () {
        if (loginedUser == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            continue;
        }
        System.out.println("좋아요 취소할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int boardId = Integer.parseInt(sc.nextLine().trim());
        System.out.println("======================================================");

        Board board = null;

        for (int i = 0; i < boardList.size(); i++) {
            if (boardId == boardList.get(i).getId()) {
                board = boardList.get(i);
            }
        }

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다.");
            System.out.println("======================================================");
            continue;
        }

        // 반복자(iterator)를 사용하여 likeList에서
        // ConcurrentModificationException 문제를 피하도록 수정
        boolean alreadyUnliked = false;
        Iterator<Like> iterator = likeList.iterator();
        while (iterator.hasNext()) {
            Like like = iterator.next();
            if (like.getBoardId() == boardId && like.getUserId().equals(loginedUser.getNickname())) {
                iterator.remove();
                alreadyUnliked = true;
                board.setLike_count(board.getLike_count() - 1);
                System.out.println(board.getId() + "번 게시글에 [좋아요 취소]를 누르셨습니다.");
                System.out.println("======================================================");
            }
        }
        if (!alreadyUnliked) {
            System.out.println("해당 게시글은 [좋아요] 가 없습니다.");
            System.out.println("======================================================");
        }
    }
}
