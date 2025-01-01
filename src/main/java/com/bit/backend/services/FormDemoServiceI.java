package com.bit.backend.services;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;

public interface FormDemoServiceI {

    FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto);
}
