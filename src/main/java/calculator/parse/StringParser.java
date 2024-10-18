package calculator.parse;

import static calculator.constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.constants.DelimiterConstants.CUSTOM_DELIMITER_START;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    public String getCustomDelimiter(String input) {
        int endIndex = input.indexOf(CUSTOM_DELIMITER_END);
        return input.substring(2, endIndex);
    }

    public int[] convertStringToIntArray(String input) {
        int startIndex = 0;
        if (input.startsWith(CUSTOM_DELIMITER_START)) { // 커스텀 구분자가 있는 경우
            startIndex = input.indexOf(CUSTOM_DELIMITER_END) + 2; // 그 이후부터 탐색하도록 인덱스 조정
        }

        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder(); // 현재 숫자를 임시로 저장하는 StringBuilder

        for (int i = startIndex; i < input.length(); i++) {
            char currentChar = input.charAt(i); // 현재 인덱스의 문자

            if (Character.isDigit(currentChar)) { // 현재 문자가 숫자일 경우, currentNumber(버퍼) 에 추가
                currentNumber.append(currentChar);
            } else { // 숫자가 아닌 문자가 등장했을 경우, 버퍼에 있던것을 리스트에 추가
                int number = Integer.parseInt(currentNumber.toString());
                numbers.add(number);
                currentNumber.setLength(0); // StringBuilder 초기화
            }
        }

        // 버퍼에 남아있는 것 추가
        if (!currentNumber.isEmpty()) {
            int number = Integer.parseInt(currentNumber.toString());
            numbers.add(number);
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
