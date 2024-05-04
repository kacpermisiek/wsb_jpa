package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class PatientWithVisitsTO extends PatientTO implements Serializable {
    private Collection<VisitTO> visits;

    public Collection<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(Collection<VisitTO> visits) {
        this.visits = visits;
    }
}
