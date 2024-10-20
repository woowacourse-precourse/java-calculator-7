package calculator.validator;

import calculator.exception.FactorException;

public class FactorValidator {

    private FactorValidator() {}

    public static int validateFactor(String factor) {
        int number;

        try{
            number = Integer.parseInt(factor);

            if(number < 0) {
                throw new FactorException("입력 값에 음수가 존재합니다.");
            }

        } catch (NumberFormatException e) {
            throw new FactorException("숫자가 아닌 요소가 있습니다.");
        }

        return number;
    }

}
