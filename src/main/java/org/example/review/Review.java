package org.example.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    int id;
    String boardTitle;
    String score;
    String content;
    String author;
    String created_date;
}
