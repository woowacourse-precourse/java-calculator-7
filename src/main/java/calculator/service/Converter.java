package calculator.service;

import calculator.model.Operand;

public class Converter {

    public Operand convertToOperand(String operandString) {

        try {
            Operand operand = new Operand(Long.parseLong(operandString));

            if (!operand.isPositiveNumber()) {
                throw new IllegalArgumentException("입력 숫자가 양수가 아닙니다.");
            }
            return operand;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("커스텀 구분자, 숫자 외 다른 문자가 존재합니다.");
        }
    }
}
