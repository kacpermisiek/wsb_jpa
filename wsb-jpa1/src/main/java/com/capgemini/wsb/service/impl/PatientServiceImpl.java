package com.capgemini.wsb.service.impl;


import com.capgemini.wsb.dto.PatientWithVisitsTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) {
        patientDao = pPatientDao;
    }

    @Override
    public PatientWithVisitsTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void deletePatient(Long id) {
        patientDao.delete(id);
    }
}