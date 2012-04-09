package example.jsf;

import example.dao.Clinic;
import example.entities.PetType;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@FacesConverter("petTypeConverter")
@RequestScoped
public class PetTypeConverter implements Converter {
    @Inject
    Clinic clinic;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        System.out.println(s);
        for (PetType type : clinic.getPetTypes()) {
            if(type.getName().equals(s)) {
                System.out.println("Returning " + type.getId());
                return type;
            }
        }
       throw new ConverterException("Couldn't find pet type: " + s);
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        PetType petType = (PetType) o;
        System.out.println("String of " + petType.getId());
        return petType.getName();
    }
}
