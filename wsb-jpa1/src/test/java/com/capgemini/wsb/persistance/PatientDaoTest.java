package com.capgemini.wsb.persistance;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientBySurname() {
        // given
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Kowalski1");
        // then
        assertThat(patients.size()).isEqualTo(1);
        assertThat(patients.get(0).getFirstName()).isEqualTo("Jan");
        assertThat(patients.get(0).getLastName()).isEqualTo("Kowalski1");
    }

    @Transactional
    @Test
    public void testShouldReturnEmptyListWhenThereIsNoPatientWithGivenSurname() {
        // given
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Nowak");
        // then
        assertThat(patients.size()).isEqualTo(0);
    }


    @Transactional
    @Test
    public void testFindPatientsWithMoreVisitsThan() {
        // given
        // when
        List<PatientEntity> patientsWithMoreThanZeroVisits = patientDao.findPatientsWithMoreVisitsThan(0);
        // then
        assertThat(patientsWithMoreThanZeroVisits.size()).isEqualTo(3);  // 5 patients in db - 2 with 0 visits

        // when
        List<PatientEntity> patientsWithMoreThatOneVisit = patientDao.findPatientsWithMoreVisitsThan(1);
        // then
        assertThat(patientsWithMoreThatOneVisit.size()).isEqualTo(1);

        // when
        List<PatientEntity> patientsWithMoreThatTwoVisits = patientDao.findPatientsWithMoreVisitsThan(2);
        // then
        assertThat(patientsWithMoreThatTwoVisits.size()).isEqualTo(0);
    }


    @Transactional
    @Test
    public void testFindPatientsWithDiscount() {
        // given
        // when
        List<PatientEntity> patientsWithDiscount = patientDao.findPatientsWithDiscount();
        // then
        assertThat(patientsWithDiscount.size()).isEqualTo(3); // 5 patients in db - 2 without discount
    }

}
