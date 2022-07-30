package io.github.willerlucas.dws.service.impl;

import io.github.willerlucas.dws.client.BandClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.model.Band;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Import(BandServiceImpl.class)
class BandServiceImplTest {

    @Autowired
    BandServiceImpl bandService;

    @MockBean
    BandClient bandClient;

    @Test
    void getAllBands() throws NoContentException {
        List<Band> bandList = new ArrayList<>();
        Band band = new Band();
        bandList.add(band);
        Mockito.when(bandClient.getAllBands()).thenReturn(bandList);
        Assertions.assertNotNull(bandService.getAllBands());
    }

    @Test
    void getBandById() throws NoContentException {
        Band band = new Band();
        Mockito.when(bandClient.getBandById(Mockito.anyString())).thenReturn(band);
        Assertions.assertNotNull(bandService.getBandById("13232"));
    }
}