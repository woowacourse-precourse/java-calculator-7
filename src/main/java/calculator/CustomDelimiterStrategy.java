package calculator;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private String[] customDelimiter;

    public CustomDelimiterStrategy(String customDelimiter) {
        this.customDelimiter = parseDelimiter(customDelimiter);
    }


    @Override
    public String[] split(String input) {
//        return input.split(customDelimiter);
    }

    private String[] parseDelimiter(String delimiter) {
        String[] customs = delimiter.split("");

        for (String custom : customs) {
            // 구분자가 숫자인지 확인
            if (Character.isDigit(custom.charAt(0))) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다: " + custom);
            }
        }

        return customs;
    }
}
