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
        CheckValid.checkContinuousDelimiters(input);
        return input.split(delimiter);
    }
}
