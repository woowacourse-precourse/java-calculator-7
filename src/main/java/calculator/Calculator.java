package calculator;

public class Calculator {
    public int calculator(String input){

        // input없으면 0을 리턴
        if(input.isEmpty()){
            return 0;
        }

        String delimiter = ",|:";
        String numberString = input;

        //String delimiter로 자르기
        String[] numbers = numberString.split(delimiter);
        return sumString(numbers);
    }

    //잘린 String 더하기
    private int sumString(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
