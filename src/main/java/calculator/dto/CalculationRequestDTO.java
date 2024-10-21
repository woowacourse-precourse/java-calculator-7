package calculator.dto;

public class CalculationRequestDTO {
    private String inputString;

    public CalculationRequestDTO(String inputString){
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String requestInput) {
        inputString = requestInput;
    }

    public static CalculationRequestDTO createCalculationRequestDTO(String inputString) {
        return new CalculationRequestDTO(inputString);
    }
}
