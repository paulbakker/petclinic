package example.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface CountUsage {
}
