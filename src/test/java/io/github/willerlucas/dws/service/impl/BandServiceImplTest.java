package io.github.willerlucas.dws.service.impl;

import io.github.willerlucas.dws.client.AlbumClient;
import io.github.willerlucas.dws.client.BandClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.AlbumService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Import(BandServiceImpl.class)
class BandServiceImplTest {

    @Autowired
    BandServiceImpl bandService;

    @MockBean
    BandClient bandClient;

    @MockBean
    AlbumService albumService;

    @MockBean
    List<Album> albumList;

    @BeforeEach
    void setup() throws NoContentException {
        albumList = new ArrayList<>();
        Album album = new Album();
        album.setId("aadf");
        albumList.add(album);
        Mockito.when(albumService.getAllAlbums()).thenReturn(albumList);
    }

    @Test
    void getAllBands() throws NoContentException {
        List<Band> bandList = new ArrayList<>();
        Band band = new Band();
        band.setName("mock");
        bandList.add(band);
        Mockito.when(bandClient.getAllBands()).thenReturn(bandList);
        Assertions.assertNotNull(bandService.getBands("mock", "mock"));
    }

    @Test
    void getBandById() throws NoContentException {
        Band band = new Band();
        band.setName("mock");
        band.setAlbums(new ArrayList<>());
        band.getAlbums().add("aaa");
        Mockito.when(bandClient.getBandById(Mockito.anyString())).thenReturn(band);
        Assertions.assertNotNull(bandService.getBandById("13232"));
    }
}