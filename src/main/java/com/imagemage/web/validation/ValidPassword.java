package com.imagemage.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ValidPassword {
    String message() default "Invalid password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
