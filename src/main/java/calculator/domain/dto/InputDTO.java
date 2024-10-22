package calculator.domain.dto;

public class InputDTO {
    private  String input;

    public InputDTO(String input) {
        this.input = input;
    }
    //getter
    public String getInput() {
        return input;
    }
    //setter
    public void setInput(String input) {
        this.input = input;
    }

}