package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientWithVisitsTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper{
    public static PatientWithVisitsTO mapToTO(final PatientEntity patientEntity){
        if (patientEntity == null){
            return null;
        }
        final PatientWithVisitsTO patientWithVisitsTO = new PatientWithVisitsTO();
        patientWithVisitsTO.setId(patientEntity.getId());
        patientWithVisitsTO.setFirstName(patientEntity.getFirstName());
        patientWithVisitsTO.setLastName(patientEntity.getLastName());
        patientWithVisitsTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientWithVisitsTO.setEmail(patientEntity.getEmail());
        patientWithVisitsTO.setPatientNumber(patientEntity.getPatientNumber());
        patientWithVisitsTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientWithVisitsTO.setDiscount(patientEntity.getDiscount());
        patientWithVisitsTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        if (patientEntity.getVisits() != null) {
            patientWithVisitsTO.setVisits(patientEntity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));
        }
        return patientWithVisitsTO;
    }

    public static PatientEntity mapToEntity(final PatientWithVisitsTO patientWithVisitsTO){
        if(patientWithVisitsTO == null){
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientWithVisitsTO.getId());
        patientEntity.setFirstName(patientWithVisitsTO.getFirstName());
        patientEntity.setLastName(patientWithVisitsTO.getLastName());
        patientEntity.setTelephoneNumber(patientWithVisitsTO.getTelephoneNumber());
        patientEntity.setEmail(patientWithVisitsTO.getEmail());
        patientEntity.setPatientNumber(patientWithVisitsTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientWithVisitsTO.getDateOfBirth());
        patientEntity.setDiscount(patientWithVisitsTO.getDiscount());
        patientEntity.setAddress(AddressMapper.mapToEntity(patientWithVisitsTO.getAddress()));
        if (patientWithVisitsTO.getVisits() != null) {
            patientEntity.setVisits(patientWithVisitsTO
                            .getVisits()
                            .stream()
                            .map(VisitMapper::mapToEntity)
                            .collect(Collectors.toList()
                            )
                    );
        }
        return patientEntity;
    }

}
