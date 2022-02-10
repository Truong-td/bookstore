package com.truongtd.bookstore.api.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = EqualFields.EqualFieldsValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface EqualFields {

    String message() default "{error.matchField}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};

    String baseField();

    String matchField();

    class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

        private String baseField;
        private String matchField;

        @Override
        public void initialize(EqualFields constraint) {
            baseField = constraint.baseField();
            matchField = constraint.matchField();
        }

        @Override
        public boolean isValid(Object object, ConstraintValidatorContext context) {
            try {
                Object baseFieldValue = getFieldValue(object, baseField);
                Object matchFieldValue = getFieldValue(object, matchField);
                if (baseFieldValue != null && matchFieldValue != null
                        && !baseFieldValue.equals(matchFieldValue)) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(matchField + " does not match")
                            .addPropertyNode(matchField).addConstraintViolation();
                    return false;
                }

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private Object getFieldValue(Object object, String fieldName) throws Exception {
            Class<?> clazz = object.getClass();
            Field passwordField = clazz.getDeclaredField(fieldName);
            passwordField.setAccessible(true);
            return passwordField.get(object);
        }

    }
}
