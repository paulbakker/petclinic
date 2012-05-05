package example.dao.jpa;

import example.dao.Clinic;
import example.entities.*;
import example.interceptors.CountUsage;
import org.springframework.dao.DataAccessException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * EJB version of the JPA implementation of the Clinic interface using EntityManager.
 *
 */
@Stateless
public class EntityManagerClinic implements Clinic {

	@PersistenceContext
	private EntityManager em;


	public Collection<Vet> getVets() {
		return this.em.createQuery("SELECT vet FROM Vet vet ORDER BY vet.lastName, vet.firstName", Vet.class).getResultList();
	}

	public Collection<PetType> getPetTypes() {
		return this.em.createQuery("SELECT ptype FROM PetType ptype ORDER BY ptype.name", PetType.class).getResultList();
	}

    @CountUsage
    public Collection<Owner> findOwners(String lastName) {
		TypedQuery<Owner> query = this.em.createQuery("SELECT owner FROM Owner owner WHERE owner.lastName LIKE :lastName", Owner.class);
		query.setParameter("lastName", lastName + "%");
        System.out.println("should be intercepted...");
		return query.getResultList();
	}

	public Owner loadOwner(int id) {
		return this.em.find(Owner.class, id);
	}

	public Pet loadPet(int id) {
		return this.em.find(Pet.class, id);
	}

	public void storeOwner(Owner owner) {
		// Consider returning the persistent object here, for exposing
		// a newly assigned id using any persistence provider...
		Owner merged = this.em.merge(owner);
		this.em.flush();
		owner.setId(merged.getId());
	}

	public void storePet(Pet pet) {
		// Consider returning the persistent object here, for exposing
		// a newly assigned id using any persistence provider...
		Pet merged = this.em.merge(pet);
		this.em.flush();
		pet.setId(merged.getId());
	}

	public void storeVisit(Visit visit) {
		// Consider returning the persistent object here, for exposing
		// a newly assigned id using any persistence provider...
		Visit merged = this.em.merge(visit);
		this.em.flush();
		visit.setId(merged.getId());
	}

	public void deletePet(int id) throws DataAccessException {
		Pet pet = loadPet(id);
		this.em.remove(pet);
	}

}
