package calculator.stringSplitter;

import java.util.List;

public class InputValidator {

    public void checkLastCharIsDigit(String input){
        if (!isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("마지막은 숫자로 입력해주세요.");
        }
    }

    public void validateCustomSeparatorInput(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("\\n가 없다면 커스텀 구분자를 사용할 수 없습니다.");
        }
    }

    public void validateSeparators(String customSeparators) {
        validateNoDigits(customSeparators);
        validateNoWhitespace(customSeparators);
    }

    private void validateNoWhitespace(String customSeparators){
        for(char c: customSeparators.toCharArray()){
            if(isWhitespace(c)){
                throw new IllegalArgumentException("구분자에는 빈칸이 불가능합니다.");
            }
        }
    }


    private void validateNoDigits(String customSeparators){
        for(char c : customSeparators.toCharArray()){
            if(isDigit(c)){
                throw new IllegalArgumentException("구분자에는 숫자가 들어갈 수 없습니다.");
            }
        }
    }

    public void validateInput(List<String> separators, String number) {
        for (char c : number.toCharArray()) {
            if (!isDigit(c) && !isContains(separators, c)) {
                throw new IllegalArgumentException("허용되지 않은 구분자입니다.");
            }
        }
    }

    private boolean isContains(List<String> separators, char c) {
        return separators.contains(String.valueOf(c));
    }

    private static boolean isWhitespace(char c) {
        return Character.isWhitespace(c);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
