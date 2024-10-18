package calculator.model;


public class Calculator {
    public String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (int i = 0; i < splitedNumbers.length; i++) {
            int intNumber = Integer.parseInt(splitedNumbers[i]);
            sumOfNumbers = sumOfNumbers + intNumber;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
