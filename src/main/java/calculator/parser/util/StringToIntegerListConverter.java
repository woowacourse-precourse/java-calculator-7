package calculator.parser.util;

import calculator.exception.ErrorStatus;
import calculator.exception.ExceptionUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringToIntegerListConverter {

    public List<Integer> convert(List<String> targets) {
        List<String> copyTargets = new ArrayList<>(targets);
        copyTargets.removeIf(String::isEmpty);

        List<Integer> numbers = new ArrayList<>();
        for (String target : copyTargets) {
            validate(target);
            numbers.add(Integer.parseInt(target));
        }
        return numbers;
    }

    private void validate(String target) {
        if (target.matches(".*\\D.*")) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.INVALID_INPUT);
        }
        BigInteger number = new BigInteger(target);
        if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.TOO_BIG_NUMBER);
        }
        if (number.compareTo(BigInteger.ZERO) == 0) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.ZERO_NOT_ALLOWED);
        }
    }
}
