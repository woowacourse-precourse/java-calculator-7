package calculator.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Input {
    List<String> delim;
    double[] inputNumbers;

    Input(String input){
        delim = new ArrayList<>();
        delim.add(":");
        delim.add(",");
        getNumbersFromInput(input);
        isPositiveNumber();
    }

    /**
     * 사용자 입력한 문자열의 합을 계산함.
     * @return : 계산기 합산 결과
     */
    public double sum(){
        return Arrays.stream(inputNumbers).sum();
    }

    /**
     * 유저로부터 받은 입력을 배열(inputNumbers)로 파싱하는 메소드
     * @param : 유저로부터 입력받은 엽력
     */
    abstract void getNumbersFromInput(String userInput);

    /**
     * 유저로부터 받은 input을 구분자로 나누는 메소드
     * @param : UserInput (유저로부터 받은 input)
     * @return : String[]
     */
    abstract String[] splitByDelimiter(String userInput);


    /**
     * 문자를 숫자로 변환하는 메소드
     * @param : 구분자로 불리된 String
     * @return : (Double) 숫자
     */
    // 숫자 변환 로직을 분리한 메소드
    double convertToDouble(String value) {
        try {
            return Double.parseDouble(value);  // 숫자로 변환 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값 중 숫자가 아닌 값이 있습니다: " + value);
        }
    }

    /**
     * 양수인지 확인하는 메소드
     */
    private void isPositiveNumber(){
        for(double num : inputNumbers) {
            if (num < 0) {
                throw new IllegalStateException("양수를 입력해주세요");
            }
        }
    }



}
