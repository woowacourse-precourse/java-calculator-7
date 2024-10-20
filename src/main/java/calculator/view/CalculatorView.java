package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private CalculatorView() {
    }

    private static class SingletonHelper {
        private static final CalculatorView INSTANCE = new CalculatorView();
    }

    public static CalculatorView getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public String inputText() {
        System.out.println(beforeInput);
        return Console.readLine();
    }

    public void outputAnswer(int answer) {
        System.out.println("결과 : " + answer);
    }

    public void error(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void describe() {
        System.out.println(description);
    }


    String beforeInput = """
            
            문자열 계산기를 적용할 문자열을 입력해주세요. 예시) 1,2:3, //;\\n1;2;3
            """;

    String description = """
            ==========================================================
                                문자열 계산기 설명서
            
            구분자로 구분되는 숫자를 모두 더한 값을 출력하는 프로그램입니다.
            이 때, 숫자는 1~9까지의 수이고, 구분자는 한 글자여야 합니다.
            기본 구분자는 ','와 ':' 입니다.
            
            사용 방법
            1. 계산기에 사용할 수 있는 문자열은 빈 문자열 또는 숫자가 문자열의
               양끝이고, 숫자와 구분자가 번갈아가면서 등장하는 문자열이어야 합니다.
               1,2,3 (o)   1,:23 (x)   :1,2:3, (x)
            
            2. 기본 구분자 이외에 커스텀 구분자를 지정할 수 있습니다.
               '//(구분자)\\n' 형식으로 문자열의 앞부분에 적으면
                원하는 구분자를 추가할 수 있습니다.
               //;\\n1;2;3 -> ';'을 커스텀 구분자로 추가한 예시입니다.
            
            3. 커스텀 구분자는 여러개 지정할 수 있습니다.
               '//(구분자)\\n' 형식을 문자열 앞부분에 이어서 나열하면 됩니다.
               //;\\//+\\1;2+3 -> ';'와 '+'를 커스텀 구분자로 추가합니다.
            
            ==========================================================
            """;

}
