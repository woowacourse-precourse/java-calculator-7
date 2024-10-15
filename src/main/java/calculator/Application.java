package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : ";

    public static void main(String[] args) {
        //1. 입력 받기
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        //2. 입력에 대해, 커스텀 구분자를 확인하여, 구분자에 추가해줌

        //3. 기본 구분자와 커스텀 구분자를 통해, 숫자를 구분함

        //4. 숫자가 아닌 문자에 대한 예외 처리 진행

        //5. 각각의 숫자에 연산자를 통해, 결과값 얻기

        //6. 결과 출력
        System.out.println(OUTPUT_MESSAGE + input);
    }
}
