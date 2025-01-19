package com.bit.backend.services.impl;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.FormDemoMapper;
import com.bit.backend.repositories.FormDemoRepository;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormDemoService implements FormDemoServiceI {

    private final FormDemoRepository formDemoRepository;
    private final FormDemoMapper formDemoMapper;

    public FormDemoService(FormDemoRepository formDemoRepository, FormDemoMapper formDemoMapper) {
        this.formDemoRepository = formDemoRepository;
        this.formDemoMapper = formDemoMapper;
    }

    @Override
    public FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto) {
        System.out.println("***********In Backend**************");
        FormDemoEntity formDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);
        FormDemoEntity savedItem = formDemoRepository.save(formDemoEntity);
        FormDemoDto savedDto = formDemoMapper.toFormDemoDto(savedItem);
        return savedDto;
    }

    @Override
    public List<FormDemoDto> getData() {
        // db operations and send data

        List<FormDemoEntity> formDemoEntityList = formDemoRepository.findAll();
        List<FormDemoDto> formDemoDtoList = formDemoMapper.toFormDemoDtoList(formDemoEntityList);
        return formDemoDtoList;
    }

    @Override
    public FormDemoDto updateFormDemo(long id, FormDemoDto formDemoDto) {

        Optional<FormDemoEntity> optionalFormDemoEntity = formDemoRepository.findById(id);

        if (!optionalFormDemoEntity.isPresent()) {
            throw new AppException("Form Demo Does Not Exists", HttpStatus.BAD_REQUEST);
        }

        FormDemoEntity newFormDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);
        newFormDemoEntity.setId(id);

        FormDemoEntity formDemoEntity = formDemoRepository.save(newFormDemoEntity);

        FormDemoDto responseFormDemoDto = formDemoMapper.toFormDemoDto(formDemoEntity);
        return responseFormDemoDto;
    }

    @Override
    public FormDemoDto deleteFormDemo(long id) {

        Optional<FormDemoEntity> optionalFormDemoEntity = formDemoRepository.findById(id);

        if (!optionalFormDemoEntity.isPresent()) {
            throw new AppException("Form Demo Does Not Exists", HttpStatus.BAD_REQUEST);
        }

        formDemoRepository.deleteById(id);

        return formDemoMapper.toFormDemoDto(optionalFormDemoEntity.get());
    }
}
