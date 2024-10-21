package calculator.service.dto;

public record NumberDto(int value) {

    public static NumberDto from(int value) {
        return new NumberDto(value);
    }
}
