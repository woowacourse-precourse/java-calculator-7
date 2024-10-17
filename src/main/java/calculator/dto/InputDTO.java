package calculator.dto;

public class InputDTO {
    private String userInput;

    public InputDTO(){
    }

    public InputDTO(String userInput){
        this.userInput = userInput;
    }

    public String getUserInput(){
        return userInput;
    }

    public void setUserInput(String userInput){
        this.userInput=userInput;
    }

    @Override
    public String toString(){
        return "InputDTO{" +
                "userInput='" + userInput + '\'' +
                '}';
    }


}
