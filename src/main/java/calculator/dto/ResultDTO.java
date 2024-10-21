package calculator.dto;

public class ResultDTO {
    private final String message = "결과 : ";
    private final Long result;

    public ResultDTO(Long result) {
        this.result = result;
    }

    public String toString() {
        return message + result;
    }
}
