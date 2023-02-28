package com.basic.rest.project.rest.controller;


import com.basic.rest.project.rest.controller.ProgramApi;
import com.basic.rest.project.rest.models.ProgramResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ProgramApiControllerImpl implements ProgramApi{

    public ResponseEntity<ProgramResponse> program() {
        log.info("This is a very basic program on rest API.");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
