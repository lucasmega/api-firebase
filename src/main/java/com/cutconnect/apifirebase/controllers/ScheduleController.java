package com.cutconnect.apifirebase.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cutconnect.apifirebase.services.ScheduleService;
import com.cutconnect.apifirebase.domains.form.ScheduleFromBarbershop;

@RequestMapping(value = "/schedule")
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @RequestMapping(value = "/find-hour-by-date-from-barbershop", method = RequestMethod.POST)
    public ResponseEntity<List<String>> findHourByDateFromBarbershop(@RequestBody ScheduleFromBarbershop object) {
            return ResponseEntity.ok(scheduleService.findHourByDateFromBarbershop(object));
    }
}
