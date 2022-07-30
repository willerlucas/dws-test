package io.github.willerlucas.dws.service;

import io.github.willerlucas.dws.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlbumService {
    List<Album> getAllAlbums();
}
