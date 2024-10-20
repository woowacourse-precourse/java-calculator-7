package calculator.helper;

import java.lang.reflect.Field;

class ReflectionUtil {
    static void forceSetField(Class<?> clazz, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.trySetAccessible();
            field.set(field, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
