package example.jsf;

import example.dao.Clinic;
import example.entities.Vet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Named
@RequestScoped
public class VetsController {

    @Inject
    private Clinic clinic;

    public Collection<Vet> getVets() {
       return clinic.getVets();
    }
}
