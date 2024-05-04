package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientWithVisitsTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{id}")
    PatientWithVisitsTO findById(@PathVariable final Long id) {
        final PatientWithVisitsTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }
}
