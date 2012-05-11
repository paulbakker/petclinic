package example.jmx;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface JMXBean {
    @Nonbinding String objectName() default "";
}
