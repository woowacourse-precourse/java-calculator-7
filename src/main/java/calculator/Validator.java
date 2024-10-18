package calculator;

public class Validator {

    public static String validateInput(String input) {
//        if ()
//            throw new IllegalArgumentException("");
        if (input.length() > 4) { //TODO 더 좋은 조건?
            input = separateCustomDelimiter(input);
        }
        if (isInvalidCharacter(input)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
        return input;
    }

    private static String separateCustomDelimiter(String input) {
        if (input.substring(0, 2).equals("//") && input.contains("\\n")) {
            Delimiter.extractDelimiter(input);
            input = input.substring(input.indexOf("\\n") + 2, input.length());
        }
        return input;
    }

    private static boolean isInvalidCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!validateCharacter(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateCharacter(char c) {
        return Character.isDigit(c) || Delimiter.delimiter.indexOf(c) != -1;
    }
}
