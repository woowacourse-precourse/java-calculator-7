package calculator.parse;

import static calculator.constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.constants.DelimiterConstants.CUSTOM_DELIMITER_START;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final int DELIMITER_OFFSET = 2;

    public String getCustomDelimiter(String input) {
        int endIndex = input.indexOf(CUSTOM_DELIMITER_END);
        return input.substring(2, endIndex);
    }

    public int[] convertStringToIntArray(String input) {
        int startIndex = 0;
        if (input.startsWith(CUSTOM_DELIMITER_START)) { // 커스텀 구분자가 있는 경우
            startIndex = input.indexOf(CUSTOM_DELIMITER_END) + DELIMITER_OFFSET; // 그 이후부터 탐색하도록 인덱스 조정
        }

        List<Integer> numbers = new ArrayList<>();
        StringBuilder buffer = new StringBuilder(); // 현재 숫자를 임시 저장하는 버퍼 StringBuilder

        for (int i = startIndex; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                buffer.append(currentChar);
                continue;
            }

            // 숫자가 아니라면 버퍼에 있던것을 리스트에 추가
            int currentNumber = Integer.parseInt(buffer.toString());
            numbers.add(currentNumber);
            buffer.setLength(0); // 버퍼 초기화
        }

        // 버퍼에 남아있는 것 추가
        if (!buffer.isEmpty()) {
            int number = Integer.parseInt(buffer.toString());
            numbers.add(number);
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
