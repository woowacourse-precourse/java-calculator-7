package calculator;

public class Separator {
    private StringBuilder separator;
    private String[] dividedInput;
    private String[] numbers;

    Separator(){
        this.separator = new StringBuilder("[,:]");
    }

    void divideInput(String input){
        dividedInput = input.split("\\\\n");
    }

    void insertCustomSeparator(){
        separator.insert(1, dividedInput[0].substring(2));
    }

    void splitWIthSeparater(String input){
        numbers = input.split(separator.toString());
    }

    void splitWithCustomSeparater(){
        numbers = dividedInput[1].split(separator.toString());
    }

    String[] getNumbers(){
        return numbers;
    }
}
