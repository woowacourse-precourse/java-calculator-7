package calculator.model;


public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String getNumbers(){
        return this.numbers;
    }

    private String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (int i = 0; i < splitedNumbers.length; i++) {
            int intNumber = Integer.parseInt(splitedNumbers[i]);
            sumOfNumbers = sumOfNumbers + intNumber;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
