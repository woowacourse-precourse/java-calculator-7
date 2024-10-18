package service;

import domain.Number;

import java.util.regex.Pattern;

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
        else if(input.matches("[0-9,:].*")){
            numbers = splitByDelimiter(input);
        }
        else{
            throw new IllegalArgumentException("유효하지 않은 형식입니다.");
        }
        return new Number(numbers);
    }

    public int[] splitByCustomDelimiter(String input){
        String delimiter = getDelimiter(input);
        String numberString = input.substring(delimiter.length() + 3);  //줄바꿈 문자 뒤의 유효한 숫자 문자열만 추출
        if(numberString.matches("[0-9" + Pattern.quote(delimiter) + "]+$")){
                String[] arr = numberString.split(Pattern.quote(delimiter));
                int[] numbers = new int[arr.length];
                for(int i = 0; i < arr.length; i++){
                    numbers[i] = Integer.parseInt(arr[i]);
                }
                return numbers;
        }
        else{
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
    }

    public String getDelimiter(String input){
        if(input.matches("//.+\n.*")){
            String delimiter = input.substring(2, input.lastIndexOf("\n"));
            return delimiter;
        }
        else{
            throw new IllegalArgumentException("구분자를 지정하는 형식이 올바르지 않습니다.");
        }
    }

    public int[] splitByDelimiter(String input){
        String[] arr;
        int[] numbers;
        if(input.matches("[^0-9,:]+$")){
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
        arr = input.split(",|:");
        numbers = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            numbers[i] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }
}
