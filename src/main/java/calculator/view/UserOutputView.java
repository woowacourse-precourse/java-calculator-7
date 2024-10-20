package calculator.view;

import calculator.dto.AddCalculatorResponse;

public class UserOutputView {
    public static void printAddStartMessage(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printAddResultMessage(AddCalculatorResponse response){
        System.out.printf("결과 : %d", response.sum());
    }
}
