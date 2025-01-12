package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class FormDemoController {

    private final FormDemoServiceI formDemoServiceI;

    public FormDemoController(FormDemoServiceI formDemoServiceI) {
        this.formDemoServiceI = formDemoServiceI;
    }

    @PostMapping("/form-demo")
    public ResponseEntity<FormDemoDto> addForm(@RequestBody FormDemoDto formDemoDto) {
        FormDemoDto formDemoDtoResponse = formDemoServiceI.addFormDemoEntity(formDemoDto);
        return ResponseEntity.created(URI.create("/form-demo"+formDemoDtoResponse.getFirstName())).body(formDemoDtoResponse);
    }

    @GetMapping("/form-demo")
    public ResponseEntity<List<FormDemoDto>> getData() {
        /* controller -> service (interface) -> repository */
        /* DTO, Entity, Mapper */
        List<FormDemoDto> formDemoDtoList = formDemoServiceI.getData();
        return ResponseEntity.ok(formDemoDtoList);
    }
}
