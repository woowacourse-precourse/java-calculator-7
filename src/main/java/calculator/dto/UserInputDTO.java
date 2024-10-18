package calculator.dto;

public class UserInputDTO {
    private final String operandStr;

    public UserInputDTO(String operandStr) {
        this.operandStr = operandStr;
    }

    public String getOperandStr() {
        return operandStr;
    }
}
