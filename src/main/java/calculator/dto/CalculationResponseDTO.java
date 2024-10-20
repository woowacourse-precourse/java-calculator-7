package calculator.dto;

public class CalculationResponseDTO {
    private Long sumResult;

    public CalculationResponseDTO(Long sumResult) {
        this.sumResult = sumResult;
    }

    public Long getSumResult() {
        return sumResult;
    }

    public static CalculationResponseDTO createCalculationResponseDTO(Long sumResult) {
        return new CalculationResponseDTO(sumResult);
    }
}
