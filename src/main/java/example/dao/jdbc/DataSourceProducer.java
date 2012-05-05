package example.dao.jdbc;

import example.dao.PetClinicDS;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
public class DataSourceProducer {
    @Produces @PetClinicDS
    @Resource(mappedName = "petclinic")
    DataSource ds;
}
