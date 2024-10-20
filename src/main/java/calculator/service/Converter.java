package calculator.service;

import calculator.model.Operand;

public class Converter {

    public long convertToOperand(String operandString) {

        try {
            long num = Long.parseLong(operandString);

            if (num <= 0) {
                throw new IllegalArgumentException("입력 숫자가 양수가 아닙니다.");
            }
            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("커스텀 구분자, 숫자 외 다른 문자가 존재합니다.");
        }
    }
}
