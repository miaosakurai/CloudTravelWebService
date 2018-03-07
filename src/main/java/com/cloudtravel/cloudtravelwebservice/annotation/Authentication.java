package com.cloudtravel.cloudtravelwebservice.annotation;




import com.cloudtravel.cloudtravelwebservice.dto.Role;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {
    Role[] value() default {Role.User, Role.Admin};
}
