package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.PatientWithVisitsTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    public PatientWithVisitsTO findById(final Long id);

    public void deletePatient(final Long id);

    public List<VisitTO> findVisitsByPatientId(final Long id);
}
