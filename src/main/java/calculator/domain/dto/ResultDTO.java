package calculator.domain.dto;

public class ResultDTO {
    private int result;

    public ResultDTO(int result) {
        this.result = result;
    }
    //getter
    public int getResult() {
        return result;
    }
    //setter
    public void setResult(int result) {
        this.result = result;
    }
}
