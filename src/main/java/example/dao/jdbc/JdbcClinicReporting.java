package example.dao.jdbc;

import example.dao.ClinicReporting;
import example.dao.PetClinicDS;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Date;

public class JdbcClinicReporting implements ClinicReporting{
    @Inject @PetClinicDS
    DataSource ds;

    @PostConstruct
    public void setup() {
        simpleJdbcTemplate = new SimpleJdbcTemplate(ds);
        System.out.println("creating jdbc template using provider");
    }

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public int countVisitsAtDate(Date date) {
        return simpleJdbcTemplate.queryForInt("select count(*) from visits where visit_date = ?", date);
    }
}
