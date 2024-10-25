// DelimiterParser.java
package calculator.model;

public class DelimiterParser {
    public String parseDelimiter(String input) {
        if (input.startsWith("//")) {
            return String.valueOf(input.charAt(2)); // 구분자로 설정된 첫 번째 문자
        }
        return ","; // 기본 구분자
    }

    public String[] splitNumbers(String input, String delimiter) {
        // "//;\\n1"와 같은 입력을 다룰 수 있도록 처리
        String numbersPart = input.contains("\n") ? input.split("\n")[1] : input;
        return numbersPart.split(delimiter);
    }
}
