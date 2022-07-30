package io.github.willerlucas.dws.service.impl;

import io.github.willerlucas.dws.client.BandClient;
import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    BandClient bandClient;

    @Override
    public List<Band> getAllBands() {
        return bandClient.getAllBands();
    }

    @Override
    public Band getBandById(String bandId) {
        return bandClient.getBandById(bandId);
    }
}
