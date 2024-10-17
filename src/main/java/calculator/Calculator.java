package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 기본 구분자
    List<String> separators = List.of(",", ":");

    public int run(String input) {
        input = findCustomSeparator(input);
//        List<String> separators = List.of(",", ":", numberStringAndCustomSeparator.get(1));
//        String numberString = numberStringAndCustomSeparator.get(0);
//
//        List<Integer> numbers = getNumber(numberString, separators);
//        int result = sumNumbers(numbers);
//
//        return result;
    }

    /**
     * 커스텀 구분자를 찾는 메서드
     *
     * @return 커스텀 구분자를 제외한 String
     */
    public String findCustomSeparator(String input) {
        while (hasCustomSeparator(input)) {
            input = extractCustomSeparator(input);
        }

        return input;
    }

    /**
     * 커스텀 구분자가 있는지 검사하는 메서드
     *
     * @return boolean
     */
    private boolean hasCustomSeparator(String input) {

        if (!input.contains("//")) {
            return false;
        }

        if (input.indexOf("//") > 0 || !input.contains("\\n")) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    /**
     * 맨 앞 커스텀 구분자를 추출하여 빼 separators에 저장하고, 커스텀 구분자를 뺸 문자열을 반환하는 메서드
     *
     * @return 맨 앞의 커스텀 구분자를 뺀 문자열
     */
    private String extractCustomSeparator(String input) {
        int customSeparatorEnd = input.indexOf("\\n");
        String customSeparator = input.substring(2, customSeparatorEnd);
        separators.add(customSeparator);
        return input.substring(customSeparatorEnd + 2);
    }

    // 구분자로 문자열에서 숫자 추출
    public List<Integer> getNumber(String numberString, List<String> separators) {
        // numberString이 공백이면 0으로 간주
        if (numberString.isBlank()) {
            return List.of(0);
        }

        List<Integer> result = new ArrayList<>();

        // split으로 구분자 기준으로 숫자만 추출
        String[] numbers = numberString.split(separators.toString());

        // parseInt를 사용해서 String 숫자를 int로 변환
        // 숫자가 아닐경우 NumberFormatException이 발생함 -> IllegalArgumentException를 throw
        for (String number : numbers) {
            int numberInt;
            try {
                numberInt = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (numberInt < 0) {
                throw new IllegalArgumentException();
            }

            result.add(numberInt);
        }

        return result;
    }

    // 숫자 합 계산
    public int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result = result + number;
        }
        return result;
    }

}
