package calculator;

public class Calculator {
    public  int calculate(String input){
        if (input == null || input.trim().isEmpty()){
            return 0;
        }

        // input 형식에 따라서 다르게 분리하여 덧셈할 숫자 배열 획득
        DelimiterStrategy delimiterStrategy = DelimiterStrategyFactory.getDelimiterStrategy(input);
        String[] numbers = delimiterStrategy.split(input);

        return addNumbers(numbers);
    }

    /**
     * 입력된 문자열 배열을 구분하여 숫자를 더하는 함수
     *
     * @param numbers 구분자로 나눠진 배열
     * @return -1이 반환될 경우 예외처리를 진행함.
     */
    private int addNumbers(String[] numbers){
        int sum = 0;
        for (String num : numbers){
            try{
                int addNum = Integer.parseInt(num);
                if (addNum < 0) return -1;
                sum += addNum;
            }catch (NumberFormatException e){
                return -1;
            }
        }

        return sum;
    }

}
