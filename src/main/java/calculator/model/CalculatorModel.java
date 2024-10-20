package calculator.model;

import java.math.BigInteger;

public class CalculatorModel {
    public int getResult(String[] digits) {
        int result = 0;
        for (String val : digits) {
            int intVal;
            if (val.isEmpty()) {
                intVal = 0;
            } else {
                intVal = exception(val);
            }
            result += intVal;
        }
        return result;
    }

    public int exception(String val) {
        int intVal;

        try {
            intVal = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            try {
                BigInteger bigVal = new BigInteger(val);
                if (bigVal.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                    throw new IllegalArgumentException("너무 큰 수를 입력했습니다.");
                }
            } catch (NumberFormatException bigE) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }


        if (Integer.parseInt(val) <= 0) {
            throw new IllegalArgumentException("음수, 0 사용 불가");
        }
        return intVal;
    }
}
