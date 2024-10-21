package calculator;


import java.util.Arrays;

public class StringFilter {
    final String baseDelimiter = "[,|:]";
    String customDelimiter = "";

    public String[] checkString(String input) {
        input = input.replaceAll(" ", "");

        if(input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }

        if(input.contains("//") && input.contains("\\n")) {
            return customDelimiterCheck(input);
        }
        return filteringString(input);
    }

    private String[] customDelimiterCheck(String input) {
        if(input.indexOf("//") > input.indexOf("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
        }
        customDelimiter = input.substring(input.indexOf("//")+2, input.indexOf("\\n"));
        return filteringString(input);
    }

    private String[] filteringString(String input) {
        String replaceInput = input.replace("//","").replace("\\n", "");
        return Arrays.stream(replaceInput.split(baseDelimiter))
                .flatMap(part -> Arrays.stream(part.split(customDelimiter)))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

    }
}
