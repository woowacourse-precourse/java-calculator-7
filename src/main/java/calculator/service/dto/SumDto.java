package calculator.service.dto;

public record SumDto(int value) {

    public static SumDto from(int value) {
        return new SumDto(value);
    }
}
