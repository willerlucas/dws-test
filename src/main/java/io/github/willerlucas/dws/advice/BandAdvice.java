package io.github.willerlucas.dws.advice;

import io.github.willerlucas.dws.controller.BandsController;
import io.github.willerlucas.dws.exception.NoContentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = BandsController.class)
public class BandAdvice {

    @ExceptionHandler(value = NoContentException.class)
    public ResponseEntity noBandFound(NoContentException e){
        log.error(e.getMessage());
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }

}
