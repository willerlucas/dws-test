package io.github.willerlucas.dws.service.impl;

import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Override
    public List<Album> getAllAlbums() {
        return new ArrayList<>();
    }
}
