package io.github.willerlucas.dws.controller;

import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping()
    public ResponseEntity<List<Album>> getAllAlbums() throws NoContentException {
        log.info("fetch all albums in album controller");
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAllAlbums());
    }
}
