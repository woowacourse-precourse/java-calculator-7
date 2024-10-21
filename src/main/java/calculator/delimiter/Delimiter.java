package calculator.delimiter;

import calculator.dto.DelimiterDto;

public class Delimiter {

    private String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public DelimiterDto toDto() {
        return new DelimiterDto(delimiter);
    }

}
