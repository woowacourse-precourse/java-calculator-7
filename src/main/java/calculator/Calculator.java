package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {
    private final String userInput;
    private final List<String> delimiters;
    private ArrayList<Integer> integers;

    //Generator: 기본 구별자, 유저 입력 값 설정
    public Calculator(String userInput) {
        DelimiterProcess delimiterProcess = new DelimiterProcess(userInput);
        delimiters = delimiterProcess.getDelimiters();
        this.userInput = delimiterProcess.getUserInput();
    }

    //print(): 결과인 합을 계산
    public int printResult() {
        int sum = 0;

        for (Integer integer : getIntegers()) {
            sum += integer;
        }

        return sum;
    }

    //getIntegers(): 구분자를 사용하여 문자열에서 숫자만 분리하기
    private List<Integer> getIntegers(){

        String DelimTotal = getDelimTotal();

        StringTokenizer stringTokenizer = new StringTokenizer(userInput, completeDelimiter);
        List<Integer> resultIntegers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            int outInteger = Integer.parseInt(stringTokenizer.nextToken());
            resultIntegers.add(outInteger);
        }

        return resultIntegers;
    }

    //getDelimTotal(): 연산자 모두 합쳐서 String 정규식으로 만들기
    private String getDelimTotal() {
        StringBuilder DelimTotal = new StringBuilder();
        for (String delimiter : delimiters) {
            DelimTotal.append(delimiter).append("|");
        }
        return DelimTotal.toString();
    }


}
