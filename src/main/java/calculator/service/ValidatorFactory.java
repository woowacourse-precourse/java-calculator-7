package calculator.service;

import static calculator.constant.ErrorMessage.WRONG_VALIDATOR;

import calculator.model.StringExpression;
import calculator.validation.ExpressionValidator;
import calculator.validation.NumberValidator;
import calculator.validation.Validator;
import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private static final Map<Class<?>, Validator> validators = new HashMap<>();

    static {
        validators.put(StringExpression.class, new ExpressionValidator());
        validators.put(Integer.class, new NumberValidator());
    }

    public static Validator getValidator(Class<?> clazz) {
        Validator validator = validators.get(clazz);
        if (validator == null) {
            throw new IllegalArgumentException(WRONG_VALIDATOR + clazz.getSimpleName());
        }
        return validator;
    }
}
