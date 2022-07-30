package io.github.willerlucas.dws.client;

import feign.RequestLine;
import io.github.willerlucas.dws.config.FeignConfiguration;
import io.github.willerlucas.dws.model.Album;
import io.github.willerlucas.dws.model.Band;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "AlbumClient", name="AlbumClient", url="https://iws-brazil-labs-iws-recruiting-bands-staging.iwsbrazil.io/api/albums", configuration = FeignConfiguration.class)
public interface AlbumClient {
    @RequestLine("GET")
    List<Album> getAllAlbums();
}
