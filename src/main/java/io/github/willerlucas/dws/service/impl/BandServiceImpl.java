package io.github.willerlucas.dws.service.impl;

import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.BandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Override
    public List<Band> getAllBands() {
        return new ArrayList<>();
    }

    @Override
    public Band getBandById(String bandId) {
        return new Band();
    }
}
