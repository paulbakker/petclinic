package example.jsf;

import example.dao.Clinic;
import example.entities.Owner;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Named
@RequestScoped
public class OwnerController {
    @Inject
    Clinic clinic;

    private String lastname;
    private Collection<Owner> owners;

    @PostConstruct
    public void initOwners() {
        owners = clinic.findOwners("");
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
            owners = clinic.findOwners(lastname);

        this.lastname = lastname;
    }

    public Collection<Owner> getOwners() {
        return owners;
    }
}
