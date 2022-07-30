package io.github.willerlucas.dws.service.impl;

import feign.Feign;
import feign.FeignException;
import feign.Request;
import io.github.willerlucas.dws.client.AlbumClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@Import(AlbumServiceImpl.class)
class AlbumServiceImplTest {

    @Autowired
    AlbumServiceImpl albumService;

    @MockBean
    AlbumClient albumClient;

    @Test
    void getAllAlbums() throws NoContentException {

        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        albumList.add(album);
        Mockito.when(albumClient.getAllAlbums()).thenReturn(albumList);
        Assertions.assertNotNull(albumService.getAllAlbums());

    }

}