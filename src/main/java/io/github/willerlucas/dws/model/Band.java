package io.github.willerlucas.dws.model;

import lombok.Data;

import java.util.List;

@Data
public class Band {
    private String name;
    private String image;
    private String genre;
    private String biography;
    private int numPlays;
    private List<String> albums;
    private String id;
    private List<List<Album>> albumList;
}
