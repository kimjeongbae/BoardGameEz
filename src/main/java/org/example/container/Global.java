package org.example.container;

import org.example.User;
import org.example.board.Board;
import org.example.like.Like;
import org.example.review.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Global {
    Scanner sc = new Scanner(System.in);
    List<Like> likeList = new ArrayList<>();
    int likeId = 1;
    List<Review> reviewList = new ArrayList<>();
    int lastReviewId = 1;

    List<User> userList = new ArrayList<>();
    int lastUserId = 1;
    List<Board> boardList = new ArrayList<>();
    int lastBoardId = 1;

    User loginedUser = null;
}
