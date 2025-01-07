package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class FormDemoController {

    private final FormDemoServiceI formDemoServiceI;

    public FormDemoController(FormDemoServiceI formDemoServiceI) {
        this.formDemoServiceI = formDemoServiceI;
    }

    @GetMapping("/form-demo")
    public ResponseEntity<List<FormDemoDto>> getData() {
        try {
            List<FormDemoDto> formDemoDtoList = formDemoServiceI.getData();
            return ResponseEntity.ok(formDemoDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/form-demo")
    public ResponseEntity<FormDemoDto> addForm(@RequestBody FormDemoDto formDemoDto) {
        try {
            FormDemoDto formDemoDtoResponse = formDemoServiceI.addFormDemoEntity(formDemoDto);
            return ResponseEntity.created(URI.create("/form-demo"+formDemoDtoResponse.getFirstName())).body(formDemoDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> updateFormDemo(@PathVariable long id, @RequestBody FormDemoDto formDemoDto) {
        try {
            FormDemoDto formDemoDtoResponse = formDemoServiceI.updateFormDemoEntity(id, formDemoDto);
            return ResponseEntity.ok(formDemoDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> deleteFormDemo(@PathVariable long id) {
        try {
            FormDemoDto formDemoDtoResponse = formDemoServiceI.deleteFormDemoEntity(id);
            return ResponseEntity.ok(formDemoDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/form-demo/change-status/{id}")
    public ResponseEntity<FormDemoDto> changeStatus(@PathVariable long id, @RequestBody String status) {
        try {
            FormDemoDto formDemoDtoResponse = formDemoServiceI.changeStatus(id, status);
            return ResponseEntity.ok(formDemoDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
