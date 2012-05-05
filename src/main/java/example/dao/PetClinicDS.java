package example.dao;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface PetClinicDS {
}
