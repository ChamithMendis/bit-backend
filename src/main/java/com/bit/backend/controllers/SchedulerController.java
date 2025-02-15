package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.dtos.PeriodDto;
import com.bit.backend.dtos.SchedulerDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.SchedulerServiceI;
import com.bit.backend.services.impl.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class SchedulerController {

    private final SchedulerServiceI schedulerServiceI;

    public SchedulerController(SchedulerServiceI schedulerServiceI) {
        this.schedulerServiceI = schedulerServiceI;
    }

    @PostMapping("/scheduler")
    public ResponseEntity<SchedulerDto> saveScheduleForEmployer(@RequestBody SchedulerDto schedulerDto) {
        try {
            SchedulerDto responseSchedulerDto = schedulerServiceI.saveScheduleForEmployer(schedulerDto);
            return ResponseEntity.created(URI.create("/scheduler"+responseSchedulerDto.getEmpNo())).body(responseSchedulerDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
