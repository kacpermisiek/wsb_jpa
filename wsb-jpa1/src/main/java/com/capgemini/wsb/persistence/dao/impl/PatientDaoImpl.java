package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreVisitsThan(int visits) {
        return entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visits", PatientEntity.class)
                .setParameter("visits", visits)
                .getResultList();
    }

    @Override
    public List<VisitEntity> findPatientVisits(Long id) {
        return entityManager.createQuery(
                "SELECT v FROM VisitEntity v WHERE v.patient.id = :id", VisitEntity.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithDiscount() {
        return entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.discount > 0", PatientEntity.class)
                .getResultList();
    }
}
