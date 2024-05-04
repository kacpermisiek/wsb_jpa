package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientWithVisitsTO;

public interface PatientService {
    public PatientWithVisitsTO findById(final Long id);

    public void deletePatient(final Long id);
}
