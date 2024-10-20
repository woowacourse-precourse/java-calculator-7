package calculator;

public class SplitInput {

    static String refine(String input) {
        // 커스텀 구분자의 시작과 끝 분리
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }
        return input;
    }

    static String[] split(String input, String delimiter) {

        String[] numbers = input.split(delimiter);

        CheckValid.checkContinuousDelimiters(numbers);

        // 각 숫자 항목을 검증하고 유효하지 않은 값 처리
        for (String num : numbers) {
            CheckValid.isValidString(num);
        }
        return numbers;
    }
}
