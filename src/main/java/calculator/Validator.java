package calculator;

public class Validator {

    public boolean isCustom(String inputString){
        String regex = "^//.\\\\n.*$";
        return inputString.matches(regex);
    }
}
