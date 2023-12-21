package org.example.review;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
public class ReviewDTO {
    private int id;
    private String boardTitle;
    private String score;
    private String content;
    private int userId;
    private String nickname;
    private String created_date;
    private String searchKeyword;

    ReviewDTO (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.boardTitle = (String)row.get("boardTitle");
        this.score = (String)row.get("score");
        this.content = (String) row.get("content");
        this.userId = (int)row.get("userId");
        this.nickname = (String) row.get("nickname");
        this.created_date = row.get("created_date").toString();
        this.searchKeyword = (String) row.get("searchKeyword");
    }
}
