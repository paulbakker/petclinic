package org.springframework.samples.petclinic.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.samples.petclinic.dao.ClinicReporting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Date;

@Service
@Transactional
public class JdbcClinicReporting implements ClinicReporting{
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public int countVisitsAtDate(Date date) {
        return simpleJdbcTemplate.queryForInt("select count(*) from visits where visit_date = ?", date);
    }

    @Autowired
    public void init(DataSource ds) {
        simpleJdbcTemplate = new SimpleJdbcTemplate(ds);
    }
}
