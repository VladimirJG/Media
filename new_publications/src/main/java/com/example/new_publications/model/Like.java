package com.example.new_publications.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Like {
    private int like_id;
    private LikeFormat likeFormat;

    public enum LikeFormat {
        LIKE, DISLIKE, ANGRY
    }
}