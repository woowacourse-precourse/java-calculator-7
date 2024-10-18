package calculator.model;

public class CustomDelimiter extends Delimiter {
    public CustomDelimiter(String delimiter) {
        super(delimiter);
    }

    @Override
    public void validate() {
        if (delimiter.length() > 3) {
            throw new IllegalArgumentException("[ERROR][R0001] 커스텀 구분자는 최대 3개까지 등록 가능합니다.");
        }
    }
}
