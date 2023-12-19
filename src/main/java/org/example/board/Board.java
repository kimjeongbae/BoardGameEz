package org.example.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String level;
    private int count;
    private int time;
    private String author;
    private int like_count;
    private String created_date;

    Board (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.level = (String)row.get("level");
        this.count = (int)row.get("count");
        this.time = (int)row.get("time");
        this.author = (String)row.get("author");
        this.like_count = (int)row.get("like_count");
        this.created_date = row.get("created_date").toString();
    }
}
