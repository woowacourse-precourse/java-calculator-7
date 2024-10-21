package calculator;

public class Calculator {
    private int[] intArray;

    void convertStringArrayToIntArray(String[] numbers){
        this.intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) intArray[i] = Integer.parseInt(numbers[i].trim());
    }

    int calculateResult(){
        int result = 0;
        for (int num : intArray) result += num;
        return result;
    }
}
