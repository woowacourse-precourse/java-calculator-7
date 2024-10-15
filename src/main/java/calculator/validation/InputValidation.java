package calculator.validation;

public class InputValidation {

    // 모든 검증을 통과하면 리턴한다.
    public static String readInputValidation(String input) {
        SeparatorValidation.separator(input);
        AlphabetValidation.alphabet(input);
        NumberValidation.number(input);
        return input;
    }
}
