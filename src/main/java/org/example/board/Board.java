package org.example.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
}
