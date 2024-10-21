package calculator.stringcalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class StringValidator {

    public List<BigDecimal> checkNumber(String[] nums) {

        List<BigDecimal> list = new ArrayList<>();
        String regex = "^(\\d+(\\.\\d+)?|\\d+/\\d+|sqrt\\(\\d+(\\.\\d+)?\\)|pi|e)$";

        for (String stringNumber : nums) {
            if (stringNumber.isEmpty()) {
                continue;
            } else if (!stringNumber.matches(regex) || stringNumber.equals("0")) {
                throw new IllegalArgumentException("입력 값이 바르지 않습니다.");
            }

            BigDecimal num;
            if (stringNumber.startsWith("sqrt(") && stringNumber.endsWith(")")) {
                String innerNumber = stringNumber.substring(5, stringNumber.length() - 1);
                num = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(innerNumber)));
            } else if (stringNumber.contains("/")) {
                String[] fractionParts = stringNumber.split("/");
                if (fractionParts.length != 2) {
                    throw new IllegalArgumentException("잘못된 분수 형식입니다.");
                }
                BigDecimal numerator = new BigDecimal(fractionParts[0]);
                BigDecimal denominator = new BigDecimal(fractionParts[1]);
                if (denominator.equals(BigDecimal.ZERO)) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                num = numerator.divide(denominator, MathContext.DECIMAL128);
            } else if (stringNumber.equalsIgnoreCase("pi")) {
                num = new BigDecimal(Math.PI);
            } else if (stringNumber.equalsIgnoreCase("e")) {
                num = new BigDecimal(Math.E);
            } else {
                num = new BigDecimal(stringNumber);
            }

            if (num.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("입력 값이 바르지 않습니다.");
            }
            list.add(num);
        }
        return list;
    }
}
