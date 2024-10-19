package calculator.utils;

import calculator.operator.AddOperator;
import calculator.operator.Operator;
import calculator.operator.OperatorRepository;

public class Preprocessor {

    private OperatorRepository operatorRepository;
    private ExpressionValidator expressionValidator;

    public Preprocessor(String expression, OperatorRepository operatorRepository, String defaultSeparators) {
        this.operatorRepository = operatorRepository;
        this.expressionValidator = new ExpressionValidator(expression, defaultSeparators);
    }

    public String preprocess() {
        if (!isValid()) { // expression 유효성 검사
            throw new IllegalArgumentException();
        }
        String separators = expressionValidator.getSeparators();
        separators.chars().forEach(ch -> { // 구분자, 연산자 매핑 등록
            addOperators(String.valueOf((char) ch), AddOperator.getInstance());
        });
        return expressionValidator.getExpression();
    }

    private void addOperators(String separator, Operator operator) {
        operatorRepository.addOperator(separator, operator);
    }

    private boolean isValid() {
        return expressionValidator.isValid();
    }
}
