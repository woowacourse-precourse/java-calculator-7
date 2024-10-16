package calculator.controller;

public class NumberChecker {
    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
