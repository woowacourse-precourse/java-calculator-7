package calculator;

public class InputData {
    private InputType inputType;
    private String userInput;

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public InputType getInputType(){
        return this.inputType;
    }

    public String getUserInput(){
        return this.userInput;
    }
}
