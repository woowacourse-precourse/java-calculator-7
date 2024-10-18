package calculator.service;

public class Parser {

    public String[] parse(String input) {

        // 빈 문자열 혹은 null 값이 들어올 경우
        if (input == null || input.isEmpty()) {
            // 0 반환해야 함
            return new String[]{"0"};
        }

        return input.split(",|:");
    }
}
