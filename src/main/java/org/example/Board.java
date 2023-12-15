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
    String count;
    String time;
}
