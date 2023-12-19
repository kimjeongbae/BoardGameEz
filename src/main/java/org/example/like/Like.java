package org.example.like;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Like {
    private int id;
    private int boardId;
    private String userId;
}
