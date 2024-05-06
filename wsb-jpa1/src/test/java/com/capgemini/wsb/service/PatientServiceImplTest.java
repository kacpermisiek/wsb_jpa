package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.PatientWithVisitsTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.dao.impl.DoctorDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDaoImpl doctorDao;

    @Autowired
    private PatientDao patientDao;

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
    public void testDeletePatientShouldNotDeleteAllVisitsAndDoctors() {

        // given
        assertThat(patientDao.count()).isEqualTo(4);
        assertThat(visitDao.count()).isEqualTo(4);
        assertThat(doctorDao.count()).isEqualTo(5);

        // when
        patientService.deletePatient(1L);

        // then
        assertThat(patientDao.count()).isEqualTo(3);
        assertThat(visitDao.count()).isEqualTo(2);
        assertThat(doctorDao.count()).isEqualTo(5);
    }


    @Transactional
    @Test
    public void testFindPatientByIDShouldReturnTOsStructure() {
        // given
        // when
        PatientWithVisitsTO patientTO = patientService.findById(1L);
        Collection<VisitTO> visits = patientTO.getVisits();

        // then
        assertThat(visits).isNotNull();
        assertThat(visits.size()).isEqualTo(2);

        VisitTO firstVisit = visits.iterator().next();
        assertThat(firstVisit.getDoctor().getFirstName()).isEqualTo("Krzysztof");
        assertThat(firstVisit.getDoctor().getLastName()).isEqualTo("Nowak1");
        assertThat(firstVisit.getPatient().getPatientNumber()).isEqualTo(patientTO.getPatientNumber());

        assertThat(patientTO.isAdult()).isEqualTo(false);

    }
}
