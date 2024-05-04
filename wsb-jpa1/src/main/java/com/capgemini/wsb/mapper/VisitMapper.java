package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class VisitMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        visitTO.setPatient(getPatientWithoutVisitsTO(visitEntity));
        visitTO.setDoctor(getDoctorWithoutVisitsTO(visitEntity));

        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setMedicalTreatments(
                    visitEntity
                            .getMedicalTreatments()
                            .stream()
                            .map(MedicalTreatmentMapper::mapToTO)
                            .collect(Collectors.toList()
                            )
            );
        }

        return visitTO;
    }

    private static DoctorTO getDoctorWithoutVisitsTO(VisitEntity visitEntity) {
        DoctorEntity doctorEntity = visitEntity.getDoctor();

        final DoctorTO doctorTO = new DoctorTO();

        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization().toString());
        doctorTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        return doctorTO;

    }

    private static PatientTO getPatientWithoutVisitsTO(VisitEntity visitEntity) {
        PatientEntity patientEntity = visitEntity.getPatient();

        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAdult(patientEntity.isAdult());
        return patientTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
//        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
//
//        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));

        if (visitTO.getMedicalTreatments() != null) {
            visitEntity.setMedicalTreatments(
                    visitTO
                            .getMedicalTreatments()
                            .stream()
                            .map(MedicalTreatmentMapper::mapToEntity)
                            .collect(Collectors.toList())
            );
        }

        return visitEntity;
    }

}
