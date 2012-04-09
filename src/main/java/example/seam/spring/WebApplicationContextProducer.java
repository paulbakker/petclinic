package example.seam.spring;

import org.jboss.seam.spring.context.Configuration;
import org.jboss.seam.spring.context.SpringContext;
import org.jboss.seam.spring.inject.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.samples.petclinic.dao.ClinicReporting;

import javax.enterprise.inject.Produces;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */

public class WebApplicationContextProducer {
    @Produces
    @SpringContext
    @Configuration(locations = "classpath:applicationContext-jpa.xml")
    ApplicationContext context;

    @Produces
    @SpringBean
    ClinicReporting clinicReporting;
}
