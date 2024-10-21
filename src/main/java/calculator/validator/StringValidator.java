package calculator.validator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringValidator {

    public String[] checkDelimiter(String input) {
        String basicDelimiter = ",|:";

        if (input.startsWith("//")) {
            int deliEnd = input.indexOf("\\n");
            if (deliEnd != -1) {
                String customDelimiter = input.substring(2, deliEnd);

                if (customDelimiter.equals("-")) {
                    System.out.println("본 계산기는 양수 덧셈만을 지원합니다. 해당 값은 구분자로만 처리됩니다.");
                }

                String delimiters = basicDelimiter + "|" + Pattern.quote(customDelimiter);
                input = input.substring(deliEnd + 2);
                return input.split(delimiters);
            }
        }
        return input.split(basicDelimiter);
    }


    public List<BigDecimal> checkNumber(String[] nums) {
        List<BigDecimal> list = new ArrayList<>();
        String regex = "^(\\d+(\\.\\d+)?|\\d+/\\d+|sqrt\\(\\d+(\\.\\d+)?\\)|pi|e)$";

        for (String stringNumber : nums) {
            if (stringNumber.isEmpty()) {
                continue;
            } else if (!stringNumber.matches(regex) || stringNumber.equals("0")) {
                throw new IllegalArgumentException("입력 문자열이 바르지 않습니다.");
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

            if (num.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException();
            }
            list.add(num);
        }
        return list;
    }

    public BigDecimal sumNumber(List<BigDecimal> numbers) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
