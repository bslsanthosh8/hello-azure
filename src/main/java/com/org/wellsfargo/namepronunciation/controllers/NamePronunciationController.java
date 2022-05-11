package com.org.wellsfargo.namepronunciation.controllers;

import com.org.wellsfargo.namepronunciation.dao.NamePronunciationService;
import com.org.wellsfargo.namepronunciation.entity.NamePronunciation;
import com.org.wellsfargo.namepronunciation.request.NamePronunciationRequest;
import com.org.wellsfargo.namepronunciation.response.NamePronunciationResponse;
import com.org.wellsfargo.namepronunciation.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class NamePronunciationController {

    @Autowired
    NamePronunciationService namePronunciationService;

    @RequestMapping(value = "/NamePronunciation", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseEntity<NamePronunciationResponse<String>> addNamePronunciationSound(@RequestPart("file") MultipartFile mp3Data, @RequestPart("data") NamePronunciationRequest namePronunciationRequest) throws IOException {

        NamePronunciationResponse<String> response = new NamePronunciationResponse<>();
        NamePronunciation namePronunciation = NamePronunciationRequest.getNamePronunciation(namePronunciationRequest);
        if (mp3Data != null) {
            byte[] soundData = mp3Data.getBytes();
            namePronunciation.setPronunciationSound(soundData);
            namePronunciationService.save(namePronunciation);
            response.setStatus(Status.SUCCESS.name());
            response.setData("");
            response.setError("");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setStatus(Status.FAILED.name());
        response.setData("");
        response.setError("NPA001:Error occurred while persisting name sound request");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getNameSound/{id}")
    ResponseEntity<byte[]> getNamePronunciation(@PathVariable("id") Integer id) {
        byte[] namePronunciation = namePronunciationService.findById(id).get().getPronunciationSound();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=voice.mp3").body(namePronunciation);
    }
}
