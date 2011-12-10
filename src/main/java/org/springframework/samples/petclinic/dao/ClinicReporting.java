package org.springframework.samples.petclinic.dao;

import java.util.Date;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
public interface ClinicReporting {
    public int countVisitsAtDate(Date date);
}
