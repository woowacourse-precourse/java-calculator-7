package calculator;

public class Validator {
    StringBuilder val = new StringBuilder("^[1-9,:]*$");
    void validateInput(String input){
        if (!input.matches(val.toString())) throw new IllegalArgumentException("[ERROR].");
    }
    void validateCustomInput(String input, String custom){
        val.insert(2, custom);
        if (!input.matches(val.toString())) throw new IllegalArgumentException("[ERROR].");
    }
}
