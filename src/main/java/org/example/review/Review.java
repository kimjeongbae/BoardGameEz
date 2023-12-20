package org.example.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    private int id;
    private String boardTitle;
    private String score;
    private String content;
    private int userId;
    private String created_date;

    Review (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.boardTitle = (String)row.get("boardTitle");
        this.score = (String)row.get("score");
        this.content = (String) row.get("content");
        this.userId = (int)row.get("userId");
        this.created_date = row.get("created_date").toString();
    }
}
