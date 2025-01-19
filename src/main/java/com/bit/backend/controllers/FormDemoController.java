package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.services.FormDemoServiceI;
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

    @PutMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> updateFormDemo(@PathVariable long id, @RequestBody FormDemoDto formDemoDto) {
        FormDemoDto responseFormDemoDto = formDemoServiceI.updateFormDemo(id, formDemoDto);
        return ResponseEntity.ok(responseFormDemoDto);
    }

    @DeleteMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> deleteFormDemo(@PathVariable long id) {
        FormDemoDto formDemoDto = formDemoServiceI.deleteFormDemo(id);
        return ResponseEntity.ok(formDemoDto);
    }
}
