package calculator.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {
    private String userInput;
    private List<String> delimiters = new ArrayList<>();
    private ArrayList<Integer> integers;
    private boolean numberStarting;

    //Generator: 기본 구별자, 유저 입력 값 설정
    public Calculator(String userInput) {
        this.userInput = userInput;
        delimiters.add(",");
        delimiters.add(":");
    }

    //getIntegers(): 구분자를 사용하여 문자열에서 숫자만 분리하기
    private List<Integer> getIntegers(){
        String newUserInput = getNewUserInput();

        if (newUserInput == null) {
            return new ArrayList<Integer>(List.of(0));
        }

        //연산자 모두 합치기
        String completeDelimiter = "";
        for (String delimiter : delimiters) {
            completeDelimiter += delimiter + "|";
        }

        StringTokenizer stringTokenizer = new StringTokenizer(newUserInput, completeDelimiter);
        List<Integer> resultIntegers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            int outInteger = Integer.parseInt(stringTokenizer.nextToken());
            resultIntegers.add(outInteger);
        }

        return resultIntegers;
    }

    //print(): 결과인 합을 계산
    public int print() {
        int sum = 0;
        for (Integer integer : getIntegers()) {
            sum += integer;
        }

        return sum;
    }

}
