package calculator;

public class DelimiterValidator {
    public String getCustomDelimiter(String input) {
        //커스텀 구분자가 있다면 반환, 없다면 "" 반환
        String result = "";
        if (input.matches("//.\\\\n.*")) {
            result = input.substring(2, 3);
        }

        return result;
    }
}
