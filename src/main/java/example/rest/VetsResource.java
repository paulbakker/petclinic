package example.rest;

import example.dao.Clinic;
import example.entities.Vet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Path("vets")
@Stateless
public class VetsResource {
    @Inject
    Clinic clinic;

    @Produces({"application/xml", "application/json"})
    @GET
    public Collection<Vet> listVets() {
        return clinic.getVets();
    }
}
