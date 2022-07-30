package io.github.willerlucas.dws.service.impl;

import feign.FeignException;
import io.github.willerlucas.dws.client.BandClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    BandClient bandClient;

    @Override
    public List<Band> getAllBands() throws NoContentException {

        List<Band> bandList;

        try {
            bandList = bandClient.getAllBands();
        } catch (FeignException.FeignClientException e){
            throw new NoContentException("No Bands found");

        }

        return bandList;
    }

    @Override
    public Band getBandById(String bandId) throws NoContentException {

        Band band;
        try {
            band = bandClient.getBandById(bandId);
        } catch (FeignException.FeignClientException e){
            throw new NoContentException("No band found for this Id");
        }

        return band;
    }
}
