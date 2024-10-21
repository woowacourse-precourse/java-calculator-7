package calculator.numberExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberExtractorImpl implements NumberExtractor {

    @Override
    public List<Integer> extract(String str, Set<Character> separators) {
        int currentNumber = 0;
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (separators.contains(currentChar)) {
                numberList.add(currentNumber);
                currentNumber = 0;
            } else {
                if (!Character.isDigit(currentChar)) {
                    throw new IllegalArgumentException("입력된 문자열에 구분자와 숫자가 아닌 문자가 포함되어 있습니다.");
                }

                int digit = Character.getNumericValue(currentChar);
                if (currentNumber > (Integer.MAX_VALUE - digit) / 10) {
                    throw new IllegalArgumentException("입력된 문자열에 입력 최대값을 넘는 숫자가 포함되어 있습니다.");
                }

                currentNumber = currentNumber * 10 + digit;
            }
        }

        numberList.add(currentNumber);

        return numberList;
    }
}
