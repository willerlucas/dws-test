package io.github.willerlucas.dws.client;

import feign.Param;
import feign.RequestLine;
import io.github.willerlucas.dws.config.FeignConfiguration;
import io.github.willerlucas.dws.model.Band;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "BandClient", name="BandClient", url="https://iws-brazil-labs-iws-recruiting-bands-staging.iwsbrazil.io/api/bands", configuration = FeignConfiguration.class)
public interface BandClient {

    @RequestLine("GET")
    List<Band> getAllBands();

    @RequestLine("GET /{id}")
    Band getBandById(@Param("id") String id);


}
