package io.github.willerlucas.dws.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class Band implements Comparable<Band>{
    private String name;
    private String image;
    private String genre;
    private String biography;
    private int numPlays;
    private List<String> albums;
    private String id;
    private List<Album> albumList;


    @Override
    public int compareTo(@NotNull Band o) {
        return 0;
    }
}
