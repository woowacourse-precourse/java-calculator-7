package calculator.validation;

import static calculator.constant.ErrorMessage.INVALID_INPUT;

import calculator.model.StringExpression;

public class ExpressionValidator implements Validator {
    @Override
    public void validate(Object target) {
        if (!(target instanceof StringExpression)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        StringExpression expression = (StringExpression) target;
        if (expression.split().length == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
