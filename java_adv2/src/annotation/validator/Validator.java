package annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object target) throws IllegalAccessException {
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotEmpty.class)) {
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                String value = (String) field.get(target); // String case
                if (value == null || value.isEmpty()) {
                    throw new RuntimeException(annotation.message());
                }
            }
            if (field.isAnnotationPresent(Range.class)) {
                Range annotation = field.getAnnotation(Range.class);
                long value = field.getLong(target);
                if (value < annotation.min() || value > annotation.max()) {
                    throw new RuntimeException(annotation.message());
                }
            }
        }
    }
}
