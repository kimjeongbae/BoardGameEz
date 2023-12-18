package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Board {
    int id;
    String title;
    String level;
    int count;
    int time;
    String author;
    int like_count;
    String created_date;
}
