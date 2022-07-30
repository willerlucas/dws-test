package io.github.willerlucas.dws.service;

import io.github.willerlucas.dws.model.Band;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BandService {
    List<Band> getAllBands();

    Band getBandById(String bandId);
}
