package calculator;

import java.util.ArrayList;
import java.util.List;

public class IntegerService {
    private final String input;
    private final String delimiters;
    private List<Integer> integers;

    public IntegerService(String input, String delimiters) {
        this.input = input;
        this.delimiters = delimiters;
    }

    //getIntegers(): 구분자를 사용하여 문자열에서 숫자만 분리하기
    protected void getIntegers(){
        String[] tokens = input.split(delimiters);
        integers = new ArrayList<>();

        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                integers.add(Integer.parseInt(token));
            }
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


}
