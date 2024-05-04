package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorWithVisitsTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;

public final class DoctorMapper {
    public static DoctorWithVisitsTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorWithVisitsTO doctorWithVisitsTO = new DoctorWithVisitsTO();
        doctorWithVisitsTO.setId(doctorEntity.getId());
        doctorWithVisitsTO.setFirstName(doctorEntity.getFirstName());
        doctorWithVisitsTO.setLastName(doctorEntity.getLastName());
        doctorWithVisitsTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorWithVisitsTO.setEmail(doctorEntity.getEmail());
        doctorWithVisitsTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorWithVisitsTO.setSpecialization(doctorEntity.getSpecialization().toString());
        doctorWithVisitsTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        return doctorWithVisitsTO;
    }

    public static DoctorEntity mapToEntity(final DoctorWithVisitsTO doctorWithVisitsTO) {
        if (doctorWithVisitsTO == null) {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorWithVisitsTO.getId());
        doctorEntity.setFirstName(doctorWithVisitsTO.getFirstName());
        doctorEntity.setLastName(doctorWithVisitsTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorWithVisitsTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorWithVisitsTO.getEmail());
        doctorEntity.setDoctorNumber(doctorWithVisitsTO.getDoctorNumber());
        doctorEntity.setSpecialization(Specialization.valueOf(doctorWithVisitsTO.getSpecialization()));
        doctorEntity.setAddress(AddressMapper.mapToEntity(doctorWithVisitsTO.getAddress()));
        return doctorEntity;
    }
}
