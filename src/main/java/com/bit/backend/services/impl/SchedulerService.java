package com.bit.backend.services.impl;

import com.bit.backend.dtos.SchedulerDto;
import com.bit.backend.entities.SchedulerEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SchedulerMapper;
import com.bit.backend.repositories.SchedulerRepository;
import com.bit.backend.services.SchedulerServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService implements SchedulerServiceI {

    private final SchedulerMapper schedulerMapper;
    private final SchedulerRepository schedulerRepository;

    public SchedulerService(SchedulerMapper schedulerMapper, SchedulerRepository schedulerRepository) {
        this.schedulerMapper = schedulerMapper;
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    public SchedulerDto saveScheduleForEmployer(SchedulerDto schedulerDto) {
        try {
            List<SchedulerEntity> schedulerEntityList = schedulerMapper.toSchedulerEntityList(schedulerDto);
            List<SchedulerEntity> savedItems = schedulerRepository.saveAll(schedulerEntityList);
            SchedulerDto savedSchedulerDto = schedulerMapper.toSchedulerDto(savedItems);
            return savedSchedulerDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
