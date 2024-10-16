package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String userInput = Console.readLine();

            InputInfo inputInfo = new InputInfo();
            inputInfo.validateInput(userInput);

            /*
                AddCalculator 객체에 inputInfo field 전달 후, format에 맞에 계산
             */

        } catch(IllegalArgumentException e) {
            return;
        }




    }
}
