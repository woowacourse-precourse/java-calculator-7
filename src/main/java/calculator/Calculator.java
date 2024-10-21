package calculator;

public class Calculator {

    public int calculator(String input){

        // input없으면 0을 리턴
        if(input.isEmpty()){
            return 0;
        }

        String delimiter = ",|:";
        String numberString = input;

        // "//"로 시작하고 "\n"으로끝나는 문자열일 시 그 사이값 구하기
        if(input.startsWith("//")){
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            numberString = input.substring(delimiterIndex+1);
        }

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
