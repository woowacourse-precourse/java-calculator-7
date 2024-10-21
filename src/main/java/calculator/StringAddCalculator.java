package calculator;

public class StringAddCalculator {
    public static int splitInput(String input){
        if(isNullOrEmpty(input)){
            return 0;
        }
    }

    private static boolean isNullOrEmpty(String input){
        return input == null || input.isEmpty();
    }
}
