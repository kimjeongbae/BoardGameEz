package org.example.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    private int id;
    private String boardTitle;
    private String score;
    private String content;
    private String author;
    private String created_date;
}
