package calculator.domain.dto;

public class ResultDTO {
    private int result;

    public ResultDTO(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
