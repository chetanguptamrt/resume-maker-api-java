package com.resume.resumemakerapi.controller;

import com.resume.resumemakerapi.helper.ResponseHelper;
import com.resume.resumemakerapi.model.AllModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.resumemakerapi.service.ResumeService;

@RestController
@CrossOrigin
public class MainController {

    @Autowired
    private ResumeService resumeService;
    
    @PostMapping(value = "/resume-1")
    public ResponseEntity<ResponseHelper> resume1(
                @RequestBody AllModel model) {
        ResponseHelper rHelper = this.resumeService.resume1(model);
        return ResponseEntity.ok(rHelper);
    }

    @PostMapping(value = "/resume-2")
    public ResponseEntity<ResponseHelper> resume2(
                @RequestBody AllModel model) {
        ResponseHelper rHelper = this.resumeService.resume2(model);
        return ResponseEntity.ok(rHelper);
    }

    @PostMapping(value = "/resume-3")
    public ResponseEntity<ResponseHelper> resume3(
                @RequestBody AllModel model) {
        ResponseHelper rHelper = this.resumeService.resume3(model);
        return ResponseEntity.ok(rHelper);
    }

}
