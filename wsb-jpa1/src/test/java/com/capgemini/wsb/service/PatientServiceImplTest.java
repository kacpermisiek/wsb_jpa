package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patientTO = patientService.findById(1L);
        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("Jan");
        assertThat(patientTO.getLastName()).isEqualTo("Kowalski1");
        assertThat(patientTO.getDateOfBirth()).isEqualTo("1990-01-01");
        assertThat(patientTO.getEmail()).isEqualTo("elo.cotam@wp.pl");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("123456789");
        assertThat(patientTO.getPatientNumber()).isEqualTo("123456789");
    }


    @Transactional
    @Test
    public void testDeletePatientShouldNotDeleteAllVisits() {
        // given
        Long numOfVisitsBefore = visitDao.count();
        // when
        patientService.deletePatient(1L);
        // then
        assertThat(patientService.findById(1L)).isNull();
        assertThat(visitDao.count()).isEqualTo(numOfVisitsBefore);
    }

}
