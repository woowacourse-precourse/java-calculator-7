package calculator.validator;

import java.util.HashSet;
import java.util.Set;

public class ParserValidator {

    private Set<String> separatorSet = new HashSet<>();

    public boolean isCustomSeparator(int inputSeparatorArraySize) {
        if (inputSeparatorArraySize < 2) {
            return false;
        } else if (inputSeparatorArraySize > 2) {
            throw new IllegalArgumentException("구분자 형식이 중복 입력되었습니다.");
        }
        return true;
    }

    public boolean isOnlySeparator(String numberString) {
        if (numberString.matches("^\\d.*")) {
            return false;
        }
        return true;
    }

    private boolean isSeparatorNumber(int inputSeparatorASCIIIndex) {
        if (inputSeparatorASCIIIndex >= 48 && inputSeparatorASCIIIndex <= 57) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
        }
        return false;
    }

    public boolean isValidSeparator(String separators) {
        for (int inputSeparatorListIndex = 0; inputSeparatorListIndex < separators.length();
             inputSeparatorListIndex++) {
            char separator = separators.charAt(inputSeparatorListIndex);
            int separatorASCIIIndex = (int) separator;
            if (isSeparatorNumber(separatorASCIIIndex)) {
                return false;
            }
            if (isDuplicatedSeparator(String.valueOf(separator))) {
                return false;
            }
            separatorSet.add(String.valueOf(separator));
        }
        return true;
    }

    private boolean isDuplicatedSeparator(String separator) {
        if (separatorSet.contains(separator)) {
            throw new IllegalArgumentException("구분자가 중복되어 입력되었습니다.");
        }
        return false;
    }
}
