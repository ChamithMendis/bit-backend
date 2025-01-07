package com.bit.backend.services;

import com.bit.backend.dtos.FormDemoDto;

import java.util.List;

public interface FormDemoServiceI {
    List<FormDemoDto> getData();
    FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto);
    FormDemoDto updateFormDemoEntity(long id, FormDemoDto formDemoDto);
    FormDemoDto deleteFormDemoEntity(long id);
    FormDemoDto changeStatus(long id, String status);
}
