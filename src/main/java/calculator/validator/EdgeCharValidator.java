package calculator.validator;

public class EdgeCharValidator {
    public EdgeCharValidator(String input) {
        if(input.charAt(0) != '/') validateEdgeChar(input);
        if(input.charAt(0) == '/') validateEdgeChar(input.substring(5));
    }

    private void validateEdgeChar(String input) {
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(input.length() - 1);

        if (!Character.isDigit(firstChar)) {
            throw new IllegalArgumentException("첫 문자가 숫자가 아닙니다.");
        }

        if (!Character.isDigit(lastChar)) {
            throw new IllegalArgumentException("마지막 문자가 숫자가 아닙니다.");
        }
    }


}
