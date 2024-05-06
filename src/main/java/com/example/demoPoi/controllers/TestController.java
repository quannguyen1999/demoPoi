package com.example.demoPoi.controllers;

import com.example.demoPoi.model.RequestDto;
import com.example.demoPoi.services.TestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping
@AllArgsConstructor
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(path = "test", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> test(@RequestParam("file") MultipartFile file) throws IOException {
        testService.handlerData(file.getBytes());
        return ResponseEntity.status(HttpStatus.OK)
                .body("success");
    }
}
