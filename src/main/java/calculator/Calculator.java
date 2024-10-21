package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    // 문자열 구분자
    StringBuilder delimiter = new StringBuilder(",|:");
    int sum = 0;

    // 실행 함수
    public void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if(str.isEmpty()){
            System.out.println("결과: 0");
            return;
        }
        // 구분자로 문자열 분리, 저장
        String[] splitNumbers = str.split(delimiter.toString());

        // 하나씩 합산
        for (int i = 0; i < splitNumbers.length; i++) {
            sum += Integer.parseInt(splitNumbers[i]);
        }
        // 출력
        System.out.println("결과: " + sum);
    }
}