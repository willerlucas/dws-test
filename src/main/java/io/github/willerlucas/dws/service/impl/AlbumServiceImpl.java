package io.github.willerlucas.dws.service.impl;

import feign.FeignException;
import io.github.willerlucas.dws.client.AlbumClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumClient albumClient;

    @Cacheable("album")
    @Override
    public List<Album> getAllAlbums() throws NoContentException {

        List<Album> albumList;

        try {
            albumList = albumClient.getAllAlbums();
        } catch (FeignException.FeignClientException e){
            throw new NoContentException("No Albums found");
        }

        return albumList;
    }
}
