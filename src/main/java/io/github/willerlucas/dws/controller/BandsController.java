package io.github.willerlucas.dws.controller;

import io.github.willerlucas.dws.exception.NoContentException;
import io.github.willerlucas.dws.model.Band;
import io.github.willerlucas.dws.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bands")
public class BandsController {

    @Autowired
    BandService bandService;

    @GetMapping()
    public ResponseEntity<List<Band>> getAllBands() throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(bandService.getAllBands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Band> getBandById(@PathVariable("id") String bandId) throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(bandService.getBandById(bandId));
    }

}
