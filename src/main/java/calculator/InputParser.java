package calculator;

public class InputParser {
    public ParsedInput parse(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2);  // 커스텀 구분자 추출
            String numbers = parts[1];                 // 숫자 부분 추출
            return new ParsedInput(numbers, delimiter);
        }
        return new ParsedInput(input, "[,|:]");        // 기본 구분자
    }
}
