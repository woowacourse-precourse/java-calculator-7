package calculator.stringCalculator;

import calculator.validator.InputParser;

public class StringCalculator implements Calculator{

    @Override
    public int add(String input) throws IllegalArgumentException {
        if(input == null || input.isEmpty()){           //input이 정상적이지 않다면 오류 발생
            throw new IllegalArgumentException("값이 정상적으로 입력되지 않았습니다.");
        }

        if(input.length() > 11){            //입력 문자열의 길이가 11을 초과하면 오류 발생
            throw new IllegalArgumentException("입력 길이는 11을 초과할 수 없습니다.");
        }

        InputParser inputParser = new InputParser();
        String[] numbers = inputParser.parse(input);        //입력된 문자열 파싱
        return calculateSum(numbers);                       //파싱 된 문자열로 계산 수행
    }

    private int calculateSum(String[] numbers) throws IllegalArgumentException{
        int sum = 0;        //합 저장할 변수 선언
        for(String number: numbers){
            int num = toInteger(number);        //각 문자로 된 수 정수로 변환
            sum += num;                         //sum에 더해줌
        }

        return sum;
    }

    private int toInteger(String number) throws IllegalArgumentException{       //문자를 정수로 변환시키는 메소드
        try{
            int num = Integer.parseInt(number);     //문자를 숫자로 변환
            if(num < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다");
            }
            return num;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("유효ㅎ한 숫자가 아닙니다.");
        }
    }
}
