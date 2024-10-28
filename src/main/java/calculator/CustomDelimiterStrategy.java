package calculator;

public class CustomDelimiterStrategy implements DelimiterStrategy {

    @Override
    public String[] splitNumbers(String input) {
        String[] parts = input.split("\\\\n", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String customDelimiter = escapeSpecialCharacters(parts[0].substring(2));
        String combinedDelimiters = customDelimiter + "|[,:]";
        return parts[1].split(combinedDelimiters);
    }

    @Override
    public boolean matches(String input) {
        return input.startsWith("//");
    }

    private String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\[\\]{}()*+?^$|])", "\\\\$1");
    }
}
