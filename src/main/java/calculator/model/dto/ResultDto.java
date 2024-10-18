package calculator.model.dto;

public class ResultDto {
    private int result;

    public ResultDto(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }

    public void addResult(int number) {
        this.result+=number;
    }
}
