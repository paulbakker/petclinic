package example.jsf;

import example.dao.Clinic;
import example.entities.Owner;
import example.entities.Pet;
import example.entities.PetType;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Named
@ConversationScoped
public class OwnerDetailsController implements Serializable {
    @Inject
    transient Clinic clinic;

    @Inject
    Conversation conversation;



    private boolean edit = false;
    private Owner owner;
    private Pet pet;

    public String showOwner(Owner owner) {
        conversation.begin();
        this.owner = owner;

        return "showowner.xhtml";
    }

    public Owner getOwner() {
        return owner;
    }

    public void edit() {
        edit = true;
    }

    public void save() {
        clinic.storeOwner(owner);
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public Pet getPet() {
        return pet;
    }

    public String newPet() {
        pet = new Pet();
        owner.addPet(pet);
        return "editpet.xhtml";
    }
    
    public String editPet(Pet pet) {
        this.pet = pet;
        return "editpet.xhtml";
    }

    public Collection<PetType> getPetTypes() {
        return clinic.getPetTypes();
    }

    public String savePet() {
        clinic.storePet(pet);
        return "showowner.xhtml?faces-redirect=true";
    }

    public String toOverview() {
        conversation.end();
        return "findowner.xhtml?faces-redirect=true";
    }

    @Inject PetTypeConverter petTypeConverter;

    public PetTypeConverter getPetTypeConverter() {
        return petTypeConverter;
    }
}
