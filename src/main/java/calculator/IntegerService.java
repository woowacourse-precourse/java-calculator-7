package calculator;

import java.util.ArrayList;
import java.util.List;

public class IntegerService {
    private final String input;
    private final String delimiterRegex;
    private List<Integer> integers;

    public IntegerService(String input, String delimiters) {
        this.input = input;
        this.delimiterRegex = delimiters;
    }

    //getIntegers(): 구분자를 사용하여 문자열에서 숫자만 분리하기
    protected void getIntegers(){
        String[] tokens = input.split(delimiterRegex);
        integers = new ArrayList<>();

        for (String token : tokens) {
            token = token.trim();
            Integer integerToken = isCorrectToken(token);
            integers.add(integerToken);
        }
    }

    //printSum(): 결과인 합을 계산
    protected void printSum() {
        int sum = 0;

        for (Integer integer : integers) {
            sum += integer;
        }

        System.out.println("결과 : " + sum);
    }

    //isCorrectToken(): 유효한 숫자값 검사 - 음수, 소수, 문자일 때 예외처리
    private Integer isCorrectToken(String token) {
        if(token.isEmpty()) {
            return 0;
        }

        if(!token.matches("\\d+")) {
           throw new IllegalArgumentException("잘못된 숫자 입력입니다. 0과 자연수만 계산 가능합니다.");
        }

        return Integer.parseInt(token);
    }


}
