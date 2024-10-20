package calculator.model;

public class ValidationTest extends Exception {

    private static final ValidationTest instance = new ValidationTest();

    private ValidationTest() {}

    public static ValidationTest getInstance() {
        return instance;
    }

    public void stringValidationTest(String input) {
        emptyTest(input);
        invalidCharacterTest(input.replace(" ",""));
    }
    private void emptyTest(String input){
        if(input.isEmpty()) throw new IllegalArgumentException("String cannot be empty");
    }
    private void invalidCharacterTest(String input){
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("String must contain only positive numbers");
        }
    }
}
