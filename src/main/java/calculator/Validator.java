package calculator;

public class Validator {
    private static final char[]DEFAULT_DELIMITERS = {',', ':'};
    private char customDelimiter = ' ';
    public void isValid(String input){
        if(hasCustomDelimiter(input)){
            customDelimiter = input.charAt(2);
            validateCustomDelimiter();
            validateInputCharacters(input, 5);
        }
        else{
            validateInputCharacters(input,0);
        }
    }

    private void validateInputCharacters(String input, int start) {
        for(int i = start; i<input.length(); i++){
            char currentChar = input.charAt(i);
            if(!isDelimiter(currentChar) && !Character.isDigit(currentChar)){
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isDelimiter(char currentChar) {
        for(char ch : DEFAULT_DELIMITERS){
            if(ch==currentChar || ch==customDelimiter){
                return true;
            }
        }
        return false;
    }

    private void validateCustomDelimiter() {
        if(Character.isDigit(customDelimiter)){
            throw new IllegalArgumentException();
        }
    }
    private boolean hasCustomDelimiter(String input) {
        String pattern = "^//.\\\\n.*";
        return input.matches(pattern);
    }

}
