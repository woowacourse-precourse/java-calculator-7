package service;

import domain.Number;

public class CalculatorService {
    public int sum(int[] numbers){
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public Number tokenizeInput(String input){
        int[] numbers;
        if(input.startsWith("//")){
            numbers = splitByCustomDelimiter(input);
        }
        else if(input.matches("^\\d.*")){
            numbers = splitByDelimiter(input);
        }
        else{
            throw new IllegalArgumentException("Invalid input");
        }
        return new Number(numbers);
    }

    public int[] splitByCustomDelimiter(String input){

    }

    public int[] splitByDelimiter(String input){

    }
}
