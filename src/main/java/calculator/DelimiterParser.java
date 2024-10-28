package calculator;

public class DelimiterParser {

    public String[] split(String input) {
        if (input.startsWith("//")) {
            return splitWithCustomDelimiter(input);
        }
        return input.split("[,:]");
    }

    private String[] splitWithCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");

        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }

        String customDelimiter = input.substring(2, delimiterIndex);
        customDelimiter = customDelimiter.replace("\\", "\\\\");
        
        String numbers = input.substring(delimiterIndex + 2);
        return numbers.split(customDelimiter);
    }
}