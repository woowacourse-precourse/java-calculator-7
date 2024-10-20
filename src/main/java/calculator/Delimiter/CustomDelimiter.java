package calculator.Delimiter;

public class CustomDelimiter implements Delimiter {
    @Override
    public boolean supports(String input) {
        return input.startsWith("//");
    }

    @Override
    public String[] splitStringArray(String input) {
        try {
            String[] tokens = input.split("\\\\n");
            String delimiter = tokens[0].substring(2);
            return tokens[1].split(delimiter);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 형식의 값을 입력하였습니다" + input);
        }
    }
}
