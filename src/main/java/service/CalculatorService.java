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
            return new Number(numbers);
        }
        else if(input.matches("^\\d.*")){
            numbers = splitByDelimiter(input);
            return new Number(numbers);
        }
        else{
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public int[] splitByCustomDelimiter(String input){

    }

    public int[] splitByDelimiter(String input){

    }
}
