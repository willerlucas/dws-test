package io.github.willerlucas.dws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Album {
    private String name;
    private String image;
    private LocalDate releasedDate;
    private String band;
    private List<Track> tracks;
    private String id;
}
