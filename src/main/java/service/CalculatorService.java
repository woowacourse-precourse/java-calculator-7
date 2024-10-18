package service;

import domain.Number;

public class CalculatorService {
    public int sum(Number number){
        int sum = 0;
        int[] numbers = number.getNumbers();
        for(int i : numbers){
            sum += i;
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
            throw new IllegalArgumentException("유효하지 않은 형식입니다.");
        }
        return new Number(numbers);
    }

    public int[] splitByCustomDelimiter(String input){

    }

    public int[] splitByDelimiter(String input){

    }
}
