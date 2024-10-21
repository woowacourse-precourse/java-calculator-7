package calculator.service;

import calculator.exception.CustomException;
import calculator.exception.ErrorCode;
import java.util.HashSet;

public class OperatorService {
    public HashSet<String> operators;

    public OperatorService(HashSet<String> operators) {
        this.operators = operators;
    }

    public static OperatorService initializeDefaultOperator() {
        HashSet<String> operators = new HashSet<>();
        operators.add(",");
        operators.add(":");
        return new OperatorService(operators);
    }

    public void indexingOperators(String[] expression) {
        int idx = 0;
        while (idx < expression.length) {
            if (!Character.isDigit(expression[idx].charAt(0))) {
                validateOperator(expression, idx);
            }
            idx++;
        }
    }

    public void validateOperator(String[] expression, int idx) {
        if (idx > 0 && !Character.isDigit(expression[idx - 1].charAt(0))) {
            throw new CustomException(ErrorCode.INVALID_OPERATOR, "연속된 구분자는 사용할 수 없습니다.");
        }
        if (!this.operators.contains(expression[idx])) {
            throw new CustomException(ErrorCode.INVALID_OPERATOR, "유효하지 않은 구분자입니다.");
        }
    }

    public String extractCustomOperators(String expression) {
        int startIndex = 0;

        while ((startIndex = expression.indexOf("//", startIndex)) != -1) {
            int endIndex = expression.indexOf("\\n", startIndex);
            if (endIndex != -1) {
                String customOperator = expression.substring(startIndex + 2, endIndex);
                this.operators.add(customOperator);
                expression = expression.replace("//" + customOperator + "\\n", "");
                startIndex = endIndex;
            } else {
                break;
            }
        }
        return expression;
    }
}
