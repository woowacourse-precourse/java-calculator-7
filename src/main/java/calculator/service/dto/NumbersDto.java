package calculator.service.dto;

import java.util.List;

public record NumbersDto(List<NumberDto> values) {

    public static NumbersDto from(List<NumberDto> values) {
        return new NumbersDto(values);
    }
}
