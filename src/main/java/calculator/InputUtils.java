package calculator;

public class InputUtils {
    private static String delimiter = "[,:]";
    public static String[] splitInputs(String input){
        return input.split(delimiter);
    }
    public static int[] StringToNumber(String[] inputs){
        int[] numbers = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        return numbers;
    }
}
