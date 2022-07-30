package io.github.willerlucas.dws.service;

import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Band;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BandService {
    List<Band> getBands(String order, String bandName) throws NoContentException;

    Band getBandById(String bandId) throws NoContentException;
}
