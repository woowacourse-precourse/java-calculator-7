package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInputText = readLine(); //구현 요구 사항중 해당 라이브러리만을 사용하여 구현해야 하는 항목 충족
        try {
            InputValidation.validateInput(userInputText);
            String[] textValues = SplitText.textSplit(userInputText);
            int[] sumValues = ValueCheck.checkValue(textValues);
            int result = ValueSum.sumValue(sumValues);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
            throw e;
        }
    }
}
