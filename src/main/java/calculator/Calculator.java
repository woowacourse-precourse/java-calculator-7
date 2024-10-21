package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final int CUSTOM_DELIMITER_POS = 2;
    private static final int CUSTOM_DELIMITER_LENGTH = 5;

    public boolean isValidInput(String input) {
        if (input.isEmpty()) {
            return true;
        }

        List<Character> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add((char) (i + '0'));
        }

        List<Character> delimeterList = new ArrayList<>();
        delimeterList.add(',');
        delimeterList.add(':');

        String calculateZone = input;
        if (hasCustomDelimiter(input)) {
            delimeterList.add(input.charAt(CUSTOM_DELIMITER_POS));

            if (input.length() <= CUSTOM_DELIMITER_LENGTH) {
                return false;
            }

            calculateZone = input.substring(CUSTOM_DELIMITER_LENGTH);
        }

        for (int i = 0; i < calculateZone.length(); i++) {
            if (delimeterList.contains(calculateZone.charAt(i))) { // 구분자인 경우
                if (!(i >= 1 && numList.contains(calculateZone.charAt(i - 1)))) { // 왼쪽에 숫자가 존재하는 경우를 제외하고 모두 Invalid
                    return false;
                }
                if (!(i + 1 < calculateZone.length() && numList.contains(calculateZone.charAt(i + 1)))) { // 오른쪽에 숫자가 존재하는 경우를 제외하고 모두 Invalid
                    return false;
                }
            } else if (!numList.contains(calculateZone.charAt(i))){ // 구분자가 아닌 경우, 숫자 외의 입력 값이 있으면 안된다.
                return false;
            }
        }

        return true;
    }

    public BigInteger add(String input) {
        if (input.isEmpty()) {
            return BigInteger.ZERO;
        }

        List<Character> delimeterList = new ArrayList<>();
        delimeterList.add(',');
        delimeterList.add(':');

        String calculateZone = input;
        if (hasCustomDelimiter(input)) {
            delimeterList.add(input.charAt(CUSTOM_DELIMITER_POS));
            calculateZone = input.substring(CUSTOM_DELIMITER_LENGTH);
        }

        int startIndex = 0;
        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < calculateZone.length(); i++) {
            if (delimeterList.contains(calculateZone.charAt(i))) {
                total = total.add(new BigInteger(calculateZone.substring(startIndex, i)));
                startIndex = i + 1;
            }
        }
        total = total.add(new BigInteger(calculateZone.substring(startIndex)));

        return total;
    }

    private boolean hasCustomDelimiter(String input) {
        if (input.length() < CUSTOM_DELIMITER_LENGTH) {
            return false;
        }

        String substring1 = input.substring(0, CUSTOM_DELIMITER_POS);
        String substring2 = input.substring(CUSTOM_DELIMITER_POS + 1, CUSTOM_DELIMITER_LENGTH);

        return (substring1.equals("//") && substring2.equals("\\n"));
    }
}
