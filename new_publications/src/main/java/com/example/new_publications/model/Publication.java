package com.example.new_publications.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Publication {
    private int id;
    private String name;
    private String description;
}
