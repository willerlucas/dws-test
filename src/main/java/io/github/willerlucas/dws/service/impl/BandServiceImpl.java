package io.github.willerlucas.dws.service.impl;

import feign.FeignException;
import io.github.willerlucas.dws.client.BandClient;
import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.AlbumService;
import io.github.willerlucas.dws.service.BandService;
import io.github.willerlucas.dws.utils.ListUtils;
import io.github.willerlucas.dws.utils.SortBandByName;
import io.github.willerlucas.dws.utils.SortBandByPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    BandClient bandClient;

    @Autowired
    AlbumService albumService;

    @Cacheable("bands")
    @Override
    public List<Band> getBands(String order, String bandName) throws NoContentException {

        List<Band> bandList;

        try {
            bandList = bandClient.getAllBands();
        } catch (FeignException.FeignClientException e){
            throw new NoContentException("No Bands found");

        }


        //filtering the list
        if(bandName!=null)
            CollectionUtils.filter(bandList, b -> ((Band) b).getName().toUpperCase(Locale.ROOT)
                    .contains(bandName.toUpperCase()));

        //sorting the bandlist
        if(order!=null)
            ListUtils.orderBandList(order, bandList);

        if(bandList.isEmpty())
            throw new NoContentException("No Bands found");

        return bandList;
    }

    @Cacheable("band")
    @Override
    public Band getBandById(String bandId) throws NoContentException {

        Band band;
        List<Album> fullAlbumList;
        try {
            //getting the band
            band = bandClient.getBandById(bandId);
            //getting all albums
            fullAlbumList = albumService.getAllAlbums();
        } catch (FeignException.FeignClientException e){
            throw new NoContentException("No band found for this Id");
        }

        //getting all albums of the band
        band.setAlbumList(new ArrayList<>());

        for(String album : band.getAlbums()){

            List<Album> auxAlbumList = new ArrayList<>();
            auxAlbumList.addAll(fullAlbumList);

            band.getAlbumList().addAll(CollectionUtils.filter(auxAlbumList, a -> ((Album) a).getId().toUpperCase(Locale.ROOT)
                    .contains(album.toUpperCase())));
            
        }

        return band;
    }

}
